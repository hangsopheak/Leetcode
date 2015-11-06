package pock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SONGSONG
 */
public class Str {

    static int strStr(String haystack, String needle) {
        int hLength = haystack.length();
        int nLength = needle.length();
        for (int i = 0; i <= hLength - nLength; i++) {
            for (int j = 0; j < nLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == nLength - 1) {
                    return i;
                }
            }
        }
        return 0;
    }

    static int strStrWithEquals(String haystack, String needle) {
        int h_length = haystack.length();
        int n_length = needle.length();
        for (int i = 0; i <= h_length - n_length; i++) {
            if (haystack.substring(i, i + n_length).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = strStr("henull", "null");
        int j = strStrWithEquals("henull", "null");
        System.out.println("hello".substring(1, 2));
        System.out.println(i + " " + j);
    }
}
