package 剑指offer.滑动窗口的最大值59;

/**
 * @Author wjd
 * @Date 2020/11/5 10:07
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        int[] a = new int[]{};
        System.out.println(maxSlidingWindow(a, 0));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        while (left < res.length) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i < left+k; i++) {
                max = Math.max(max, nums[i]);
            }
            res[left] = max;
            left++;
        }
        return res;
    }
}
