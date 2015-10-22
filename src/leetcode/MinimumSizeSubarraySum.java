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
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int length = nums.length;
        int tmp = 0;
        int result = length;
        for (; end < length; end++) {
            tmp = tmp + nums[end];
            if (tmp >= s) {
                while (tmp >= s) {
                    tmp = tmp - nums[start++];
                }
                if (result > end - start + 2) {
                    result = end - start + 2;
                }
            }
        }
        if (start == 0) {
            return 0;
        }
        return result;
    }
}
