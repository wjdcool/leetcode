package 剑指offer.n个骰子的点数60;

/**
 * @Author wjd
 * @Date 2020/11/6 9:47
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        dicesProbability(2);
    }

    public static double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {//骰子个数
            for (int j = i; j <= 6 * i; j++) {//总点数
                for (int c = 1; c <= 6; c++) {//当前一轮的点数
                    if (c >= j) break;
                    dp[i][j] += dp[i - 1][j - c];
                }
            }
        }
        double[] res = new double[5 * n + 1];
        int count = 0;
        for (int i = n; i <= 6 * n; i++) {
            if (dp[n][i] > 0) {
                res[count] = dp[n][i] / Math.pow(6, n);
                count++;
            }
        }
        return res;
    }
}
