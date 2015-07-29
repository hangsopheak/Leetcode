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
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                for (int k = i + 1; k < j; k++) {
                    if (target - nums[i] - nums[j] - nums[k] == 0) {
                        return target;
                    }
                    if (Math.abs(target - result) > Math.abs(target - nums[i] - nums[j] - nums[k])) {
                        result = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return result;
    }
}
