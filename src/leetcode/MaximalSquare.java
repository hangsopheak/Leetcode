/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author SONGSONG
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int result = 0;
        int rownum = matrix.length;
        if (rownum == 0) {
            return 0;
        }
        int length = matrix[0].length;
        int[] height = new int[length];
        for (int i = 0; i < rownum; i++) {
            updateHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }
        return result;
    }

    public void updateHeight(char[][] matrix, int[] height, int row) {
        int length = height.length;
        for (int i = 0; i < length; i++) {
            if (height[i] == 0) {
                height[i] = Integer.parseInt(matrix[row][i] + "");
            } else {
                if (matrix[row][i] == '0') {
                    height[i] = 0;
                } else {
                    height[i]++;
                }
            }
        }
    }

    public int largestInLine(int[] height) {
        int length = height.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            int size = height[i];
            int j = i + 1;
            while (size > j - i && j < length) {
                if (height[j] >= size) {
                    j++;
                } else {
                    size = height[j];
                    j++;
                }
            }
            result = Math.max(result, Math.min(size, j - i) * Math.min(size, j - i));
        }
        return result;
    }
}
