package 剑指offer.从尾到头打印链表06;

import base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wjd
 * @Date 2020/10/16 9:56
 * @Description
 **/
public class Solution {
    static List<Integer> res = new ArrayList<>();

    public static int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }
        ListNode node = reverse(head);
        while (true) {
            res.add(node.val);
            node = node.next;
            if (node == null) {
                break;
            }
        }
        int[] a = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            a[i] = res.get(i);
        }
        return a;
    }

    public static ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode p = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        System.out.println(reversePrint(node));
    }
}
