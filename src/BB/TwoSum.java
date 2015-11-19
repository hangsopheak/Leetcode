/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BB;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        //O(n)
        int[] result = new int[2];
        int min = 2 * numbers.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                if (min > i + 1 + map.get(target - numbers[i])) {
                    result[1] = i + 1;
                    result[0] = map.get(target - numbers[i]);
                    min = result[1] + result[0];
                }
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    public static int twoSum1(int[] numbers, int target) {
        //O(n)
        Set<Integer> map = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.contains(target - numbers[i])) {
                String next = "";
                if (numbers[i] > target - numbers[i]) {
                    next = numbers[i] + " " + (target - numbers[i]);
                    if (!result.contains(next)) {
                        result.add(next);
                    }
                }
            }
            map.add(numbers[i]);
        }
        return result.size();
    }

    public static void main(String[] a) {
        int[] input = {1, 46, 46, 1};
        long ab = input[0] + input[1];
        input[0] = (int) ab;
        System.out.println(twoSum1(input, 47));
    }
}
