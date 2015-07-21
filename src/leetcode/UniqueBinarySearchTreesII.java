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
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (n == 0) {
            TreeNode a = null;
            result.add(a);
            return result;
        }
        if (n == 1) {
            result.add(new TreeNode(1));
            return result;
        }
        for (int i = 2; i <= n; i++) {
            List<TreeNode> sub = generateTrees(i - 1);
            result.clear();
            for (TreeNode root : sub) {
                TreeNode newnode = new TreeNode(i);
                newnode.left = root;
                result.add(newnode);

                TreeNode tmp = root;
                while (tmp != null) {
                    newnode = new TreeNode(i);
                    TreeNode a = tmp.right;
                    tmp.right = newnode;
                    newnode.left = a;
                    TreeNode clone = cloneTree(root);
                    result.add(clone);
                    tmp.right = tmp.right.left;
                    tmp = tmp.right;
                }
            }
        }
        return result;
    }

    public TreeNode cloneTree(TreeNode root) {
        TreeNode result = null;
        if (root == null) {
            return result;
        }
        if (root != null) {
            result = new TreeNode(root.val);
            result.left = cloneTree(root.left);
            result.right = cloneTree(root.right);
        }
        return result;
    }
}
