/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.regex.Pattern;

/**
 *
 * @author SONGSONG
 */
public class CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split(Pattern.quote("."));
        String[] v2 = version2.split(Pattern.quote("."));
        for (int i = 0; i < Math.min(v1.length, v2.length); i++) {
            int count = 0;
            while (count < v1[i].length() && v1[i].charAt(count) == '0') {
                count++;
            }
            v1[i] = v1[i].substring(count);
            count = 0;
            while (count < v2[i].length() && v2[i].charAt(count) == '0') {
                count++;
            }
            v2[i] = v2[i].substring(count);
            if (v1[i].length() > v2[i].length()) {
                return 1;
            } else if (v1[i].length() < v2[i].length()) {
                return -1;
            } else {
                for (int j = 0; j < v1[i].length(); j++) {
                    if (v1[i].charAt(j) > v2[i].charAt(j)) {
                        return 1;
                    } else if (v1[i].charAt(j) < v2[i].charAt(j)) {
                        return -1;
                    }
                }
            }
        }
        if (v1.length > v2.length) {
            for (int i = v2.length; i < v1.length; i++) {
                if (Integer.parseInt(v1[i]) != 0) {
                    return 1;
                }
            }
            return 0;
        } else if (v1.length < v2.length) {
            for (int i = v1.length; i < v2.length; i++) {
                if (Integer.parseInt(v2[i]) != 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return 0;
        }
    }

    public int compareVersion2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int lenv1 = v1.length;
        int lenv2 = v2.length;
        int i = 0;
        int j = 0;
        while (i < lenv1 || j < lenv2) {
            int tmp1 = 0;
            int tmp2 = 0;
            if (i < lenv1) {
                tmp1 = Integer.parseInt(v1[i]);
            }
            if (j < lenv2) {
                tmp2 = Integer.parseInt(v2[j]);
            }
            if (tmp1 > tmp2) {
                return 1;
            }
            if (tmp1 < tmp2) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String a = "1.4.1";
        String b = "1.4.1.3";
        System.out.print(compareVersion(a, b));
    }
}
