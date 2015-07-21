/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author SONGSONG
 */
public class SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                for (left = mid; left >= 0; left--) {
                    if (nums[left] == target) {
                        result[0] = left;
                    } else {
                        break;
                    }
                }
                for (right = mid; right < length; right++) {
                    if (nums[right] == target) {
                        result[1] = right;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        return result;
    }
}
