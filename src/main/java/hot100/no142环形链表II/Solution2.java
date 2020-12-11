package hot100.no142环形链表II;

import base.ListNode;

/**
 * @Author wjd
 * @Date 2020/12/2 18:58
 * @Description
 **/
public class Solution2 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;
        System.out.println(detectCycle(n1).val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                fast = head;
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        while (true) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
    }
}
