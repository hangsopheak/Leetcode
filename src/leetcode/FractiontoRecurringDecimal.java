/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class FractiontoRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        String result = "";
        long newdenominator = denominator;
        long newnumerator = numerator;
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            result = "-";
        }
        newdenominator = Math.abs(newdenominator);
        newnumerator = Math.abs(newnumerator);
        long tail = newnumerator % newdenominator;
        long before = newnumerator / newdenominator;
        result += before;
        if (tail == 0) {
            return result;
        }
        result += ".";
        String after = "";
        tail = Math.abs(tail);
        HashMap<Long, Integer> hash = new HashMap<>();
        long tmp = tail * 10 / newdenominator;
        int count = 0;
        while (tail != 0 && !hash.containsKey(tail)) {
            after = after + tmp;
            hash.put(tail, count++);
            tail = tail * 10 % newdenominator;
            tmp = tail * 10 / newdenominator;
        }

        if (tail == 0) {
            result += after;
            return result;
        }
        result += after.substring(0, hash.get(tail)) + "(" + after.substring(hash.get(tail), after.length()) + ")";
        return result;
    }
}
