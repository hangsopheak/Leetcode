/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author SONGSONG
 */
public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = needle.length();
        for (; j <= haystack.length(); j++) {
            if (haystack.substring(i, j).equals(needle)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
