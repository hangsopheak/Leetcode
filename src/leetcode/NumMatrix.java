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
public class NumMatrix {

    int[][] mx = null;

    public NumMatrix(int[][] matrix) {
        int height = matrix.length;
        if (height > 0) {
            int width = matrix[0].length;
            mx = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == 0 && j == 0) {
                        mx[i][j] = matrix[i][j];
                    } else if (i == 0 && j != 0) {
                        mx[i][j] = matrix[i][j] + mx[i][j - 1];
                    } else if (i != 0 && j == 0) {
                        mx[i][j] = matrix[i][j] + mx[i - 1][j];
                    } else {
                        mx[i][j] = matrix[i][j] + mx[i][j - 1] + mx[i - 1][j] - mx[i - 1][j - 1];
                    }
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return mx[row2][col2] - mx[row2 - row1][col2] - mx[row2][col2 - col1] + mx[row1][col1];
    }
}
