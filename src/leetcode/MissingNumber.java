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
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int result = 0;
        for (int i = 1; i <= length; i++) {
            result = result ^ i;
        }
        for (int i = 0; i < length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
