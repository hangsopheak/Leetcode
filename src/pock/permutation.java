/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pock;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> sub = new ArrayList<Integer>();
        sub.add(nums[0]);
        result.add(sub);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> newresult = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> l : result) {
                    List<Integer> tmp = new ArrayList<Integer>(l);
                    tmp.add(j, nums[i]);
                    newresult.add(tmp);
                }
            }
            result = newresult;
        }
        return result;
    }
}
