/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Googlefoobar;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class loop {

    public static int loopNum(int[] num) {
        int index = 0;
        int count = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        int length = num.length;
        while (index >= 0 && index < length) {
            if (!hash.containsKey(index)) {
                hash.put(index, count++);
                index = num[index];
            } else {
                return count - hash.get(index);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 0, 1, 5, 0};
        System.out.println(loopNum(a));
    }
}
