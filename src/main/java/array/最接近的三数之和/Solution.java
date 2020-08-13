package array.最接近的三数之和;

import java.util.Arrays;

/**
 * @Author wjd
 * @Date 2020/6/24 10:37
 * @Description 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums ={1,2,4,8,16,32,64,128};
        System.out.println(threeSumClosest(nums, 82));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int tmp = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - tmp) < Math.abs(target - res)) {
                    res = tmp;
                }
                if (tmp > target) {
                    end--;
                } else if (tmp < target) {
                    start++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}
