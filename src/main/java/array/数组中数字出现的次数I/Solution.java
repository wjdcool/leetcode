package array.数组中数字出现的次数I;

import java.util.HashMap;
import java.util.Set;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            if (count == 1) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }
        Set<Integer> set = map.keySet();
        int[] num = new int[set.size()];
        int i = 0;
        for (Integer x : set) {
            num[i] = x;
            i++;
        }
        return num;
    }
}
