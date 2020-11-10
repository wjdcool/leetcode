package hot100.no1下一个排列;

import java.util.Collections;
import java.util.Iterator;

/**
 * @Author wjd
 * @Date 2020/11/10 10:16
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2};
        nextPermutation(a);
        System.out.println(a);
    }

    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {//被交换数从右到左边 [4,2,0,2,3,2,0]， 2，3先交换，而不是0，2,交换后，后面的数字正序重新排列
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    reverse(i + 1, nums);
                    return;
                }
            }
        }
        reverse(0, nums);
    }

    static void reverse(int left, int[] nums) {
        int right = nums.length - 1;
        while (true) {
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            if (right == left || right - left == 1) {
                break;
            }
            left++;
            right--;
        }
    }
}
