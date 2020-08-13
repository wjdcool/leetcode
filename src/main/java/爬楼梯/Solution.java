package 爬楼梯;

/**
 * @Author wjd
 * @Date 2020/6/12 12:15
 * @Description
 **/
public class Solution {
    public static int JumpFloorII(int target) {
        int[] dp = new int[target + 1];
        if (target == 1) {
            return 1;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                count = count + dp[j];
            }
            dp[i] = count + 1;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        JumpFloorII(4);
    }
}
