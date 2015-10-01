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
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                total = total * nums[i];
            } else {
                count++;
            }
        }
        int[] result = new int[length];
        if (count == 1) {
            for (int i = 0; i < length; i++) {
                if (nums[i] == 0) {
                    result[i] = total;
                }
            }
        } else if (count == 0) {
            for (int i = 0; i < length; i++) {
                result[i] = total / nums[i];
            }
        }
        return result;
    }
}
