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
public class SecondMax {

    public static int secondMax(int[] a) {
        TreeSet<Integer> tree = new TreeSet<>();
        int length = a.length;
        if(length == 1) return a[0];
        for(int i = 0; i < length; i++){
            tree.add(a[i]);
            if(tree.size() > 2){
                tree.pollFirst();
            }
        }
        return tree.pollFirst();
    }

    public static void main(String[] args) {
        int[] input = {3, 3};
        System.out.println(secondMax(input));
    }

}
