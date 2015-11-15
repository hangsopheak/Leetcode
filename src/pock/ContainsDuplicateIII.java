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
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Integer tail = nums[i] / (t + 1);
            if ((map.containsKey(tail) && Math.abs((long) map.get(tail) - nums[i]) <= t) || (map.containsKey(tail + 1) && map.get(tail + 1) - nums[i] <= t) || (map.containsKey(tail - 1) && nums[i] - map.get(tail - 1) <= t)) {
                return true;
            }
            if (map.size() >= k) {
                int remove = nums[i - k] / (t + 1);
                map.remove(remove);
            }
            map.put(tail, nums[i]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        int length = nums.length;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            Integer floor = tree.floor(nums[i] + t);
            Integer ceil = tree.ceiling(nums[i] - t);
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }
            tree.add(nums[i]);
            if (tree.size() >= k) {
                tree.remove(nums[i - k]);
            }
        }
        return false;
    }
}
