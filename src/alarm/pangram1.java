/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class pangram1 {

    public static int panagram(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char tmp = input.charAt(i);
            if (!set.contains(tmp) && tmp != ' ') {
                set.add(tmp);
            }
        }
        if (set.size() == 26) {
            return 1;
        }
        return 0;
    }

    public static void main(String arg[]) {
        String input = "abcd efhi jklmn opqrstuvwxyz ";
        System.out.println(panagram(input));
    }
}
