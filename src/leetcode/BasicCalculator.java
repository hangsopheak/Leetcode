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
public class BasicCalculator {

    public static int calculate(String s) {
        int length = s.length();
        s.replaceAll("\\s", "");
        int result = 0;
        Stack<Boolean> stack1 = new Stack<>();
        boolean curr = true;
        String news = "";
        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                news = news + current;
            } else if (current == '(') {
                if (i >= 1 && s.charAt(i - 1) == '-') {
                    stack1.push(false);
                    if (curr) {
                        curr = false;
                    } else {
                        curr = true;
                    }
                } else {
                    stack1.push(true);
                }
            } else if (current == ')') {
                if (!stack1.empty() && !stack1.pop()) {
                    if (curr) {
                        curr = false;
                    } else {
                        curr = true;
                    }
                }
            } else if (current == '-') {
                if (curr) {
                    news = news + "-";
                } else {
                    news = news + "+";
                }
            } else if (current == '+') {
                if (curr) {
                    news = news + "+";
                } else {
                    news = news + "-";
                }
            }
        }
        int i = 0;
        String tmp = "";
        while (Character.isDigit(news.charAt(i))) {
            tmp = tmp + news.charAt(i);
            i++;
        }
        result = Integer.parseInt(tmp);
        tmp = "";
        for (; i < news.length(); i++) {
            char current = news.charAt(i);
            if (current == '-') {
                while (i < news.length() && Character.isDigit(news.charAt(i))) {
                    tmp = tmp + news.charAt(i);
                    i++;
                }
                if (!tmp.equals("")) {
                    result = result - Integer.parseInt(tmp);
                }
                tmp = "";
            } else if (current == '+') {
                while (i < news.length() && Character.isDigit(news.charAt(i))) {
                    tmp = tmp + news.charAt(i);
                    i++;
                }
                if (!tmp.equals("")) {
                    result = result + Integer.parseInt(tmp);
                }
                tmp = "";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "(3+1)- 10";
        System.out.println(calculate(s));
    }
}
