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
public class DataStreamMedian {

    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        int length = nums.length;
        if (length <= 1) {
            return nums;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(3, new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        minHeap.add(Math.max(nums[0], nums[1]));
        maxHeap.add(Math.min(nums[0], nums[1]));
        nums[1] = maxHeap.peek();
        for (int i = 2; i < length; i++) {
            if (i % 2 == 1) {
                if (nums[i] > minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(nums[i]);
                } else {
                    maxHeap.add(nums[i]);
                }
                nums[i] = maxHeap.peek();
            } else {
                if (nums[i] < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(nums[i]);
                } else {
                    minHeap.add(nums[i]);
                }
                nums[i] = minHeap.peek();
            }
        }
        return nums;
    }
}
