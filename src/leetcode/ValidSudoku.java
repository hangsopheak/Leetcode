/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 *
 * @author SONGSONG
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!check(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean check(char[][] board, int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (i != x && board[i][y] == board[x][y]) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i != y && board[x][i] == board[x][y]) {
                return false;
            }
        }
        int kx = x / 3;
        int ky = y / 3;
        for (int i = kx * 3; i < (kx + 1) * 3; i++) {
            for (int j = ky * 3; j < (ky + 1) * 3; j++) {
                if ((i != x || j != y) && board[i][j] == board[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
