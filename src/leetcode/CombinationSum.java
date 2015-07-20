/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author SONGSONG
 */
public class CombinationSum {

public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = candidates.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (candidates[i] > candidates[j]) {
                    int tmp = candidates[i];
                    candidates[i] = candidates[j];
                    candidates[j] = tmp;
                }
            }
        }

        if (length == 0||target < candidates[0]) {
            return result;
        }

        if (target == candidates[0]) {
            List<Integer> sub = new ArrayList<Integer>();
            sub.add(candidates[0]);
            result.add(sub);
            return result;
        }
        int max;
        for (int i = length - 1; i >= 0; i--) {
            max = target / candidates[i];
            for (int j = max; j > 0; j--) {
                int newtarget = target - candidates[i] * j;
                if (newtarget == 0) {
                    List<Integer> sub = new ArrayList<Integer>();
                    for (int k = 0; k < j; k++) {
                        sub.add(candidates[i]);
                    }
                    result.add(sub);
                } else {
                    List<List<Integer>> tmp = combinationSum(Arrays.copyOfRange(candidates, 0, i), target - candidates[i] * j);
                    for (List<Integer> sub : tmp) {
                        for (int k = 0; k < j; k++) {
                            sub.add(candidates[i]);
                        }
                        result.add(sub);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[1];
        a[0] = 1;
        combinationSum(a, 2);
    }
}
