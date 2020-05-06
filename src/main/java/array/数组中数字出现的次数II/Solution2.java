package array.数组中数字出现的次数II;

/**
 * Created by wjd on 2020/5/2.
 */
public class Solution2 {
    //数字转化成2进制后，每一位上如果有相同三位的话，除以3=0，将每位上除以=余1的组合起来就是那个不重复的树
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            Integer bit = 1 << i;
            int total = 0;
            for (int j = 0; j < nums.length; j++) {
                int tmp = nums[j] & bit;
                if (tmp != 0) {
                    total++;
                }
            }
            if (total % 3 != 0) {
                res = res | bit;
            }
        }
        return res;
    }
}
