/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SONGSONG
 */
public class TachyonNexus {

    public int solution(int[][] A) {
        // write your code in Java SE 8
        long res = 0;
        if (A == null || A.length == 0) {
            return -1;
        }

        int left = 0, right = A[0].length - 1, top = 0, bottom = A.length - 1;
        while (left <= right && top <= bottom) {
            //left to right
            for (int i = left; i <= right; i++) {
                res += A[top][i];
            }
            top++;
            bottom--;
            //top to bottom
            for (int i = top; i <= bottom; i++) {
                res += A[i][right];
            }
            left++;
            right--;
            //right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res += A[bottom][i];
                }
            }
            top++;
            bottom--;
            //bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res += A[i][left];
                }
            }
            right--;
            left++;
        }
        if (res <= 100000000 && res >= -100000000) {
            return (int) res;
        }
        return -1;
    }
}
