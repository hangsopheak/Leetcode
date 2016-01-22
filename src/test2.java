
import java.util.Arrays;
import java.util.*;
import leetcode.TreeNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SONGSONG
 */
public class test2 {

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
            System.out.println(i ^ i >> 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(null);
        System.out.println(queue.size());
        StringBuilder result = new StringBuilder();
        result.append("#");
        System.out.println(result.toString());
        int[]  a = new int[10];
        Arrays.fill(a, 100);
        int index = Arrays.binarySearch(a, 1);
        System.out.println(index);
    }
}
