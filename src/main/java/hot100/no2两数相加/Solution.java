package hot100.no2两数相加;

import base.ListNode;

/**
 * @Author wjd
 * @Date 2020/11/11 10:21
 * @Description
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        int tmp = 0;
        while (l1.next != null && l2.next != null) {
            tmp = (l1.val + l2.val) >= 10 ? l1.val - l2.val : l1.val + l2.val;
        }
        return null;
    }

    void dfs(int tmp,ListNode head, ListNode l1, ListNode l2) {
        if (l1==null&&l2==null){
            return;
        }
        if (l1==null){

        }
        if (l2==null){

        }
        if ((l1.val + l2.val) >= 10) {

        }

    }
}
