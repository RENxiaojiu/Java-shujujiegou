package Teat0304;




public class MyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public MyLinkedList(int length) {
        this.length = length;
    }

    //插入
    public void addFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            length++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        length++;
    }

    public void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            length++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
        length++;
    }

    public void add(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == length) {
            addLast(val);
            return;
        }
        Node newNode = new Node(val);
        Node nextNode = getNode(index);
        Node prevNode = nextNode.prev;

        newNode.prev = prevNode;
        newNode.next = nextNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
        length++;

    }

    public void removeFirst() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            tail = null;
            length--;
            return;
        }
        Node nextNode = head.next;
        nextNode.prev = null;
        head = nextNode;
        length--;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            tail = null;
            length--;
            return;
        }
        Node prevNode = tail.prev;
        prevNode.next = null;
        tail = prevNode;
        length--;
    }

    public void removeByIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == length - 1) {
            removeLast();
            return;
        }
        Node curNode = getNode(index);
        Node prevNode = curNode.prev;
        Node nextNode = curNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        length--;
    }

    public void removeByValue(int val) {
        int index = indexOf(val);
        if (index == -1) {
            return;
        }
        removeByIndex(index);
    }

    //查找
    public int indexOf(int val) {
        Node cur = head;
        for (int i = 0; i < length; i++) {
            if (cur.val == val) {
                return i;
            }
            cur =cur.next;
        }
        return -1;
    }

    // 根据下标找元素
    public Node getNode(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return getNode(index).val;
    }

    public void set(int index, int val) {
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = getNode(index);
        node.val = val;
    }


}
