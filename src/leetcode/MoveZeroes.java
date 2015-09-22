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
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                if (j < i) {
                    j = i + 1;
                }
                while (j < length && nums[j] == 0) {
                    j++;
                }
                if (j == length) {
                    break;
                }
                nums[i] = nums[j];
                nums[j] = 0;
                if (j == length - 1) {
                    break;
                }
            }
        }
    }
}
