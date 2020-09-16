package old.数组中长度超过一半的数字;

import java.util.HashMap;

/**
 * Created by Administrator on 2020/4/23.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        double a = nums.length;
        double b = 2;
        double c = a/b;
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.getOrDefault(nums[i], 0);
            count++;
            if (count >= Math.ceil(c)) {
                return nums[i];
            } else {
                map.put(nums[i], count);
            }
        }

        return 0;
    }
}
