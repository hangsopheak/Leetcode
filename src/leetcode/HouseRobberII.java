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
public class HouseRobberII {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] r = new int[length - 1];
        int[] u = new int[length - 1];
        r[0] = nums[0];
        u[0] = 0;
        for (int i = 1; i < length - 1; i++) {
            r[i] = Math.max(r[i - 1], u[i - 1] + nums[i]);
            u[i] = r[i - 1];
        }
        int tmp = r[length - 2];
        r[0] = nums[1];
        u[0] = 0;
        for (int i = 1; i < length - 1; i++) {
            r[i] = Math.max(r[i - 1], u[i - 1] + nums[i + 1]);
            u[i] = r[i - 1];
        }
        return Math.max(tmp, r[length - 2]);
    }
}
