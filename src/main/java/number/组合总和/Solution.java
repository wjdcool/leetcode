package number.组合总和;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjd on 2020/5/7.
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Solution {
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nums = candidates;
        test(0, target, new ArrayList<Integer>());
        return res;
    }

    void test(int start, int target, ArrayList<Integer> list) {
        if (list.stream().mapToInt(x -> x).sum() == target) {
            res.add(new ArrayList<>(list));
            return;
        } else if (list.stream().mapToInt(x -> x).sum() > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            test(i, target, list);
            if (list.size() > 0) {
                list.remove(list.size() - 1);
            }

        }
    }
}
