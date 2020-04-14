/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * Created by wjd on 2020/4/14.
 */
public class MergeTwoIncrementLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
    /**
     * test example:
     *
     MergeTwoIncrementLinkedList ml = new MergeTwoIncrementLinkedList();
     MergeTwoIncrementLinkedList.ListNode node1= new MergeTwoIncrementLinkedList.ListNode(-9);
     MergeTwoIncrementLinkedList.ListNode node2= new MergeTwoIncrementLinkedList.ListNode(-7);
     MergeTwoIncrementLinkedList.ListNode node3= new MergeTwoIncrementLinkedList.ListNode(-3);
     MergeTwoIncrementLinkedList.ListNode node4= new MergeTwoIncrementLinkedList.ListNode(-3);
     MergeTwoIncrementLinkedList.ListNode node5= new MergeTwoIncrementLinkedList.ListNode(-1);
     MergeTwoIncrementLinkedList.ListNode node6= new MergeTwoIncrementLinkedList.ListNode(2);
     MergeTwoIncrementLinkedList.ListNode node7= new MergeTwoIncrementLinkedList.ListNode(3);
     node1.next = node2;
     node2.next = node3;
     node3.next = node4;
     node4.next = node5;
     node5.next = node6;
     node6.next = node7;

     MergeTwoIncrementLinkedList.ListNode n1= new MergeTwoIncrementLinkedList.ListNode(-7);
     MergeTwoIncrementLinkedList.ListNode n2= new MergeTwoIncrementLinkedList.ListNode(-7);
     MergeTwoIncrementLinkedList.ListNode n3= new MergeTwoIncrementLinkedList.ListNode(-6);
     MergeTwoIncrementLinkedList.ListNode n4= new MergeTwoIncrementLinkedList.ListNode(-6);
     MergeTwoIncrementLinkedList.ListNode n5= new MergeTwoIncrementLinkedList.ListNode(-5);
     MergeTwoIncrementLinkedList.ListNode n6= new MergeTwoIncrementLinkedList.ListNode(-3);
     MergeTwoIncrementLinkedList.ListNode n7= new MergeTwoIncrementLinkedList.ListNode(2);
     MergeTwoIncrementLinkedList.ListNode n8= new MergeTwoIncrementLinkedList.ListNode(4);
     n1.next = n2;
     n2.next = n3;
     n3.next = n4;
     n4.next = n5;
     n5.next = n6;
     n6.next = n7;
     n7.next = n8;
     */
}
