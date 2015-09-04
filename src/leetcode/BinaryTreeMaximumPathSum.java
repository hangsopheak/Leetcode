/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author SONGSONG
 */
public class BinaryTreeMaximumPathSum {

    //solution1
    private class ResultType {

        int singlepath;
        int maxpath;

        public ResultType(int sp, int mp) {
            singlepath = sp;
            maxpath = mp;
        }
    }

    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int leftsp = Math.max(0, left.singlepath);
        int rightsp = Math.max(0, right.singlepath);
        int singlepath = Math.max(0, Math.max(leftsp, rightsp) + root.val);
        int maxpath = Math.max(root.val + leftsp + rightsp, Math.max(left.maxpath, right.maxpath));
        return new ResultType(singlepath, maxpath);
    }

    public int maxPathSum1(TreeNode root) {
        return helper(root).maxpath;
    }

    //solution2
    int maxPath;

    public int maxPathSum2(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        rootToLeaf(root);
        return maxPath;
    }

    public int rootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, rootToLeaf(root.left));
        int right = Math.max(0, rootToLeaf(root.right));
        maxPath = Math.max(maxPath, left + right + root.val);
        return Math.max(0, Math.max(left, right) + root.val);
    }
}
