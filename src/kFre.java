
import java.util.*;
import java.util.Map.Entry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SONGSONG
 */
public class kFre {

    /**
     * find the Kth frequent number in an int array
     *
     * @param input
     * @param k
     * @return
     */
    public static int findKFre(int[] input, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i : input) {
            if (hash.containsKey(i)) {
                hash.put(i, hash.get(i) + 1);
            } else {
                hash.put(i, 1);
            }
        }

        PriorityQueue<Entry<Integer, Integer>> topK = new PriorityQueue<>(k, new Comparator<Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        for (Entry<Integer, Integer> e : hash.entrySet()) {
            if (topK.size() < k) {
                topK.add(e);
            } else {
                if (topK.peek().getValue().compareTo(e.getValue()) < 0) {
                    topK.poll();
                    topK.add(e);
                }
            }
        }
        return topK.peek().getValue();
    }

    public static void main(String[] arg) {
        int[] input = {1, 1, 2, 3, 3, 3, 4, 4, 4, 4};
        System.out.println(findKFre(input, 4));
    }
}
