package Test0310;

import java.util.Stack;

public class MinStack {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        A.push(val);
        while (B.isEmpty()) {
            B.push(val);
            return;
        }
        int min = B.peek();
        if (min > val) {
            B.push(val) ;
        } else {
            B.push(min);
        }
    }

    public void pop() {
        if (A.isEmpty()) {
            return;
        }
        A.pop();
        B.pop();
    }

    public int top() {
        if (A.isEmpty()) {
            return 0;
        }
        return A.peek();
    }

    public int getMin() {
        if (A.isEmpty()) {
            return 0;
        }
        return B.peek();
    }
}
