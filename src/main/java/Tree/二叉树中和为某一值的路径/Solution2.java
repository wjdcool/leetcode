package Tree.二叉树中和为某一值的路径;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/4/22.
 */
public class Solution2 {
    List<List<Integer>> result = new ArrayList<>();

    //dfs
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        add(root, new ArrayList<>(), 0, sum);
        return result;
    }

    void add(TreeNode node, List<Integer> list, int count, int sum) {
        if (null == node) {
            return;
        }
        list.add(node.val);
        count = node.val + count;
        if (count == sum && node.left == null & node.right == null) {
            result.add(list);
        }
        add(node.left, new ArrayList<>(list), count, sum);
        add(node.right, new ArrayList<>(list), count, sum);
    }
}
