/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.List;

/**
 *
 * @author SONGSONG
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int result;
        List<Integer> tmp = triangle.get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> sub = triangle.get(i);
            for (int j = 0; j < sub.size(); j++) {
                if (j == 0) {
                    sub.set(j, sub.get(j) + tmp.get(j));
                } else if (j == sub.size() - 1) {
                    sub.set(j, sub.get(j) + tmp.get(j - 1));
                } else {
                    sub.set(j, sub.get(j) + Math.min(tmp.get(j - 1), tmp.get(j)));
                }
            }
            tmp = sub;
        }
        result = tmp.get(0);
        for (int i : tmp) {
            if (result > i) {
                result = i;
            }
        }
        return result;
    }
}
