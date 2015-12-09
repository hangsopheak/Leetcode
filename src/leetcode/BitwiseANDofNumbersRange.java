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
public class BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd1(int m, int n) {
        int tail = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            tail <<= 1;
        }
        return m * tail;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        if (m <= n / 2 || m == 0) {
            return 0;
        }
        if (m == n) {
            return m;
        }
        int res = 0;
        int[] level = new int[31];
        level[0] = 1;
        int markm = 0;
        int markn = 0;
        for (int i = 1; i < 31; i++) {
            level[i] = 2 * level[i - 1];
            if (level[i] <= m) {
                markm = i;
            }
            if (level[i] <= n) {
                markn = i;
            }
        }
        while (markm == markn && m > 0 && n > 0) {
            res += level[markm];
            m -= level[markm];
            n -= level[markn];
            markm = 0;
            markn = 0;
            for (int i = 1; i < 31; i++) {
                if (level[i] <= m) {
                    markm = i;
                }
                if (level[i] <= n) {
                    markn = i;
                }
            }
        }
        return res;
    }
}
