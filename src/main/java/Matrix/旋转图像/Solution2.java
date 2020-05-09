package Matrix.旋转图像;

/**
 * Created by wjd on 2020/5/8.
 */
public class Solution2 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length == 0) return;
        int width = matrix[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < width; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < width; i++) {
            int j = 0;
            int m = length - 1;
            while (j <= m) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][m];
                matrix[i][m] = tmp;
                j++;m--;
            }
        }

        System.out.println(matrix);
    }
}
