package number.除自身以外的乘积238;

/**
 * Created by wjd on 2020/5/9.
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int j = res.length - 1; j >= 0; j--) {
            res[j] = res[j] * k;
            k = k * nums[j];
        }
        return res;
    }
}
