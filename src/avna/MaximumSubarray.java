/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avna;

/**
 *
 * @author SONGSONG
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int tmp = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(tmp + nums[i], nums[i]);
            result = Math.max(tmp, result);
        }
        return result;
    }
}
