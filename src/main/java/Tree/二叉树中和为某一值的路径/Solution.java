package Tree.二叉树中和为某一值的路径;

import base.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wjd on 2020/4/21.
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 *  
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Solution {
    /**
     * Solution2 solution = new Solution2();

     TreeNode node1 = new TreeNode(5);
     TreeNode node2 = new TreeNode(4);
     TreeNode node3 = new TreeNode(8);
     TreeNode node4 = new TreeNode(11);
     TreeNode node5 = new TreeNode(13);
     TreeNode node6 = new TreeNode(4);
     TreeNode node7 = new TreeNode(7);
     TreeNode node8 = new TreeNode(2);
     TreeNode node9 = new TreeNode(5);
     TreeNode node10 = new TreeNode(1);
     node1.left = node2;
     node1.right = node3;
     node2.left = node4;
     node3.left = node5;
     node3.right = node6;
     node4.left = node7;
     node4.right = node8;
     node6.left = node9;
     node6.right = node10;
     solution.pathSum(null, 22);
     */
    List<List<Integer>> result = new ArrayList<>();

    //bfs解法
    public List<List<Integer>> pathtarget(TreeNode root, int target) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Pair<TreeNode, Pair<Integer, List<Integer>>>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, new Pair<>(0, new ArrayList<>())));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Pair<Integer, List<Integer>>> pair = queue.poll();
            TreeNode node = pair.getKey();
            int count = pair.getValue().getKey();
            List<Integer> record = pair.getValue().getValue();
            count = count + node.val;
            record.add(node.val);
            if (count == target && node.left ==null && node.right == null) {
                result.add(record);
                continue;
            }else{
                if (node.left != null) {
                    queue.add(new Pair<>(node.left, new Pair<>(count, new ArrayList<>(record))));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, new Pair<>(count, new ArrayList<>(record))));
                }
            }
        }
        return result;
    }

}
