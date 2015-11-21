/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import java.util.Arrays;

/**
 *
 * @author SONGSONG
 */
public class candy2 {

    public static int candy(int[] input, int k) {
        //O(nlogn)
        int result = Integer.MAX_VALUE;
        Arrays.sort(input);
        for (int i = k - 1; i < input.length; i++) {
            if (result == 0) {
                return 0;
            }
            if (result > input[i] - input[i + 1 - k]) {
                result = input[i] - input[i + 1 - k];
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] input = {1, 2, 3, 4, 5, 7, 8, 9, 2, 2, 12, 32, 4};
        System.out.println(candy(input, 10));
    }
}
