package Tree.从前序遍历和中序遍历种构造二叉树;

import base.TreeNode;

import java.util.HashMap;

/**
 * Created by wjd on 2020/5/12.
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, indexMap);
        return root;
    }

    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> indexMap) {

        if (preorder.length == 0 || inorder.length == 0 || preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        //根据中序遍历计算根节点左边是否有子节点 既前序遍历后边的那位数字是否是左子树节点，或者没有左子树直接就是跟的右子树节点
        int count = indexMap.get(preorder[preStart]) - inStart;
        //inorder的index变动是因为 需要根据count计算出的根节点，确定左子树还是右子树进行下一个递归
        node.left = build(preorder, inorder, preStart + 1, preStart + count, inStart, inStart + count - 1, indexMap);
        node.right = build(preorder, inorder, preStart + count + 1, preEnd, inStart + count + 1, inEnd, indexMap);
        return node;
    }
}
