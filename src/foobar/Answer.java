/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foobar;

/**
 *
 * @author SONGSONG
 */
import java.util.*;
import java.math.*;

public class Answer {
    
    static final BigInteger MODULO = new BigInteger("123454321");
    
    public static int answer(int t, int n) {
        BigInteger[] current = new BigInteger[n];
        BigInteger[] last = new BigInteger[n];
        Arrays.fill(current, BigInteger.ZERO);
        Arrays.fill(last, BigInteger.ZERO);
        current[n - 1] = BigInteger.ONE;
        
        for (int a = 0; a < t; a++) {
            BigInteger[] tmp = last;
            last = current;
            current = tmp;
            
            for (int b = 0; b < n; b++) {
                current[b] = last[b];
                if (b + 1 == n) {
                    continue;
                }
                if (b != 0) {
                    current[b] = current[b].add(last[b - 1]);
                }
                current[b] = current[b].add(last[b + 1]);
            }
        }
        
        return current[0].remainder(MODULO).intValue();
    }
    
    public static void main(String[] args) {
        System.out.println(answer(50, 20));
    }
}
