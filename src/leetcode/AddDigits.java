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
public class AddDigits {

    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
//        if (num == 0) {
//            return 0;
//        }
//        int tmp = num % 9;
//        if (tmp == 0) {
//            return 9;
//        }
//        return tmp;
    }
}
