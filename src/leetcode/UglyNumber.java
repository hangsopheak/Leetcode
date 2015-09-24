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
public class UglyNumber {

    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        if (num == 0) {
            return false;
        }
        boolean tmp2 = true;
        boolean tmp3 = true;
        boolean tmp5 = true;
        while (tmp2 || tmp3 || tmp5) {
            int tmp = num % 2;
            if (tmp == 0) {
                num = num / 2;
            } else {
                tmp2 = false;
            }
            tmp = num % 3;
            if (tmp == 0) {
                num = num / 3;
            } else {
                tmp3 = false;
            }
            tmp = num % 5;
            if (tmp == 0) {
                num = num / 5;
            } else {
                tmp5 = false;
            }
        }
        if (num == 1) {
            return true;
        }
        return false;
    }
}
