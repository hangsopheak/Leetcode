/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foobar;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author SONGSONG Undercover underground ======================
 *
 * As you help the rabbits establish more and more resistance groups to fight
 * against Professor Boolean, you need a way to pass messages back and forth.
 *
 * Luckily there are abandoned tunnels between the warrens of the rabbits, and
 * you need to find the best way to use them. In some cases, Beta Rabbit wants a
 * high level of interconnectedness, especially when the groups show their
 * loyalty and worthiness. In other scenarios the groups should be less
 * intertwined, in case any are compromised by enemy agents or zombits.
 *
 * Every warren must be connected to every other warren somehow, and no two
 * warrens should ever have more than one tunnel between them. Your assignment:
 * count the number of ways to connect the resistance warrens.
 *
 * For example, with 3 warrens (denoted A, B, C) and 2 tunnels, there are three
 * distinct ways to connect them:
 *
 * A-B-C A-C-B C-A-B
 *
 * With 4 warrens and 6 tunnels, the only way to connect them is to connect each
 * warren to every other warren.
 *
 * Write a function answer(N, K) which returns the number of ways to connect N
 * distinctly labelled warrens with exactly K tunnels, so that there is a path
 * between any two warrens.
 *
 * The return value must be a string representation of the total number of ways
 * to do so, in base 10. N will be at least 2 and at most 20. K will be at least
 * one less than N and at most (N * (N - 1)) / 2
 *
 * Languages =========
 *
 * To provide a Python solution, edit solution.py To provide a Java solution,
 * edit solution.java
 *
 * Test cases ==========
 *
 * Inputs: (int) N = 2 (int) K = 1 Output: (string) "1"
 *
 * Inputs: (int) N = 4 (int) K = 3 Output: (string) "16"
 *
 */
public class undercover_underground {

    static Map<String, BigInteger> hash = new HashMap<>();

    public static String answer(int N, int K) {
        return helper(N, K).toString();
    }

    public static BigInteger helper(int N, int K) {
        if (K < N - 1) {
            return BigInteger.ZERO;
        } else if (K == N - 1) {
            return BigInteger.valueOf((int) Math.pow(N, N - 2));
        } else {
            String key = key(N, K);
            if (!hash.containsKey(key)) {
                hash.put(key, helper_special(N, K));
            }
            return hash.get(key);
        }
    }

    public static BigInteger helper_special(int N, int K) {
        BigInteger res = combination(N * (N - 1) / 2, K);
        for (int i = 0; i <= N - 2; i++) {
            BigInteger p_sum = BigInteger.ZERO;
            for (int p = 0; p <= K; p++) {
                int line_sum = (N - 1 - i) * (N - 2 - i) / 2;
                p_sum = p_sum.add(combination(line_sum, p).multiply(helper(i + 1, K - p)));
            }
            res = res.subtract(combination(N - 1, i).multiply(p_sum));
        }
        return res;
    }

    static Map<String, BigInteger> combination = new HashMap<>();

    public static BigInteger combination(int n, int k) {
        if (k > n) {
            return BigInteger.ZERO;
        } else {
            String key = key(n, k);
            if (!combination.containsKey(key)) {
                BigInteger res = BigInteger.ONE;
                for (int i = 0; i < k; i++) {
                    int tmp = n - i;
                    res = res.multiply(new BigInteger("" + tmp));
                }
                for (int i = k; i > 0; i--) {
                    res = res.divide(new BigInteger("" + i));
                }
                combination.put(key, res);
            }
            return combination.get(key);
        }
    }

    public static String key(int N, int K) {
        return N + ", " + K;
    }

    public static void main(String[] args) {
        int N = 20;
        int K = 20;
        System.out.println(answer(N, K));
        System.out.println(Answer.answer(N, K));
    }
}
