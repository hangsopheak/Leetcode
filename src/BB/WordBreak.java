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
public class WordBreak {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        HashMap<Integer, List<String>> hash = new HashMap<>();
        List<String> zero = new ArrayList<>();
        if (!wordBreak1(s, wordDict)) {
            return zero;
        }
        zero.add("");
        hash.put(0, zero);
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            List<String> result = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (hash.containsKey(j) && wordDict.contains(s.substring(j, i))) {
                    for (String e : hash.get(j)) {
                        StringBuilder tmp = new StringBuilder(e);
                        if (j == 0) {
                            tmp.append(s.substring(j, i));
                            result.add(tmp.toString());
                        } else {
                            tmp.append(" ");
                            tmp.append(s.substring(j, i));
                            result.add(tmp.toString());
                        }
                    }
                }
            }
            hash.put(i, result);
        }
        return hash.get(length);
    }

    public boolean wordBreak1(String s, Set<String> wordDict) {
        // O(n^2)
        if (wordDict.contains(s)) {
            return true;
        }
        int length = s.length();
        boolean[] status = new boolean[length + 1];
        status[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (status[j] && wordDict.contains(s.substring(j, i))) {
                    status[i] = true;
                    break;
                }
            }
        }
        return status[length];
    }
}
