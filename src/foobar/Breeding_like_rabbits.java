/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foobar;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class Breeding_like_rabbits {

    static final BigInteger ZERO = BigInteger.ZERO;
    static final BigInteger ONE = BigInteger.ONE;
    static final BigInteger TWO = BigInteger.valueOf(2);

    static class Recusive {

        private Map<BigInteger, BigInteger> results;

        public Recusive() {
            results = new HashMap<>();
            results.put(ZERO, ONE);
            results.put(ONE, ONE);
            results.put(TWO, TWO);
        }

        public BigInteger recusive(BigInteger target) {
            if (results.containsKey(target)) {
                return results.get(target);
            }
            BigInteger n = target.divide(TWO);
            BigInteger res = ONE;
            if (target.mod(TWO).equals(ZERO)) {
                res = recusive(n).add(recusive(n.add(ONE))).add(n);
            } else {
                res = recusive(n.subtract(ONE)).add(recusive(n)).add(ONE);
            }
            results.put(target, res);
            return res;
        }
    }

    static Recusive calculator = new Recusive();

    public static String answer(String str_S) {
        BigInteger target = new BigInteger(str_S);

        BigInteger minEven = ZERO;
        BigInteger maxEven = TWO;
        while (calculator.recusive(maxEven).compareTo(target) < 0) {
            minEven = maxEven;
            maxEven = maxEven.multiply(TWO);
        }

        BigInteger minOdd = ONE;
        BigInteger maxOdd = new BigInteger("3");
        while (calculator.recusive(maxOdd).compareTo(target) < 0) {
            minOdd = maxOdd;
            maxOdd = maxOdd.multiply(TWO).add(ONE);
        }

        BigInteger evenCandidate = binarySearch(minEven, maxEven, target, true);
        BigInteger oddCandidate = binarySearch(minOdd, maxOdd, target, false);
        if (evenCandidate == null && oddCandidate == null) {
            return "None";
        } else if (evenCandidate == null) {
            return oddCandidate.toString();
        } else if (oddCandidate == null) {
            return evenCandidate.toString();
        } else {
            // Because oddCandidate must be larger than evenCandidate
            return oddCandidate.toString();
        }
    }

    // if mode is true search in even number, else search in odd number
    public static BigInteger binarySearch(BigInteger start, BigInteger end, BigInteger target, boolean mode) {
        while (end.compareTo(start) >= 0) {
            BigInteger mid = start.add(end).divide(TWO);
            if (mid.mod(TWO).equals(ONE) && mode) {
                mid = mid.add(ONE);
            }
            if (mid.mod(TWO).equals(ZERO) && !mode) {
                mid = mid.add(ONE);
            }

            int compare = calculator.recusive(mid).compareTo(target);
            if (compare == 0) {
                return mid;
            } else if (compare > 0) {
                end = mid.subtract(TWO);
            } else {
                start = mid.add(TWO);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String a = "7";
        System.out.println(answer(a));
    }
}
