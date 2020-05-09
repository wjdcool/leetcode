package Matrix.旋转图像;

/**
 * Created by wjd on 2020/5/8.
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length == 0) return;
        int width = matrix[0].length;
        int[][] copy = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = width - 1; j >= 0; j--) {
                matrix[i][j] = copy[width - j - 1][i];
            }
        }
    }
}
