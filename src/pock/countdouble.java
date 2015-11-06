/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pock;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class countdouble {

    static int countDuplicates(int[] input) {
        int result = 0;
        for (int i : input) {
            int j = Math.abs(i);
            if (input[j - 1] < 0) {
                result++;
            } else {
                input[j - 1] *= -1;
            }
        }
        return result;
    }

    static int countDuplicateshash(int[] input) {
        int result = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i : input) {
            if (hash.containsKey(i)) {
                if (hash.get(i) == 1) {
                    result++;
                    hash.put(i, 2);
                } else if (hash.get(i) == 2) {
                    result--;
                    hash.put(i, 3);
                }
            } else {
                hash.put(i, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] inputs = {1, 2, 2, 3, 4, 5, 5, 3, 1, 4, 4, 4};
        int r = countDuplicateshash(inputs);
        System.out.println(r);
    }
}
