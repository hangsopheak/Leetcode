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
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (length < 3) {
            return result;
        }
        for (int i = 0; i < length - 2; i++) {
            int sum = 0 - nums[i];
            if (sum < nums[i + 1] + nums[i + 2]) {
                break;
            }
            int j = i + 1;
            int k = length - 1;
            while (k > j) {
                if (nums[k] + nums[j] > sum) {
                    k--;
                } else if (nums[k] + nums[j] < sum) {
                    j++;
                } else {
                    if (j - 1 == i || nums[j] != nums[j - 1]) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    k--;
                    j++;
                }
            }
            while (i + 1 < length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        threeSum(a);
    }
}
