package Test0204;

import Test0203.Node;

import java.util.zip.CheckedInputStream;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class Solution {
    // LeetCode  203. 移除链表元素
    // 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有
    // 满足 Node.val == val 的节点，并返回 新的头节点 。
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur. val == val) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    //
    //反转一个单链表。
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode prevNode = null;
        ListNode curNode = head;

        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            if (nextNode == null) {
                newHead = curNode;
            }
            prevNode = curNode;
            curNode = nextNode;
        }
        return newHead;
    }

    //LeetCode 876. 链表的中间结点
    //给定一个头结点为 head 的非空单链表，返回链表的中间结点。
    //如果有两个中间结点，则返回第二个中间结点。
    public ListNode middleNode(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length = length + 1;
        }
        if (head == null) {
            return null;
        }
        int num = length / 2;
        ListNode cur = head;
        for (int i = 0; i < num; i++) {
            cur = cur.next;
        }
        return cur;
    }


    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head,int k) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }
        if (head == null) {
            return null;
        }
        if (k < 0 || k > length) {
            return null;
        }
        ListNode cur = head;
        for (int i = 0; i < length - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //LeetCode 21. 合并两个有序链表
    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                newTail.next = cur1;
                cur1 = cur1.next;
            } else {
                newTail.next = cur2;
                cur2 = cur2.next;
            }
            newTail = newTail.next;
        }
        if (cur1 == null) {
            newTail.next = cur2;
        } else {
            newTail.next = cur1;
        }
        return newHead.next;
    }

    // 现有一链表的头指针 ListNode* pHead，给一定值x，编写一段代码将所有小于x的结点排
    // 在其余结点之前，且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode smallHead = new ListNode(0);
        ListNode smallTail = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode largeTail = largeHead;
        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                largeTail.next = new ListNode(cur.val);
                largeTail = largeTail.next;
            }
        }
        smallTail.next = largeHead.next;
        return smallHead.next;
    }

    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
    // 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur != null && cur.next != null
                        && cur.val == cur.next.val){
                    cur = cur.next;
                }
            } else {
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }


    // 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
    //给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
    public static boolean chkPalindrome(ListNode A) {
        // write code here
        if (A == null) {
            return true;
        }
        if (A.next == null) {
            return true;
        }
        //复制链表
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        for (ListNode cur = A; cur != null; cur = cur.next) {
            newTail.next = new ListNode(cur.val);
            newTail = newTail.next;
        }
        ListNode B = newHead.next;
//        print(B);
        //逆置链表
        ListNode prevNode = null;
        ListNode curNode = B;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            if (nextNode == null) {
                B = curNode;
            }
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        print(B);
        //对比两个链表
        ListNode cur1 = A;
        ListNode cur2 = B;
        while (cur1 != null && cur2 != null) {
            if ( cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode A = createList();
        solution.chkPalindrome(A);

    }
    public static ListNode createList() {
        ListNode a = new ListNode(559);
        ListNode b = new ListNode(526);
        ListNode c = new ListNode(134);
        ListNode d = new ListNode(568);
        ListNode e = new ListNode(197);
        ListNode f = new ListNode(532);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;
        return a;
    }
    public static void print(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
    }
}
