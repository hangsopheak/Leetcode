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
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        boolean status = false;
        if (dividend < 0) {
            if (divisor > 0) {
                status = true;
            }
        } else if (dividend > 0) {
            dividend = 0 - dividend;
            if (divisor < 0) {
                status = true;
            }
        }
        if (divisor > 0) {
            divisor = 0 - divisor;
        }
        if (dividend > divisor) {
            return 0;
        }
        int result = 0;
        while (dividend <= divisor) {
            int tmp = divisor;
            int count = 1;
            while (dividend - tmp <= tmp) {
                tmp += tmp;
                count += count;
            }
            result += count;
            dividend -= tmp;
        }
        if (status) {
            return 0 - result;
        }
        return result;
    }
}
