package old.排序算法;

/**
 * Created by Administrator on 2020/4/13.
 */
public class QuickSort {
    static int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

    public static void main(String[] args) {
        quickSort(0, 9);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int base = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (i != j) {
                if (arr[j] >= base && i < j) {
                    j--;
                } else {
                    break;
                }
            }
            while (i != j) {
                if (arr[i] <= base && i < j) {
                    i++;
                } else {
                    break;
                }
            }
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[left] = arr[i];
        arr[i] = base;
        quickSort(0, i - 1);
        quickSort(i + 1, right);
    }

}
