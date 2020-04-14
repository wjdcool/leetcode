package 最大子序和;

public class FenZhi {

    public static int crossSum(int[] nums, int left, int right, int p) {
        if (left == right) return nums[left];

        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }


    /**
     * 此处递归可以理解为，三段比大小，每段从最小的力度，一级级将值往上推，最终三段进行比较
     */
    public static int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int p = (left + right) / 2;

        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);
        System.out.println("leftSum:"+left+" rightSum:"+rightSum+" crossSum:"+crossSum);
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public static void main(String[] args) {
        int[] nums = {2,1,-3,4,2,5,7,8};
        int a = helper(nums, 0, nums.length - 1);
        System.out.println(a);
    }

}
