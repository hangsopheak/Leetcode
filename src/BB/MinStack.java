/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BB;

import java.util.Stack;

/**
 *
 * @author SONGSONG
 */
public class MinStack {

    long min;
    Stack<Long> stack = new Stack<>();

    public void push(int x) {
        if (stack.empty()) {
            min = x;
            stack.push(0L);
        } else {
            stack.push(x - min);
            if (x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        long pop = stack.pop();
        if (pop < 0) {
            min = min - pop;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top < 0) {
            return (int) min;
        } else {
            return (int) (min + top);
        }
    }

    public int getMin() {
        return (int) min;
    }
}
