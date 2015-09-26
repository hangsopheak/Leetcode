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
public class CountandSay {

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuffer newresult = new StringBuffer();
            int j = 0;
            while (j < result.length()) {
                char tmp = result.charAt(j);
                int count = 0;
                while (j < result.length() && result.charAt(j) == tmp) {
                    count++;
                    j++;
                }
                newresult.append(count);
                newresult.append(tmp);
            }
            result = newresult.toString();
        }
        return result;
    }
}
