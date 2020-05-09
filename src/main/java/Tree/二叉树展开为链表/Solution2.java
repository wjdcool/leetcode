package Tree.二叉树展开为链表;

import base.TreeNode;

/**
 * Created by wjd on 2020/5/8.
 */
public class Solution2 {
    TreeNode pre = null;


    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;

    }
}
