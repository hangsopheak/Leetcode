/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pock;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author SONGSONG
 */
public class KthFrequence {

    /**
     * get the kth most frequent integer in array
     *
     * @param input
     * @param k
     * @return
     */
    // O(nlogk)
    static List<Integer> kthFrequence(int[] input, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : input) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        PriorityQueue<Entry<Integer, Integer>> maxHeap = new PriorityQueue(5, new Comparator<Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
                return a.getValue().compareTo(b.getValue());
            }
        });

        PriorityQueue<Entry<Integer, Integer>> minHeap = new PriorityQueue(5, new Comparator<Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });

        for (Entry<Integer, Integer> e : map.entrySet()) {
            if (maxHeap.size() < k) {
                maxHeap.add(e);
            } else {
                if (maxHeap.peek().getValue() <= e.getValue()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(e);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty() && minHeap.peek().getValue().compareTo(maxHeap.peek().getValue()) == 0) {
            res.add(minHeap.poll().getKey());
        }
        while (!maxHeap.isEmpty()) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }

    /**
     * For test only
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 6};
        List<Integer> result = kthFrequence(input, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
