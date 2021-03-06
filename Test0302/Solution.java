package Test0302;


import Test0302.ListNode;

public class Solution {
    // LeetCode 160. 相交链表
    // 编写一个程序，找到两个单链表相交的起始节点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lentghA = length(headA);
        int lengthB = length(headB);
        if (lentghA > lengthB) {
            int num = lentghA - lengthB;
            for ( int i = 0; i < num; i ++) {
                headA = headA.next;
            }
        } else {
            int num = lengthB - lentghA;
            for ( int i = 0; i < num; i ++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA== headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int length (ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }
        return length;
    }

    // LeetCode 141. 环形链表
    //给定一个链表，判断链表中是否有环。
    //如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
    // 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从
    // 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，
    // 仅仅是为了标识链表的实际情况。
    //如果链表中存在环，则返回 true 。 否则，返回 false 。
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //LeetCode 142. 环形链表 II
    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    //为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从
    // 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，
    // 并不会作为参数传递到函数中。
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode cur1 = head;
        ListNode cur2 = fast;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

}
