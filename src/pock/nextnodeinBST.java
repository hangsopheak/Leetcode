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
public class nextnodeinBST {
//O(height)

    public static class Node {

        int val;
        Node left;
        Node right;
        Node parent;

        Node(int x) {
            val = x;
        }
    }

    public static Node minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static Node nextBiggerValue(Node node) {
        if (node.right != null) {
            return minValue(node.right);
        }

        Node parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public static Node nextBiggerValue2(Node root, Node node) {
        if (node.right != null) {
            return minValue(node.right);
        }
        Node res = null;
        while (root != null) {
            if (root.val > node.val) {
                res = root;
                root = root.left;
            } else if (root.val < node.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.right = new Node(3);
        root.left.parent = root;
        root.right.parent = root;
        root.left.right.parent = root.left;
        System.out.println(nextBiggerValue(root).val);
        System.out.println(nextBiggerValue2(root, root).val);
    }
}
