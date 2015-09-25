/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 *
 * @author SONGSONG
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }
        HashMap<Integer, Integer> tmp = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (tmp.containsKey(nums[i])) {
                if (i - tmp.get(nums[i]) <= k) {
                    return true;
                } else {
                    tmp.put(nums[i], i);
                }
            } else {
                tmp.put(nums[i], i);
            }
        }
        return false;
    }
}
