package old.零钱兑换;

import java.util.Arrays;

/**
 * Created by wjd on 2020/5/9.
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class Solution {
    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void dfs(int[] coins, int index, int amount, int cnt) {
        if (index < 0) {
            return;
        }
        for (int c = amount / coins[index]; c >= 0; c--) {
            int na = amount - c * coins[index];
            int ncnt = cnt + c;
            if (na == 0) {
                ans = Math.min(ans, ncnt);
                break;//剪枝1
            }
            if (ncnt + 1 >= ans) {
                break; //剪枝2
            }
            dfs(coins, index - 1, na, ncnt);
        }
    }

}
