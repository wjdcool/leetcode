package 剑指offer.斐波那契数列10;

/**
 * @Author wjd
 * @Date 2020/10/19 10:08
 * @Description
 **/
public class Solution {
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])% 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(45));
    }
}
