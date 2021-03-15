package Test0203;

public class linkedList {

    public static Node createList() {
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

    //创建带傀儡节点的链表
    public static Node createListWithDummy() {
        Node dummy = new Node(0);
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        dummy.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return dummy;
    }

    //遍历一个不带傀儡节点的链表
    public static void print(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    //遍历一个带傀儡节点的链表
    public static void printWithDummy(Node head) {
        for (Node cur = head.next; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    //尾插一个节点
    public static Node insertTail(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            return newNode;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }

    // 在中间位置插入节点
    //   1.)把节点插入到 1 和 2 之间.
//    public static Node add(Node head) {
//        if (head == null) {
//            return null;
//        }
//
//    }


    // 删除节点, 此处是按照值来删除
    public static Node remove(Node head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            head = head.next;
            return head;
        }
        Node prev = head;
        while (prev != null && prev.next != null && prev.next.val != val) {
            prev = prev.next;
        }
        if (prev == null || prev.next == null) {
            return head;
        }
        Node toDelete = prev.next;
        prev.next = toDelete.next;
        return head;
    }


    // 删除节点, 按照位置来删除.
    public static Node remove2(Node head, Node toDelete) {
        if (head == null) {
            return head;
        }
        if (head == toDelete) {
            head = head.next;
            return head;
        }
        Node nextNode = toDelete.next;
        toDelete.val = nextNode.val;
        toDelete.next = nextNode.next;
        return head;
    }


    public static int size(Node head) {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }
    // 给定节点下标来删除
    public static Node remove3(Node head, int index) {
        if (index < 0 || index > size(head)) {
            return head;
        }
        if (index == 0) {
            head = head.next;
            return head;
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node toDelete = prev.next;
        prev.next = toDelete.next;
        return head;
    }


    // 针对带傀儡节点的链表, 删除指定元素
    public static Node removeWithDummy(Node head, int val){
        Node prev = head;
        while (prev != null && prev.next.val != val) {
            prev = prev.next;
        }
        if (prev == null || prev.next == null) {
            return head;
        }
        Node toDelete = prev.next;
        prev.next = toDelete.next;
        return head;
    }

    // 针对不带傀儡节点的链表, 进行尾删操作
    public static Node removeTail(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node prev = head;
        Node toDelete  = prev.next;
        while (prev != null && prev.next != null) {
            toDelete =prev.next;
            if (toDelete.next == null) {
                break;
            }
            prev = prev.next;
        }
        prev.next = toDelete.next;
        return head;
    }

    // 数组转换成链表
    // 返回的链表是一个不带傀儡节点的链表
    public static Node arrayToLinkedList(int[] array) {
        Node head = null;
        Node tail = null;
        for (int x : array) {
            Node node = new Node(x);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
        return head;
    }

    //带傀儡节点
    public static Node arrayToLinkedList2(int[] array) {
        Node head = new Node(0);
        Node tail = head;
        for (int x : array) {
            Node node = new Node(x);
            tail.next = node;
            tail = tail.next;
        }
        return head;
    }



    public static void main(String[] args) {
        //打印不带傀儡节点的链表测试
//        Node head = createList();
//        print(head);

        //打印带傀儡节点的链表测试
//        Node head = createListWithDummy();
//        printWithDummy(head);



        //尾插测试(不带傀儡节点)
//        Node head = createList();
//        insertTail(head, 100);
//        print(head);

        //尾插测试(带傀儡节点)
//        Node head = createListWithDummy();
//        insertTail(head, 100);
//        printWithDummy(head);


        // 把节点插入到链表头部

        //头插测试(不带傀儡节点)
//        Node head = createList();
//        Node newNode = new Node(100);
//        newNode.next = head;
//        head = newNode;
//        print(head);

        //头插测试(带傀儡节点)
//        Node head = createListWithDummy();
//        Node newNode = new Node(100);
//        Node prev = head;
//        newNode.next = prev.next;
//        head.next = newNode;
//        printWithDummy(head);

        //往中间插入元素
        //把节点插入到 1 和 2 之间.
//        Node head = createList();
//        Node newNode = new Node(100);
//        Node prev = head;
//        for (; prev != null; prev = prev = prev.next) {
//            if (prev.val == 1) {
//                break;
//            }
//        }
//        newNode.next = prev.next;
//        prev.next = newNode;
//        print(head);


        // 删除节点, 此处是按照值来删除测试
//        Node head = createList();
//        remove(head, 10);
//        remove2(head, );
//        print(head);

        //不带傀儡节点
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Node head = arrayToLinkedList(array);
//        print(head);

        // 带傀儡节点
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node head = arrayToLinkedList2(array);
        printWithDummy(head);
        System.out.println("------------------------");
        print(head);

    }
}
