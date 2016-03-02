/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Stack;

/**
 *
 * @author SONGSONG
 */
public class VerifyPreorderSerializationofaBinaryTree {

    public boolean isValidSerialization(String preorder) {
        String[] terms = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < terms.length; i++) {
            if (terms[i].equals("#")) {
                while (!stack.empty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.empty()) {
                        return false;
                    }
                    stack.pop();
                }
                stack.push(terms[i]);
            } else {
                stack.push(terms[i]);
            }
        }
        if (stack.pop().equals("#") && stack.empty()) {
            return true;
        }
        return false;
    }
}
