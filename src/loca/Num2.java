/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loca;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class Num2 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int length = matrix.length;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < height.length; i++) {
            if (matrix[0][i] == '1') {
                height[i] = 1;
            } else {
                height[i] = 0;
            }
        }
        int res = largestInLine(height);
        for (int i = 1; i < length; i++) {
            updateHeight(matrix, height, i);
            res = Math.max(res, largestInLine(height));
        }
        return res;
    }

    public void updateHeight(char[][] matrix, int[] height, int row) {
        for (int i = 0; i < height.length; i++) {
            if (matrix[row][i] == '1') {
                height[i]++;
            } else {
                height[i] = 0;
            }
        }
    }

    public int largestInLine(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int maxRec = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (stack.empty() || h >= height[stack.peek()]) {
                stack.add(i);
            } else {
                int tmp = stack.pop();
                maxRec = Math.max(maxRec, height[tmp] * (stack.empty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxRec;
    }
}
