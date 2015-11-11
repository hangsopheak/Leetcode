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
public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public static int longestSub(String input) {
        int result = 0;
        int length = input.length();
        if (length <= 2) {
            return length;
        }
        int startIdx = 0;
        int endIdx = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (; endIdx < length; endIdx++) {
            char newEnd = input.charAt(endIdx);
            if (map.containsKey(newEnd)) {
                map.put(newEnd, map.get(newEnd) + 1);
            } else {
                map.put(newEnd, 1);
            }
            if (endIdx == length - 1 && map.size() <= 2) {
                endIdx = length;
            }
            if (result < endIdx - startIdx) {
                result = endIdx - startIdx;
            }
            if (map.size() > 2) {
                while (map.size() > 2) {
                    char newStart = input.charAt(startIdx);
                    if (map.containsKey(newStart)) {
                        if (map.get(newStart) == 1) {
                            map.remove(newStart);
                        } else {
                            map.put(newStart, map.get(newStart) - 1);
                        }
                    }
                    startIdx++;
                }
            }
        }
        return result;
    }

    public static void main(String[] a) {
        System.out.println(longestSub("aaacbbbbcbc"));
    }
}
