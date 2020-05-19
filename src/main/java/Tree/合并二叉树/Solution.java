package Tree.合并二叉树;

import base.TreeNode;

/**
 * Created by wjd on 2020/5/6.
 */
public class Solution {

    /**
     *  LRUCache solution = new LRUCache();
     *         TreeNode t1 = new TreeNode(1);
     *         TreeNode t2 = new TreeNode(3);
     *         TreeNode t3 = new TreeNode(2);
     *         TreeNode t4 = new TreeNode(5);
     *         t1.left = t2;
     *         t1.right = t3;
     *         t2.left = t4;
     *
     *         TreeNode r1 = new TreeNode(2);
     *         TreeNode r2 = new TreeNode(1);
     *         TreeNode r3 = new TreeNode(3);
     *         TreeNode r4 = new TreeNode(4);
     *         TreeNode r5 = new TreeNode(7);
     *         r1.left = r2;
     *         r1.right = r3;
     *         r2.right = r4;
     *         r3.right = r5;
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int t1Val = t1 == null ? 0 : t1.val;
        int t2Val = t2 == null ? 0 : t2.val;
        TreeNode head = new TreeNode(t1Val + t2Val);
        build(head, t1, t2);
        return head;
    }

    public TreeNode build(TreeNode node, TreeNode t1, TreeNode t2) {
        while (t1 == null && t2 == null) {
            return null;
        }
        int t1Val = t1 == null ? 0 : t1.val;
        int t2Val = t2 == null ? 0 : t2.val;
        if (node == null) {
            node = new TreeNode(t1Val + t2Val);
        } else {
            node.val = t1Val + t2Val;
        }
        if (t1 == null) {
            node.left = build(node.left, null, t2.left);
            node.right = build(node.right, null, t2.right);
        } else if (t2 == null) {
            node.left = build(node.left, t1.left, null);
            node.right = build(node.right, t1.right, null);
        } else {
            node.left = build(node.left, t1.left, t2.left);
            node.right = build(node.right, t1.right, t2.right);
        }
        return node;
    }
}
