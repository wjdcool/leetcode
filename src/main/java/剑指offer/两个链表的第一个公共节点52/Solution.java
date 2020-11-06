package 剑指offer.两个链表的第一个公共节点52;

import base.ListNode;

import java.util.List;

/**
 * @Author wjd
 * @Date 2020/11/3 10:17
 * @Description
 **/
public class Solution {
    private String a = null;
    public static ListNode res = null;

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(0);
        ListNode n8 = new ListNode(1);
        ListNode n9 = new ListNode(8);
        ListNode n10 = new ListNode(4);
        ListNode n11 = new ListNode(5);
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        System.out.println(getIntersectionNode(n1, n6).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA, n2 = headB;
        while (n1 != n2) {//每个人都跑完两组链表，如果没有交叉，同时到达尾部
            n1 = n1 != null ? n1.next : headB;
            n2 = n2 != null ? n2.next : headA;
        }
        return n1;
    }
}
