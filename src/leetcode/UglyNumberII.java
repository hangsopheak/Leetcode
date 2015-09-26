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
public class UglyNumberII {

    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        int result = 0;
        int[] ugly = new int[n];
        for (int i = 0; i < 6; i++) {
            ugly[i] = i + 1;
        }
        int mark2 = 3, mark3 = 2, mark5 = 1;
        for (int i = 6; i < n; i++) {
            result = Math.min(Math.min(ugly[mark2] * 2, ugly[mark3] * 3), ugly[mark5] * 5);
            if (i == n - 1) {
                return result;
            } else {
                ugly[i] = result;
            }
            if (result == ugly[mark2] * 2) {
                mark2++;
            }
            if (result == ugly[mark3] * 3) {
                mark3++;
            }
            if (result == ugly[mark5] * 5) {
                mark5++;
            }
        }
        return result;
    }
}
