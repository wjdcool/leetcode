package 剑指offer.青蛙跳台阶10;

/**
 * @Author wjd
 * @Date 2020/10/26 10:39
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(1000000008%1000000007);
        System.out.println(numWays(4));
    }

    public static int numWays(int n) {
        int[] dp = new int[n + 1];
        if (n <= 1) {
            return 1;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
            }
        }
        return dp[n];
    }
}
