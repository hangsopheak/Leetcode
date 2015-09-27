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
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        String result = "";
        while (n != 0) {
            int tmp = 1 + (n - 1) % 26;
            result = (char) (64 + tmp) + result;
            n = (n - tmp) / 26;
        }
        return result;
    }
}
