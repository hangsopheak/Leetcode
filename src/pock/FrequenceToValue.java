/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pock;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author SONGSONG
 */
public class FrequenceToValue {
    
    /**
     * Time O(N) Space O(2N)
     * @param input
     * @param feq
     * @return 
     */
    static int[] frequenceToValue(int[] input, int[] feq) {
        int feq_length = feq.length;
        int[] result = new int[feq_length];
        Map<Integer, Integer> map = new HashMap();
        for (int i : input) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Map<Integer, Integer> r_map = new HashMap();
        for (Entry<Integer, Integer> e : map.entrySet()) {
            r_map.put(e.getValue(), e.getKey());
        }
        
        for (int i = 0; i < feq_length; i++) {
            if (r_map.containsKey(feq[i])) {
                result[i] = r_map.get(feq[i]);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
    
    /**
     * For test only
     * @param args 
     */
    public static void main(String[] args) {
        int[] input = {5, 5, 5, 8, 8, 4, 1, 1, 1, 1, 2, 2, 2, 2, 2};
        int[] feq = {3, 5, 1, 2, 4};
        int[] result = FrequenceToValue.frequenceToValue(input, feq);
        System.out.println(Arrays.toString(result));
    }
}
