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
public class Fibonacci {

    public static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        int tmp = 1;
        int result = 1;
        for (int i = 0; i < n - 2; i++) {
            result += tmp;
            tmp = result - tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
