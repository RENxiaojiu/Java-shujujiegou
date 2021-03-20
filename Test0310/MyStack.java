package Test0310;

import java.util.LinkedList;
import java.util.Queue;

// LeetCode 225. 用队列实现栈
// 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
//
//实现 MyStack 类：
//
//void push(int x) 将元素 x 压入栈顶。
//int pop() 移除并返回栈顶元素。
//int top() 返回栈顶元素。
//boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
public class MyStack {

    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        while (A.size() > 1) {
            int tmp = A.poll();
            B.offer(tmp);
        }
        int ret = A.poll();
        swapAB();
        return ret;
    }

    public void swapAB() {
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    /** Get the top element. */
    public int top() {
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        while (A.size() > 1) {
            int tmp = A.poll();
            B.offer(tmp);
        }
        int ret = A.poll();
        B.offer(ret);
        swapAB();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
