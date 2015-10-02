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
public class HIndex {

    public int hIndex(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }
        for (int i = length; i > 0; i--) {
            int count = 0;
            for (int j = 0; j < length; j++) {
                if (citations[j] >= i) {
                    count++;
                }
                if (count + length - 1 - j < i) {
                    break;
                }
            }
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex2(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }

        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (citations[i] > length) {
                array2[length] += 1;
            } else {
                array2[citations[i]] += 1;
            }
        }
        int t = 0;
        int result = 0;

        for (int i = length; i >= 0; i--) {
            t = t + array2[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }
}
