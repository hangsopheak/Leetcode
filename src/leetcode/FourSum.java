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
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 3; i++) {
            int newtarget = target - nums[i];
            for (int j = i + 1; j < length - 2; j++) {
                int sum = newtarget - nums[j];
                if (sum < nums[j + 1] + nums[j + 2]) {
                    break;
                }
                int k = j + 1;
                int l = length - 1;
                System.out.println(k);
                while (l > k) {
                    if (nums[l] + nums[k] > sum) {
                        l--;
                    } else if (nums[l] + nums[k] < sum) {
                        k++;
                    } else {
                        if (k - 1 == j || nums[k] != nums[k - 1]) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                        l--;
                        k++;
                    }
                }
                while (j + 1 < length && nums[j] == nums[j + 1]) {
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
        int[] a = {2, 1, 0, -1};
        fourSum(a, 2);
    }
}
