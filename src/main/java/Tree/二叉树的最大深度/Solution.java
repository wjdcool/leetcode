package Tree.二叉树的最大深度;

import base.TreeNode;

/**
 * Created by wjd on 2020/5/7.
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 */
public class Solution {
    /**
     * Solution solution = new Solution();
     * TreeNode t1 = new TreeNode(1);
     * TreeNode t2 = new TreeNode(3);
     * TreeNode t3 = new TreeNode(2);
     * TreeNode t4 = new TreeNode(5);
     * TreeNode t5 = new TreeNode(6);
     * TreeNode t6 = new TreeNode(7);
     * t1.left = t2;
     * t1.right = t3;
     * t2.left = t4;
     * t4.left = t5;
     * t4.right = t6;
     */

    public int maxDepth(TreeNode root) {
        Integer count = 0;
        count = count(count, root);
        return count;
    }

    public int count(Integer count, TreeNode root) {
        if (root == null) {
            return count;
        }
        count++;
        int n1 = count(count, root.left);
        int n2 = count(count, root.right);
        return Math.max(n1, n2);
    }
}
