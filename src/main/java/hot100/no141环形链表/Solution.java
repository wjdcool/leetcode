package hot100.no141环形链表;

import base.ListNode;

import java.util.HashMap;

/**
 * @Author wjd
 * @Date 2020/12/1 9:33
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(hasCycle(null));
    }
    public static boolean hasCycle(ListNode head) {
        HashMap<ListNode, Boolean> exist = new HashMap<>();
        while (head!= null) {
            exist.put(head, true);
            if (exist.containsKey(head.next)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
