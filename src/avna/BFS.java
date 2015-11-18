/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avna;

import java.util.*;
import leetcode.TreeNode;

/**
 *
 * @author SONGSONG
 */
public class BFS {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                sub.add(queue.poll().val);
            }
            result.add(sub);
        }
        return result;
    }
}
