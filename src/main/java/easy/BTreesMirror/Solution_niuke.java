package easy.BTreesMirror;

/**
 * Created by Administrator on 2020/4/15.
 */
public class Solution_niuke {
    public static class TreeNode {
        public int val;
        public Solution_niuke.TreeNode left;
        public Solution_niuke.TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    public void Mirror(TreeNode root) {
        if(root != null){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
