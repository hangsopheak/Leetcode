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
public class BullsandCows {

    public String getHint(String secret, String guess) {
        int count = 0;
        int remain = 0;
        int length = secret.length();
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char tmp = secret.charAt(i);
            if (tmp == guess.charAt(i)) {
                count++;
            } else {
                if (hash.containsKey(tmp)) {
                    hash.put(tmp, hash.get(tmp) + 1);
                } else {
                    hash.put(tmp, 1);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            char tmp = guess.charAt(i);
            if (secret.charAt(i) != tmp) {
                if (hash.containsKey(tmp)) {
                    remain++;
                    if (hash.get(tmp) > 1) {
                        hash.put(tmp, hash.get(tmp) - 1);
                    } else {
                        hash.remove(tmp);
                    }
                }
            }
        }
        return "" + count + "A" + remain + "B";
    }
}
