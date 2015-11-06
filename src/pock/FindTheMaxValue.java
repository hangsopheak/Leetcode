/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pock;

/**
 * In a ascending and then descending array
 *
 * @author SONGSONG
 */
public class FindTheMaxValue {

    static int max(int[] input) {
        int length = input.length;
        if (length == 1) {
            return input[0];
        }
        if (length == 2) {
            return Math.max(input[0], input[1]);
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midleft = mid - 1;
            int midright = mid + 1;
            if (input[mid] > input[midleft] && input[mid] > input[midright]) {
                return input[mid];
            } else if (input[mid] > input[midleft] && input[mid] < input[midright]) {
                left = midright;
            } else if (input[mid] < input[midleft] && input[mid] > input[midright]) {
                right = midleft;
            }
        }
        return input[left];
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 1};
        System.out.println(max(input));
    }
}
