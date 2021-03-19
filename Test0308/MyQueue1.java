package Test0308;

// 使用链表实现队列
public class MyQueue1 {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head = null;
    private Node tail = null;

    // 入队列
    public boolean offer(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return true;
        }
        tail.next = newNode;
        tail = tail.next;
        return true;
    }

    // 出队列
    public Integer poll() {
        if (head == null) {
            return null;
        }
        int ret = head.val;
        if (head.next == null) {
            head = null;
            tail = null;
            return ret;
        }
        head = head.next;
        return ret;
    }

    // 取队首元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
