package 剑指offer.从尾到头打印链表06;

import base.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author wjd
 * @Date 2020/10/16 10:18
 * @Description
 **/
public class Solution2 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (true) {
            if (head == null) {
                break;
            }
            stack.add(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
    }
}
