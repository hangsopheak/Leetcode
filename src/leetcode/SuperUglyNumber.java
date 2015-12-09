/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author SONGSONG
 */
public class SuperUglyNumber {

    class pair {

        int value;
        int index;

        public pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }

    public int nthSuperUglyNumber1(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        PriorityQueue<pair> queue = new PriorityQueue<>(3, new Comparator<pair>() {

            @Override
            public int compare(pair a, pair b) {
                return a.getValue() - b.getValue();
            }
        });
        int length = primes.length;
        int[] num = new int[length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 0; i < length; i++) {
            queue.add(new pair(primes[i] * ugly[num[i]], i));
        }
        for (int i = 1; i < n; i++) {
            ugly[i] = queue.peek().getValue();
            while (ugly[i] == queue.peek().getValue()) {
                int tmp = queue.poll().getIndex();
                num[tmp]++;
                queue.add(new pair(primes[tmp] * ugly[num[tmp]], tmp));
            }
        }
        return ugly[n - 1];
    }

    public int nthSuperUglyNumber2(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int length = primes.length;
        int[] nums = new int[length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                min = Math.min(min, primes[j] * ugly[nums[j]]);
            }
            ugly[i] = min;
            for (int j = 0; j < length; j++) {
                if (min == primes[j] * ugly[nums[j]]) {
                    nums[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}
