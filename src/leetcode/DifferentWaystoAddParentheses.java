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
public class DifferentWaystoAddParentheses {

    Map<String, List<Integer>> hash = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char tmp = input.charAt(i);
            if (tmp == '+' || tmp == '-' || tmp == '*') {
                String lefts = input.substring(0, i);
                String rights = input.substring(i + 1, length);
                List<Integer> left = hash.containsKey(lefts) ? hash.get(lefts) : diffWaysToCompute(lefts);
                List<Integer> right = hash.containsKey(rights) ? hash.get(rights) : diffWaysToCompute(rights);
                res.addAll(combine(tmp, left, right));
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        hash.put(input, res);
        return res;
    }

    public List<Integer> combine(char operator, List<Integer> left, List<Integer> right) {
        List<Integer> res = new ArrayList<>();
        for (int i : left) {
            for (int j : right) {
                if (operator == '+') {
                    res.add(i + j);
                } else if (operator == '-') {
                    res.add(i - j);
                } else {
                    res.add(i * j);
                }
            }
        }
        return res;
    }
}
