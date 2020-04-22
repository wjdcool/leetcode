package 栈的压入弹出序列;

import java.util.Stack;

/**
 * Created by wjd on 2020/4/21.
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushCount = 0;
        int popCount = 0;
        Stack<Integer> stack = new Stack<>();
        while (pushCount < pushed.length || popCount < popped.length) {
            if (stack.isEmpty() || stack.peek() != popped[popCount]) {
                if (pushCount == pushed.length) {
                    return false;
                } else {
                    stack.push(pushed[pushCount]);
                    pushCount++;
                }
            } else {
                stack.pop();
                popCount++;
            }
        }
        return true;
    }
}
