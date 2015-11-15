/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pock;

/**
 *
 * @author SONGSONG
 */
public class LowestCommenAnscertor {

    public static class Node {

        int val;
        Node left;
        Node right;

        Node(int x) {
            val = x;
        }
    }

    public Node lowestBST(Node root, Node a, Node b) {
        if (root == null) {
            return root;
        }

        if ((a.val > root.val && b.val < root.val) || (a.val < root.val && b.val > root.val) || a.val == root.val || b.val == root.val) {
            return root;
        } else if (a.val < root.val && b.val < root.val) {
            return lowestBST(root.left, a, b);
        } else {
            return lowestBST(root.right, a, b);
        }
    }

    public Node lowestBT(Node root, Node a, Node b) {
        if (root == null || root == a || root == b) {
            return root;
        }
        
        Node left = lowestBT(root.left, a, b);
        Node right = lowestBT(root.right, a, b);
        
        if(left != null && right != null){
            return root;
        }
        
        return left != null? left: right;
    }
}
