/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pock;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author SONGSONG
 */
public class WordBreak {

    public static boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        int length = s.length();
        boolean[] status = new boolean[length + 1];
        status[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (status[j] && wordDict.contains(s.subSequence(j, i))) {
                    status[i] = true;
                    break;
                }
            }
        }
        return status[length];
    }
    public static void main(String[] args) {
        Set<String> wordDict  = new HashSet<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leetcod", wordDict));
    }
}
