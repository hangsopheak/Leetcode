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
public class CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        Integer[] result = new Integer[length];
        List<Integer> sorted = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            int index = indexOf(sorted, nums[i]);
            sorted.add(index, nums[i]);
            result[i] = index;
        }
        return Arrays.asList(result);
    }

    public int indexOf(List<Integer> sorted, int target) {
        int right = sorted.size() - 1;
        if (right < 0) {
            return 0;
        }
        int left = 0;
        if (target > sorted.get(right)) {
            return right + 1;
        }
        if (target <= sorted.get(0)) {
            return 0;
        }
        while (right > left + 1) {
            int mid = left + (right - left) / 2;
            if (sorted.get(mid) == target) {
                while (sorted.get(mid - 1) == target) {
                    mid--;
                }
                return mid;
            } else if (sorted.get(mid) > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
