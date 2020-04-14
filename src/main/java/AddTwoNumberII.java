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
        ListNode node;
        while (true) {
            boolean flag1 = stack1.isEmpty();
            boolean flag2 = stack2.isEmpty();
            Integer a = stack1.isEmpty() ? 0 : stack1.pop();
            Integer b = stack2.isEmpty() ? 0 : stack2.pop();
            if (flag1 && flag2) {
                if (temp > 0) {
                    node = new ListNode(temp);
                    if (head.next != null) {
                        next = head.next;
                        node.next = next;
                        head.next = node;
                    } else {
                        head.next = node;
                    }
                }
                break;
            } else {
                node = new ListNode((a + b + temp) % 10);
                if (head.next != null) {
                    next = head.next;
                    node.next = next;
                    head.next = node;
                } else {
                    head.next = node;
                }
            }
            temp = (a + b + temp) / 10;

        }
        return head.next;
    }
}
