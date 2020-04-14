package 删除链表中的重复元素;

import java.util.HashMap;

public class Test {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        deleteDuplicates(n1);
        ListNode h = n1;
        while (true) {
            System.out.println(h.val);
            if (h.next == null) {
                break;
            } else {
                h = h.next;
            }
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode h = head;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(head.val, head.val);
        while (h != null) {
            if (h.next == null) {
                break;
            } else {
                if (map.get(h.next.val) != null) {
                    if (h.next.next == null) {
                        h.next = null;
                    } else {
                        h = h.next.next;
                    }
                } else {
                    map.put(h.next.val,h.next.val);
                    h = h.next;
                }
            }
        }
        return h;
    }
}
