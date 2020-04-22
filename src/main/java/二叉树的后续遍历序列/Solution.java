package 二叉树的后续遍历序列;

import java.util.Stack;

/**
 * Created by wjd on 2020/4/21.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

  

 参考以下这颗二叉搜索树：

 5
 / \
 2   6
 / \
 1   3
 示例 1：

 输入: [1,6,3,2,5]
 输出: false
 示例 2：

 输入: [1,3,2,6,5]
 输出: true
 */
public class Solution {
    /**
     * 从根节点往后推
     * 之所以不能正循环是因为 左节点和根节点并不连接中间会有别的节点，而反着循环，根节点前面两个一定为与根节点相连的左右子节点
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}
