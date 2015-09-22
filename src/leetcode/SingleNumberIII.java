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
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }
        int tmp = 1;
        while ((tmp & sum) == 0) {
            tmp = tmp * 2;
        }
        result[0] = 0;
        result[1] = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((tmp & nums[i]) == 0) {
                result[0] = result[0] ^ nums[i];
            } else {
                result[1] = result[1] ^ nums[i];
            }
        }
        return result;
    }
}
