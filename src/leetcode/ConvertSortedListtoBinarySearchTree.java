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
public class ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> a = new ArrayList<Integer>();
        while (head != null) {
            a.add(head.val);
            head = head.next;
        }
        TreeNode result = sortedArrayToBST(a);
        return result;
    }

    public TreeNode sortedArrayToBST(List<Integer> nums) {
        int length = nums.size();
        if (length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums.get(length / 2));
        root.left = sortedArrayToBST(nums.subList(0, length / 2));
        root.right = sortedArrayToBST(nums.subList(length / 2 + 1, length));
        return root;
    }
    //method2
    ListNode node;

    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }
        node = head;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return inorderBST(0, size);
    }

    public TreeNode inorderBST(int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = inorderBST(start, mid);
        TreeNode a = new TreeNode(node.val);
        a.left = left;
        node = node.next;
        TreeNode right = inorderBST(mid + 1, end);
        a.right = right;
        return a;
    }
}
