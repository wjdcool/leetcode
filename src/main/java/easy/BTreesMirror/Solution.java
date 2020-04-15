package easy.BTreesMirror;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 * Created by wjd on 2020/4/15.
 */
public class Solution {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        TreeNode mirror = new TreeNode(root.val);
        return buildMirror(mirror, root);
    }

    TreeNode buildMirror(TreeNode mirror, TreeNode copy) {
        if (copy.right != null) {
            mirror.left = new TreeNode(copy.right.val);
            buildMirror(mirror.left,copy.right);
        }
        if(copy.left != null){
            mirror.right = new TreeNode(copy.left.val);
            buildMirror(mirror.right,copy.left);
        }
        return mirror;
    }
}
