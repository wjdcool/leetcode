package 剑指offer.二叉搜索树的第k大节点54;

import base.TreeNode;

/**
 * @Author wjd
 * @Date 2020/11/9 16:29
 * @Description
 **/
public class Solution {
    static int res = 0;
    static int c = 0;

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        System.out.println(kthLargest(n1, 3));
    }

    public static int kthLargest(TreeNode root, int k) {
        c = k;
        dfs(root);
        return res;
    }

    static void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.right);
            c--;
            if (c == 0) {
                res = node.val;
            }
            dfs(node.left);
        }
    }
}
