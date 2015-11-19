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
public class DistinctSubstring {

    public static int numSubstrings(String text) {
        int length = text.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                set.add(text.substring(i, j));
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.print(numSubstrings("aaaaa"));
    }
}
