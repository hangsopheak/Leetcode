/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        int count1 = 0;
        int major1 = 0;
        int count2 = 0;
        int major2 = 1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == major1) {
                count1++;
            } else if (nums[i] == major2) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                major1 = nums[i];
            } else if (count2 == 0) {
                count2++;
                major2 = nums[i];
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int j = 0; j < length; j++) {
            if (nums[j] == major1) {
                count1++;
            }
            if (nums[j] == major2) {
                count2++;
            }
        }
        if (count1 > length / 3) {
            result.add(major1);
        }
        if (count2 > length / 3) {
            result.add(major2);
        }
        return result;
    }
}
