package old.把数组排成最小的数;

/**
 * Created by wjd on 2020/4/23.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class Solution {

    public String minNumber(int[] nums) {
        order(0, nums.length - 1, nums);
        StringBuffer sb = new StringBuffer();
        for (int x : nums) {
            sb.append(x);
        }
        return sb.toString();
    }

    void order(int left, int right, int[] nums) {
        if (left >= right) return;
        int i = left;
        int j = right;
        int base = nums[left];
        while (i != j) {
            while (i != j) {
                if ((nums[j] + "" + base).compareTo(base + "" + nums[j]) >= 0) {
                    j--;
                } else {
                    break;
                }
            }

            while (i != j) {
                if ((nums[i] + "" + base).compareTo(base + "" + nums[i]) <= 0) {
                    i++;
                } else {
                    break;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        nums[left] = nums[i];
        nums[i] = base;
        order(left, i - 1, nums);
        order(i + 1, right, nums);
    }

}
