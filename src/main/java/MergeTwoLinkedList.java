/**
 * 合并两个递增排序链表
 */
public class MergeTwoLinkedList {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(1);
        ListNode first = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            } else {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null && l2 != null) {
            head.next = l2;
            return first.next;
        }
        if (l1 != null && l2 == null) {
            head.next = l1;
            return first.next;
        }
        return first.next;
    }
}
