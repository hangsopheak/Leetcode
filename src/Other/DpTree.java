/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

/**
 *
 * @author SONGSONG
 */
public class DpTree {

    public static int DpWholeTree(int n) {
        if (n <= 2) {
            return 1;
        }
        int ToN2 = 1;
        int result = 1;
        for (int i = 2; i < n; i++) {
            int newresult = 2 * result * ToN2 + result * result;
            ToN2 += result;
            result = newresult;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(DpWholeTree(i));
        }
    }
}
