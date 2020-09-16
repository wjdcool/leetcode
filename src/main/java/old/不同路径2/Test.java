package old.不同路径2;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 */
public class Test {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        boolean tag = false;
        for (int i = 0; i < n; i++) {
            if (tag) {
                dp[0][i] = 0;
            } else {
                if (obstacleGrid[0][i] == 1) {
                    tag = true;
                    dp[0][i] = 0;
                } else {
                    dp[0][i] = 1;
                }
            }
        }
        boolean tag1 = false;
        for (int i = 0; i < m; i++) {
            if (tag1) {
                dp[i][0] = 0;
            } else {
                if (obstacleGrid[i][0] == 1) {
                    dp[i][0] = 0;
                    tag1 = true;
                } else {
                    dp[i][0] = 1;
                }
            }

        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int length = 0;
                int width = 0;
                if (obstacleGrid[i - 1][j] == 1) {
                    length = 0;
                } else {
                    length = dp[i - 1][j];
                }

                if (obstacleGrid[i][j - 1] == 1) {
                    width = 0;
                } else {
                    width = dp[i][j - 1];
                }
                dp[i][j] = length + width;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{0,0},{0,1}};
        System.out.println(uniquePathsWithObstacles(a));
    }
}
