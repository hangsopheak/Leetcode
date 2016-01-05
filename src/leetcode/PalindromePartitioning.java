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
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> first = new ArrayList<String>();
        Set<String> hash = new HashSet<>();
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            first.add(s.substring(i - 1, i));
        }
        result.add(first);
        int count = 1;
        int mark = 0;
        while (mark < count) {
            int increase = 0;
            while (mark < count) {
                List<String> tmp = result.get(mark++);
                for (int i = 0; i < tmp.size() - 1; i++) {
                    StringBuilder stmp = new StringBuilder(tmp.get(i));
                    stmp.append(tmp.get(i + 1));
                    if (hash.contains(stmp.toString()) || isPalindrome(stmp.toString())) {
                        List<String> newone = new ArrayList(tmp);
                        newone.remove(i);
                        newone.remove(i);
                        newone.add(i, stmp.toString());
                        hash.add(stmp.toString());
                        increase++;
                        result.add(newone);
                    }
                    if (i < tmp.size() - 2 && !tmp.get(i).equals(tmp.get(i + 1))) {
                        stmp.append(tmp.get(i + 2));
                        if (hash.contains(stmp.toString()) || isPalindrome(stmp.toString())) {
                            List<String> newone = new ArrayList(tmp);
                            newone.remove(i);
                            newone.remove(i);
                            newone.remove(i);
                            newone.add(i, stmp.toString());
                            hash.add(stmp.toString());
                            increase++;
                            result.add(newone);
                        }
                    }
                }
            }
            count += increase;
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        if (right == -1 || right == 0) {
            return true;
        }
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
