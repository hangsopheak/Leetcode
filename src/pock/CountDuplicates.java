/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pock;

/**
 *
 * @author SONGSONG
 */
public class CountDuplicates {

    static int countDuplicates(int[] input) {
        int result = 0;
        for (int i : input) {
            int j = Math.abs(i);
            if (input[j - 1] < 0) {
                result++;
            } else {
                input[j - 1] *= -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] inputs = {1, 2, 2, 3, 4, 4, 5, 5, 3, 1};
        int r = CountDuplicates.countDuplicates(inputs);
        System.out.println(r);
    }
}
