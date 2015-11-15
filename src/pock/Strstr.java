/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pock;

/**
 *
 * @author SONGSONG
 */
public class Strstr {
    //O(hLength * nLength)
    public static int strStr(String haystack, String needle) {
        int hLength = haystack.length();
        int nLength = needle.length();
        if (hLength < nLength) {
            return -1;
        }
        if (nLength == 0 || needle == null) {
            return 0;
        }

        for (int i = 0; i <= hLength - nLength; i++) {
            if (haystack.substring(i, i + nLength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String input = "abcdeeea";
        String needle = "eea";
        System.out.println(strStr(input, needle));
    }
}
