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
public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int length = candidates.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean status = true;
        for (int i = length - 1; i >= 0; i--) {
            if (candidates[i] == target && status) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(target);
                result.add(tmp);
                status = false;
            } else if (candidates[i] < target) {
                TowSum(Arrays.copyOfRange(candidates, 0, i + 1), target, new ArrayList<Integer>(), result);
                break;
            }
        }
        return result;
    }

    public static void TowSum(int[] cand, int target, List<Integer> current, List<List<Integer>> result) {
        int length = cand.length;
        if (length < 2) {
            return;
        }
        int i = 0;
        int j = length - 1;
        while (j > i) {
            if (cand[j] + cand[i] > target) {
                j--;
            } else if (cand[j] + cand[i] < target) {
                i++;
            } else {
                if (i == 0 || cand[i] != cand[i - 1]) {
                    current.add(cand[i]);
                    current.add(cand[j]);
                    result.add(new ArrayList(current));
                    current.remove(current.size() - 1);
                    current.remove(current.size() - 1);
                }
                j--;
                i++;
            }
        }
        for (i = 0; i < length - 2 && cand[i] <= target / 3; i++) {
            current.add(cand[i]);
            TowSum(Arrays.copyOfRange(cand, i + 1, length), target - cand[i], current, result);
            current.remove(current.size() - 1);
            while (i + 1 < length - 2 && cand[i] == cand[i + 1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 3, 5, 1, 1};
        combinationSum2(a, 8);
    }
}
