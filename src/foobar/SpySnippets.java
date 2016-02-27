/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foobar;

/**
 *
 * @author SONGSONG
 */
import java.util.*;

public class SpySnippets {

    public static String answer(String document, String[] searchTerms) {
        String[] documentTerms = document.split(" ");
        int length = searchTerms.length;
        if (length == 1) {
            return searchTerms[0];
        }
        int dlength = documentTerms.length;
        HashMap<String, Integer> hash = new HashMap<>();
        int start = 0;
        int end = 0;
        int mins = 0;
        int mine = dlength;
        while (end < dlength) {
            while (hash.size() < length && end < dlength) {
                if (isSearchTerm(documentTerms[end], searchTerms)) {
                    hash.put(documentTerms[end], end);
                }
                end++;
            }
            while (!hash.containsKey(documentTerms[start]) || start != hash.get(documentTerms[start])) {
                start++;
            }
            if (hash.size() == length && mine - mins > end - start) {
                mine = end;
                mins = start;
            }
            hash.remove(documentTerms[start]);
        }
        StringBuilder res = new StringBuilder();
        for (int i = mins; i < mine; i++) {
            res.append(documentTerms[i]);
            if (i < mine - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    public static boolean isSearchTerm(String a, String[] searchTerms) {
        for (int i = 0; i < searchTerms.length; i++) {
            if (a.equals(searchTerms[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "a d e c b b a";
        String[] search = {"a", "b", "c"};
        System.out.println(answer(a, search));
    }
}
