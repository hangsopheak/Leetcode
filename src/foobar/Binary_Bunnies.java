/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foobar;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author SONGSONG Binary bunnies ==============
 *
 * As more and more rabbits were rescued from Professor Booleans horrid
 * laboratory, you had to develop a system to track them, since some habitually
 * continue to gnaw on the heads of their brethren and need extra supervision.
 * For obvious reasons, you based your rabbit survivor tracking system on a
 * binary search tree, but all of a sudden that decision has come back to haunt
 * you.
 *
 * To make your binary tree, the rabbits were sorted by their ages (in days) and
 * each, luckily enough, had a distinct age. For a given group, the first rabbit
 * became the root, and then the next one (taken in order of rescue) was added,
 * older ages to the left and younger to the right. The order that the rabbits
 * returned to you determined the end pattern of the tree, and herein lies the
 * problem.
 *
 * Some rabbits were rescued from multiple cages in a single rescue operation,
 * and you need to make sure that all of the modifications or pathogens
 * introduced by Professor Boolean are contained properly. Since the tree did
 * not preserve the order of rescue, it falls to you to figure out how many
 * different sequences of rabbits could have produced an identical tree to your
 * sample sequence, so you can keep all the rescued rabbits safe.
 *
 * For example, if the rabbits were processed in order from [5, 9, 8, 2, 1], it
 * would result in a binary tree identical to one created from [5, 2, 9, 1, 8].
 *
 * You must write a function answer(seq) that takes an array of up to 50
 * integers and returns a string representing the number (in base-10) of
 * sequences that would result in the same tree as the given sequence.
 *
 * Languages =========
 *
 * To provide a Python solution, edit solution.py To provide a Java solution,
 * edit solution.java
 *
 * Test cases ==========
 *
 * Inputs: (int list) seq = [5, 9, 8, 2, 1] Output: (string) "6"
 *
 * Inputs: (int list) seq = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] Output: (string) "1"
 *
 *
 */
public class Binary_Bunnies {

    public static String answer(int[] seq) {
        int length = seq.length;
        int[] large = new int[length];
        int[] small = new int[length];
        int[] max = new int[length];
        int[] min = new int[length];
        Arrays.fill(max, Integer.MAX_VALUE);
        Arrays.fill(min, Integer.MIN_VALUE);
        recus(large, small, max, min, 0, seq);
        BigInteger res = new BigInteger(String.valueOf(1));
        for (int i = 0; i < length; i++) {
            BigInteger tmp = helper(large[i] + small[i]);
            tmp = tmp.divide(helper(large[i])).divide(helper(small[i]));
            res = res.multiply(tmp);
        }
        return res.toString();
    }

    public static void recus(int[] large, int[] small, int[] max, int[] min, int index, int[] seq) {
        if (index == seq.length) {
            return;
        }
        int root = seq[index];
        for (int i = index + 1; i < seq.length; i++) {
            if (seq[i] > root && seq[i] < max[index]) {
                large[index]++;
                min[i] = Math.max(min[i], root);
            }
            if (seq[i] < root && seq[i] > min[index]) {
                small[index]++;
                max[i] = Math.min(max[i], root);
            }
        }
        recus(large, small, max, min, index + 1, seq);
    }

    public static BigInteger helper(int input) {
        BigInteger ret = new BigInteger(String.valueOf(1));
        while (input >= 1) {
            ret = ret.multiply(new BigInteger(String.valueOf(input--)));
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {5, 9, 8, 2, 1};
        System.out.println(answer(a));
    }
}
