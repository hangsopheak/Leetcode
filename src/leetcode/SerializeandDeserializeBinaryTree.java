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
public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                } else {
                    queue.add(null);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                } else {
                    queue.add(null);
                }
                result.append(queue.poll().val);
            } else {
                result.append("#");
                queue.poll();
            }
            result.append(",");
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        int i = 0;
        System.out.println(data);
        String[] nums = data.split(",");
        TreeNode root = null;
        root = new TreeNode(Integer.parseInt(nums[i++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int length = nums.length - 1;
        while (i + 1 < length - 1) {
            if (queue.peek() != null) {
                TreeNode left = null;
                TreeNode right = null;
                if (!nums[i].equals("#")) {
                    left = new TreeNode(Integer.parseInt(nums[i]));
                }
                if (!nums[i + 1].equals("#")) {
                    right = new TreeNode(Integer.parseInt(nums[i + 1]));
                }
                queue.add(left);
                queue.add(right);
                queue.peek().left = left;
                queue.poll().right = right;
                i += 2;
            } else {
                queue.poll();
            }
        }
        return root;
    }
}
