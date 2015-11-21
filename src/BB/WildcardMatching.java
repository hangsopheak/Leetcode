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
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        //O(nm)
        int m = s.length(), n = p.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') {
                count++;
            }
        }
        if (count == 0 && m != n) {
            return false;
        } else if (n - count > m) {
            return false;
        }

        boolean[] match = new boolean[m + 1];
        match[0] = true;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') {
                for (int j = 0; j < m; j++) {
                    match[j + 1] = match[j] || match[j + 1];
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    match[j + 1] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && match[j];
                }
                match[0] = false;
            }
        }
        return match[m];
    }

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int numWindows = 2;
        int a[] = {2, 5};
        int ticketsToSell = 4;
        int result = 0;
        while (ticketsToSell > 0) {
            int tmp = a[0];
            int tmpIdx = 0;
            for (int i = 1; i < a.length; i++) {
                if (tmp < a[i]) {
                    tmp = a[i];
                    tmpIdx = i;
                }
            }
            result += tmp;
            a[tmpIdx]--;
            ticketsToSell--;
        }
        System.out.print(result);
    }
}
