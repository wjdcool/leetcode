package 排序算法;

public class MergeSort {

    static int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

    public static void main(String[] args) {
        mergetSort(0, arr.length-1, arr);
        for (int x : arr) {
            System.out.println(x);
        }
    }

    public static void mergetSort(int left, int right, int[] nums) {
        if (left == right) {
            return;
        }else{
            int mid = (left + right) / 2;
            mergetSort(left, mid, nums);
            mergetSort(mid + 1, right, nums);
            sort(left, mid + 1, right, nums);
        }
    }

    public static void sort(int left, int mid, int right, int[] nums) {
        int[] leftArr = new int[mid - left];
        int[] rightArr = new int[right - mid +1];
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
