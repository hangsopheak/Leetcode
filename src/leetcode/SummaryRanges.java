/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SONGSONG
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) {
            return result;
        }
        int start = 0;
        int i;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                if (start != i - 1) {
                    result.add(nums[start] + "->" + nums[i - 1]);
                } else {
                    result.add(nums[start] + "");
                }
                start = i;
            }
        }
        if (start != i - 1) {
            result.add(nums[start] + "->" + nums[i - 1]);
        } else {
            result.add(nums[start] + "");
        }
        return result;
    }
}
