package Test0308;


class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

// 链表实现的栈(不带傀儡节点)
public class MyStack1 {
    private Node head = null;

    public static void main(String[] args) {
        MyStack1 s = new MyStack1();
        s.push(2);
        s.pop();
        System.out.println(s.peek());
    }

    // 1. 入栈
    public void push(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // 2. 出栈
    public Integer pop() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            int ret = head.val;
            head = null;
            return ret;
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }

    // 3. 取栈顶元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
