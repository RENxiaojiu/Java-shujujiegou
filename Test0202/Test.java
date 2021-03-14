package Test0202;

public class Test {


    public static void main(String[] args) {
        Node head = creatList();
        //遍历链表
//        for (Node cur = head; cur != null; cur = cur.next) {
//            System.out.println(cur.val);
//        }


        //遍历链表，找到最后一个元素
//        Node cur = head;
//        while (cur != null && cur.next != null){
//            cur = cur.next;
//        }
//        System.out.println(cur.val);


        //遍历链表，找到到倒数第二个元素
//        Node cur = head;
//        while (cur != null && cur.next != null && cur.next.next != null) {
//            cur = cur.next;
//        }
//        System.out.println(cur.val);


        //取链表的第 N 个节点. (从 1 开始算的)
//        int n = 1;
//        Node cur = head;
//        for (int i = 1; i < n; i++) {
//            cur = cur.next;
//        }
//        System.out.println(cur.val);


        // 获取链表的长度
//        int count = 0;
//        for (Node cur = head; cur != null; cur = cur.next) {
//            count++;
//        }
//        System.out.println(count);


        //遍历链表, 查找链表上是否存在某个元素
        int toFind = 10;
        Node cur = head;
        for (; cur != null; cur = cur.next) {
            if (cur.val == toFind) {
                break;
            }
        }
        if (cur != null) {
            System.out.println("找到了");
        } else {
            System.out.println("没找到");
        }

    }

    private static Node creatList() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return a;


    }
}
