/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SONGSONG
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashSet;
import java.util.Stack;

/**
 *
 * @author yuezhao
 */
public class Solution {

    class Node {

        private int level = 0;
        private int length = 0;
        private String dir = null;
        private boolean Image = false;

        public Node(String s) {
            this.level = s.lastIndexOf(' ') + 1; //plus '/'
            this.dir = s.substring(level);
            this.length = dir.length() + 1;
            String[] tmp = this.dir.split("\\.");
            if (tmp.length > 1) {
                if (tmp[1].equals("jpeg") || tmp[1].equals("png") || tmp[1].equals("gif")) {
                    this.Image = true;
                }
            }
        }
    }

    public int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] strs = s.split("\n");
        int n = strs.length;
        int len = 0;
        int sum = 0;
        Stack<Node> stack = new Stack();
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Node str = new Node(strs[i]);
            if (str.Image) {
                if (!stack.empty() && !hs.contains(stack.peek().dir)) {
                    sum += len;
                    hs.add(stack.peek().dir);
                }
                if (stack.empty() && !hs.contains("/")) {
                    sum += 1;
                    hs.add("/");
                }
            } else {
                while (!stack.empty() && stack.peek().level >= str.level) {
                    len -= stack.pop().length;
                }
                len += str.length;
                stack.push(str);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String test = "dir1\n"
                + " dir11\n"
                + " dir12\n"
                + "  picture.jpeg\n"
                + "  dir121\n"
                + "  file1.png\n"
                + "dir2\n"
                + " file2.gif\n"
                + "pic.png\n"
                + "pic1.gif";
        Solution sol = new Solution();
        System.out.println(sol.solution(test));
    }
}
