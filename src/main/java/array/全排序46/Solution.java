package array.全排序46;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjd on 2020/4/29.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        seq(0, nums, res);
        return res;
    }

    public void seq(int level, int[] nums, List<List<Integer>> res) {
        List<Integer> list = new ArrayList<>();
        for (int i = level; i < nums.length; i++) {
            if (level == nums.length-1) {
                for (int x : nums) {
                    list.add(x);
                }
                res.add(list);
            }
            swap(i, level, nums);
            seq(level + 1, nums, res);
            swap(i, level, nums);
        }
    }

    public void swap(int a, int b, int[] nums) {
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;

    }
}
