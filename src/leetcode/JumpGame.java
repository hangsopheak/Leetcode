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
public class JumpGame {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int j = 0;
                if (i == length - 1) {
                    for (j = i - 1; j >= 0; j--) {
                        if (nums[j] - i + j >= 0) {
                            break;
                        }
                    }
                    if (j == -1) {
                        return false;
                    }
                } else {
                    for (j = i - 1; j >= 0; j--) {
                        if (nums[j] - i + j > 0) {
                            break;
                        }
                    }
                    if (j == -1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
