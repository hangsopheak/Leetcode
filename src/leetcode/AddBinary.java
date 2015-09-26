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
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuffer result = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int tmp = 0;
        while (i >= 0 || j >= 0) {
            int ca = i >= 0 ? Integer.parseInt("" + a.charAt(i)) : 0;
            int cb = j >= 0 ? Integer.parseInt("" + b.charAt(j)) : 0;
            int c = tmp + ca + cb;
            tmp = c / 2;
            c = c % 2;
            result.insert(0, c);
            i--;
            j--;
        }
        if (tmp == 1) {
            result.insert(0, 1);
        }
        return result.toString();
    }
}
