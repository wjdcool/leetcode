package old;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * Created by wjd on 2020/4/14.
 */
public class AddTwoNumberII {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode head = new ListNode(1);
        ListNode next;
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int temp = 0;

        while (true) {
            Integer a = stack1.isEmpty() ? 0 : stack1.pop();
            Integer b = stack2.isEmpty() ? 0 : stack2.pop();

            ListNode newNode = new ListNode((temp + a + b) % 10);
            newNode.next = head.next;
            head.next = newNode;
            temp = (a + b + temp) / 10;
            if (temp == 0 && stack1.isEmpty() && stack2.isEmpty()) {
                break;
            }
        }
        return head.next;
    }
    /**
     * test example
     * old.AddTwoNumberII.ListNode n1 = new old.AddTwoNumberII.ListNode(7);
     old.AddTwoNumberII.ListNode n2 = new old.AddTwoNumberII.ListNode(2);
     old.AddTwoNumberII.ListNode n3 = new old.AddTwoNumberII.ListNode(4);
     old.AddTwoNumberII.ListNode n4 = new old.AddTwoNumberII.ListNode(3);


     old.AddTwoNumberII.ListNode t1 = new old.AddTwoNumberII.ListNode(5);
     old.AddTwoNumberII.ListNode t2 = new old.AddTwoNumberII.ListNode(6);
     old.AddTwoNumberII.ListNode t3 = new old.AddTwoNumberII.ListNode(4);
     n1.next =n2;
     n2.next = n3;
     n3.next =n4;

     t1.next = t2;
     t2.next = t3;
     */
}
