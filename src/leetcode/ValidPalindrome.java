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
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        if (right == -1 || right == 0) {
            return true;
        }
        while (left < right) {
            while (left <= right && !Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            }
            if (left > right) {
                return true;
            }
            while (right >= left && !Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
