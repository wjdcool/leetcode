package array.讲数组分成相等的三部分;

public class Solution {

    public boolean canThreePartsEqualSum(int[] A) {
        if (A.length < 1) {
            return false;
        }
        int midCount = 0;
        for (int i = 0; i < A.length; i++) {
            midCount = midCount + A[i];
        }

        if (midCount % 3 != 0) {
            return false;
        }
        int part = midCount / 3;
        int left = 0;
        int right = A.length - 1;
        int leftCount = A[left];
        int rightCount = A[right];
        midCount = midCount - leftCount - rightCount;
        while (left < right - 1) {

            if (rightCount != part) {
                right--;
                rightCount = rightCount + A[right];
                midCount = midCount - A[right];
            }

            if (leftCount != part) {
                left++;
                leftCount = leftCount + A[left];
                midCount = midCount - A[left];
            }

            if (leftCount == part && rightCount == part && midCount == part && Math.abs(left - right) > 1) {
                return true;
            }
        }
        return false;
    }
}
