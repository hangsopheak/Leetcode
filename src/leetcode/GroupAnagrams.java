/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Arrays.sort(strs);
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String tmp = orderString(strs[i]);
            if (hash.containsKey(tmp)) {
                System.out.println(hash.containsKey(tmp) + "a");
                hash.get(tmp).add(strs[i]);
            } else {
                List<String> tmplist = new ArrayList<>();
                tmplist.add(strs[i]);
                hash.put(tmp, tmplist);
            }
        }
        return new ArrayList<List<String>>(hash.values());
    }

    public String orderString(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}
