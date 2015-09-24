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
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> tmp = new HashMap<>();
        int i;
        for (i = 0; i < s.length(); i++) {
            char ctmp = s.charAt(i);
            if (tmp.containsKey(ctmp)) {
                tmp.put(ctmp, tmp.get(ctmp) + 1);
            } else {
                tmp.put(ctmp, 1);
            }
        }
        for (i = i - 1; i >= 0; i--) {
            char ctmp = t.charAt(i);
            if (tmp.containsKey(ctmp)) {
                int j = tmp.get(ctmp);
                if (j == 1) {
                    tmp.remove(ctmp);
                } else {
                    tmp.put(ctmp, j - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
