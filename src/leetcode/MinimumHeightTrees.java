/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            boolean[] status = new boolean[n];
            int current = countDepth(status, i, map);
            if (min > current) {
                res.clear();
                res.add(i);
            } else if (min == current) {
                res.add(i);
            }
        }
        return res;
    }

    public int countDepth(boolean[] status, int i, Map<Integer, List<Integer>> map) {
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                for (int tmp : map.get(queue.peek())) {
                    if (!status[tmp]) {
                        queue.add(tmp);
                    }
                }
                status[queue.poll()] = true;
            }
            depth++;
        }
        return depth;
    }

    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        ArrayList<HashSet<Integer>> map = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map.add(new HashSet<Integer>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 1) {
                res.add(i);
            }
        }
        while (n > 2) {
            n -= res.size();
            List<Integer> newres = new ArrayList<>();
            for (int tmp : res) {
                int j = map.get(tmp).iterator().next();
                map.get(j).remove(tmp);
                if (map.get(j).size() == 1) {
                    newres.add(j);
                }
            }
            res = newres;
        }
        return res;
    }
}
