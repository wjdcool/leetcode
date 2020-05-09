package Matrix.最小路径和;

/**
 * Created by wjd on 2020/5/9.
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int length = grid.length;
        if (length == 0) {
            return 0;
        }
        int width = grid[0].length;
        int[][] dp = new int[length][width];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < width; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < width; j++) {
                if (dp[i - 1][j] <= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }
        return dp[length - 1][width - 1];
    }
}
