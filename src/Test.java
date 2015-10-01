
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SONGSONG
 */
public class Test {

    public static int solution(int[] A, int X, int D) {
        if (X <= D) {
            return 0;
        }
        boolean[] leaf = new boolean[X + 1];
        int count = 0;
        for (int i = 1; i <= D; i++) {
            leaf[i] = true;
            count++;
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = A[i] + 1; j <= Math.min(A[i] + D, X); j++) {
                if (!leaf[j]) {
                    leaf[j] = true;
                    count++;
                }
            }
            if (count == X) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[3];
        A[0] = 4;
        A[1] = 6;
        A[2] = 2;
        int X = 9;
        int D = 3;
        System.out.println(solution(A, X, D));
    }
}
