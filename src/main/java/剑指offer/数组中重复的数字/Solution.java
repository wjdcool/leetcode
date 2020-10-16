package 剑指offer.数组中重复的数字;

import java.util.HashMap;

/**
 * @Author wjd
 * @Date 2020/10/1 10:42
 * @Description
 **/
public class Solution {
    public static int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], nums[i]);
            } else {
                return nums[i];
            }
        }
        return 0;
    }
}
