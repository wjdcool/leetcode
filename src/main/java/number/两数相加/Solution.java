package number.两数相加;

import base.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {
    /**
     *  ListNode n1 = new ListNode(9);
     *         ListNode n2 = new ListNode(9);
     *         ListNode n3 = new ListNode(3);
     *         ListNode n4 = new ListNode(9);
     *         ListNode n5 = new ListNode(9);
     *         ListNode n6 = new ListNode(4);
     *         ListNode n7 = new ListNode(7);
     *         n1.next = n2;
     *         n2.next = n3;
     *         n4.next = n5;
     *         n5.next = n6;
     *         n6.next = n7;
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = new ListNode(0);
        head.next = node;
        int tmp = 0;
        int nodeValue = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (a + b + tmp > 9) {
                nodeValue = a + b + tmp - 10;
                tmp = (a + b + tmp) / 10;
            } else {
                nodeValue = a + b + tmp;
                tmp = 0;
            }
            ListNode n2 = new ListNode(nodeValue);
            node.next = n2;
            node = n2;
        }
        if (tmp > 0) {
            ListNode n2 = new ListNode(tmp);
            node.next = n2;
            node = n2;
        }
        return head.next.next;
    }
}
