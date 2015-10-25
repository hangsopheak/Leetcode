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
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        int length = s.length();
        if (length <= 10) {
            return result;
        }
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < length - 9; i++) {
            String tmp = s.substring(i, i + 10);
            if (hash.containsKey(tmp)) {
                if (hash.get(tmp) == 1) {
                    result.add(tmp);
                    hash.put(tmp, 2);
                }
            } else {
                hash.put(tmp, 1);
            }
        }
        return result;
    }
}
