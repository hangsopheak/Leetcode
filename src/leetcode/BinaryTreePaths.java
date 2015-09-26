/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SONGSONG
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add("" + root.val);
            return result;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for (String i : left) {
            result.add(root.val + "->" + i);
        }
        for (String i : right) {
            result.add(root.val + "->" + i);
        }
        return result;
    }
}
