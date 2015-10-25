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
public class GameofLife {

    public static void gameOfLife(int[][] board) {
        int length = board.length;
        if (length == 0) {
            return;
        }
        int width = board[0].length;
        int[][] eightneighbors = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    if (i + eightneighbors[k][0] < length && i + eightneighbors[k][0] >= 0 && j + eightneighbors[k][1] >= 0 && j + eightneighbors[k][1] < width) {
                        if (board[i + eightneighbors[k][0]][j + eightneighbors[k][1]] == 1 || board[i + eightneighbors[k][0]][j + eightneighbors[k][1]] == 2) {
                            live++;
                        }
                    }
                }
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] %= 2;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ab = {{0}};
        gameOfLife(ab);
    }
}
