package hot100.no142环形链表II;

import base.ListNode;

import java.util.HashMap;

/**
 * @Author wjd
 * @Date 2020/12/2 18:55
 * @Description
 **/
public class Solution {

    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Boolean> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return head;
            } else {
                map.put(head, true);
            }
            head = head.next;
        }
        return null;
    }
}
