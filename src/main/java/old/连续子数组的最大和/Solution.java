package old.连续子数组的最大和;

/**
 * Created by Administrator on 2020/4/23.
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (count < 0) {
                count = array[i];
            } else {
                count = count + array[i];
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
