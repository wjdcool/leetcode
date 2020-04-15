package Matrix01;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * Created by wjd on 2020/4/15.
 */
public class Solution_Bfs {

    /**
     * 广度优先算法，从每个0节点超四个方向扩散所搜，check数组记录是否搜索过该节点，防止bfs重复搜索
     * test example
     * int[][] a = {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}};
     */

    public int[][] updateMatrix(int[][] matrix) {
        int length = matrix.length, width = matrix[0].length;
        int[][] check = new int[length][width];
        Queue<Pair<Integer, Integer>> zeroQueue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    zeroQueue.add(new Pair<>(i, j));
                    check[i][j] = 1;
                }
            }
        }

        while (!zeroQueue.isEmpty()) {
            Pair<Integer, Integer> pair = zeroQueue.poll();
            int n = pair.getKey();
            int m = pair.getValue();
            if (n - 1 >= 0 && check[n - 1][m] == 0) {
                matrix[n - 1][m] = matrix[n][m] + 1;
                check[n - 1][m] = 1;
                zeroQueue.add(new Pair<>(n - 1, m));
            }
            if (m - 1 >= 0 && check[n][m - 1] == 0) {
                matrix[n][m - 1] = matrix[n][m] + 1;
                check[n][m - 1] = 1;
                zeroQueue.add(new Pair<>(n, m - 1));
            }
            if (n + 1 < length && check[n + 1][m] == 0) {
                matrix[n + 1][m] = matrix[n][m] + 1;
                check[n + 1][m] = 1;
                zeroQueue.add(new Pair<>(n + 1, m));
            }
            if (m + 1 < width && check[n][m + 1] == 0) {
                matrix[n][m + 1] = matrix[n][m] + 1;
                check[n][m + 1] = 1;
                zeroQueue.add(new Pair<>(n, m + 1));
            }
        }

        return matrix;
    }
}
