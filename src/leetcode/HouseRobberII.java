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
        int r = nums[0];
        int u = 0;
        for (int i = 1; i < length - 1; i++) {
            int tmp = r;
            r = Math.max(r, u + nums[i]);
            u = tmp;
        }
        int mark = r;
        r = nums[1];
        u = 0;
        for (int i = 1; i < length - 1; i++) {
            int tmp = r;
            r = Math.max(r, u + nums[i + 1]);
            u = tmp;
        }
        return Math.max(mark, r);
    }
}
