package old;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * Created by wjd on 2020/4/14.
 */
public class TreesChildTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return check(root1.left, root2.left) && check(root1.right, root2.right);
            //此解法考虑了二叉树节点元素重复的情况
//            boolean result = check(A.left, B.left) && check(A.right, B.right);
//            if(result){
//                return true;
//            }else{
//                return HasSubtree(A.left, B) || HasSubtree(A.right,B);
//            }
        } else {
            return isSubStructure(root1.left, root2) || isSubStructure(root1.right, root2);
        }
    }

    boolean check(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }

        if (root1.val == root2.val) {
            return check(root1.left, root2.left) && check(root1.right, root2.right);
        } else {
            return false;
        }
    }
    /**
     * test example:
     *
     old.TreesChildTree.TreeNode head = new old.TreesChildTree.TreeNode(8);
     old.TreesChildTree.TreeNode t1 = new old.TreesChildTree.TreeNode(8);
     old.TreesChildTree.TreeNode t2 = new old.TreesChildTree.TreeNode(7);
     old.TreesChildTree.TreeNode t3 = new old.TreesChildTree.TreeNode(9);
     old.TreesChildTree.TreeNode t4 = new old.TreesChildTree.TreeNode(2);
     old.TreesChildTree.TreeNode t5 = new old.TreesChildTree.TreeNode(4);
     old.TreesChildTree.TreeNode t6 = new old.TreesChildTree.TreeNode(7);
     head.left = t1;
     head.right = t2;


     old.TreesChildTree.TreeNode r1 = new old.TreesChildTree.TreeNode(8);
     old.TreesChildTree.TreeNode r2 = new old.TreesChildTree.TreeNode(9);
     old.TreesChildTree.TreeNode r3 = new old.TreesChildTree.TreeNode(2);
     r1.left = r2;
     r1.right = r3;
     old.TreesChildTree ceshi = new old.TreesChildTree();
     System.out.println(ceshi.isSubStructure(head, r1));
     */
}
