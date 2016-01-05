/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cask;

/**
 *
 * @author SONGSONG
 */
public class Candy {

    public int candy(int[] ratings) {
        int length = ratings.length;
        if (length <= 1) {
            return length;
        }
        int[] sToE = new int[length];
        sToE[0] = 1;
        int[] eToS = new int[length];
        eToS[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                sToE[i] = sToE[i - 1] + 1;
            } else {
                sToE[i] = 1;
            }
        }
        int res = Math.max(eToS[length - 1], sToE[length - 1]);
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                eToS[i] = eToS[i + 1] + 1;
            } else {
                eToS[i] = 1;
            }
            res += Math.max(eToS[i], sToE[i]);
        }
        return res;
    }
}
