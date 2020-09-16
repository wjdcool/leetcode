package old.数组中的逆序对;

/**
 * Created by wjd on 2020/4/24.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Solution {

    public int count = 0;

    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        split(0, nums.length - 1, nums);
        return count;
    }

    public void split(int left, int right, int[] nums) {
        if (left == right) {
            return;
        } else {
            int mid = (left + right) / 2;
            split(left, mid, nums);
            split(mid + 1, right, nums);
            sort(left, mid + 1, right, nums);
        }
    }

    public void sort(int left, int mid, int right, int[] nums) {
        int[] leftArr = new int[mid - left];
        int[] rightArr = new int[right - mid + 1];
        for (int i = left; i < mid; i++) {
            leftArr[i - left] = nums[i];
        }
        for (int i = mid; i <= right; i++) {
            rightArr[i - mid] = nums[i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                nums[k] = leftArr[i];
                k++;
                i++;
            } else {
                count = count + leftArr.length - i;
                nums[k] = rightArr[j];
                k++;
                j++;
            }
        }
        //右边数组用尽
        while (i < leftArr.length) {
            nums[k] = leftArr[i];
            k++;
            i++;
        }

        //左边数组用尽
        while (j < rightArr.length) {
            nums[k] = rightArr[j];
            k++;
            j++;
        }

    }
}
