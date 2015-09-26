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
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuffer result = new StringBuffer(strs[0]);
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(result.toString()) != 0) {
                result.deleteCharAt(result.length() - 1);
            }
            i++;
        }
        return result.toString();
    }
}
