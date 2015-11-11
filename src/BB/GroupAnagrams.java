/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BB;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs); // 
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String tmp = orderString(strs[i]);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(strs[i]);
            } else {
                List<String> sub = new ArrayList<String>();
                sub.add(strs[i]);
                map.put(tmp, sub);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static String orderString(String input) {
        char[] tmp = input.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(input);
        for(List<String> tmp : result) {
            for(String e : tmp) {
                System.out.print(e + " ");
            }
            System.out.println("");
        }
    }
}
