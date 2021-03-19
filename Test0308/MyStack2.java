package Test0308;

// 链表实现的栈(带傀儡节点)
public class MyStack2 {
    Node head = null;
    Node tail = null;
    public MyStack2() {
        head = new Node(0);
        tail = head;
    }


    // 1. 入栈
    public void push(int val) {
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = tail.next;
    }

    // 2. 出栈
    public Integer pop() {
        if (head == tail) {
            return null;
        }
        int ret = head.next.val;
        head = head.next;
        return ret;
    }

    // 3. 取栈顶元素
    public Integer peek() {
        if (head == tail) {
            return null;
        }
        return head.next.val;
    }

    public static void main(String[] args) {
        MyStack2 s = new MyStack2();
        s.push(1);

        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}
