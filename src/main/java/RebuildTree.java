import java.util.HashMap;

public class RebuildTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            indexMap.put(in[i], i);
        }
        TreeNode root = buildTree(pre, 0, pre.length - 1, in, 0, in.length - 1, indexMap);
        return root;
    }

    public static TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, HashMap<Integer, Integer> indexMap) {
        if (pre.length == 0 || in.length == 0 || preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);

        //通过中序遍历算出节点长度
        int count = indexMap.get(pre[preStart]) - inStart;

        root.left = buildTree(pre, preStart + 1, preStart + count, in, inStart, inStart + count - 1, indexMap);
        root.right = buildTree(pre, preStart + count + 1, preEnd, in, inStart + count + 1, inEnd, indexMap);

        return root;
    }


    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode result = reConstructBinaryTree(pre, in);
        System.out.println(result.val);
    }
}
