/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BB;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class NumGame {

    public static void numgame(int a, int b) {
        HashSet<Integer> map = new HashSet<>();
        map.add(a);
        map.add(b);
        boolean endmark = true;
        while (endmark) {
            endmark = false;
            for (int num1 : map) {
                for (int num2 : map) {
                    int next = Math.abs(num1 - num2);
                    if (!map.contains(next) && next > 0) {
                        System.out.println(next);
                        map.add(next);
                        endmark = true;
                        break;
                    }
                }
                if(endmark) break;
            }
        }
    }

    public static void main(String[] args) {
        numgame(12, 8);
    }
}
