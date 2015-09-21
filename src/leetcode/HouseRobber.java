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
public class HouseRobber {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] robc = new int[length];
        int[] urob = new int[length];
        robc[0] = nums[0];
        urob[0] = 0;
        for (int i = 1; i < length; i++) {
            robc[i] = Math.max(robc[i - 1], nums[i] + urob[i - 1]);
            urob[i] = robc[i - 1];
        }
        return robc[length - 1];
    }
}
