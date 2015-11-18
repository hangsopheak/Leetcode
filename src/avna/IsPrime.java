/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avna;

/**
 *
 * @author SONGSONG
 */
public class IsPrime {

    public static boolean isPrime(int input) {
        int end = (int) Math.sqrt(input);
        for (int i = 2; i <= end; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 20; i++) {
            System.out.println(i + " " + isPrime(i));
        }
    }
}
