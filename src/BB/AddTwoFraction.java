/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BB;

/**
 *
 * @author SONGSONG
 */
public class AddTwoFraction {

    /**
     * @return the greatest common denominator
     */
    public static long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
    }

    public static String asFraction(long a, long b) {
        long gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }

    public static void main(String[] args) {
        System.out.println(asFraction(500, 1000)); //  "1/2"
        System.out.println(asFraction(17, 3));     //  "17/3"
        System.out.println(asFraction(51493, 28718)); //  "22/51"
    }
}
