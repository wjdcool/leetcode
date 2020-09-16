package old.ClockwisePrintMatrix;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

  

 示例 1：

 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 输出：[1,2,3,6,9,8,7,4,5]
 示例 2：

 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * Created by wjd on 2020/4/17.
 */
public class Solution {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int length = matrix.length;
        if (length == 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        int width = matrix[0].length;
        int left = 0, right = width, top = 0, bottom = length;
        int i = 0, j = 0;
        int count = 0;
        while (true) {
            for (int n = i; n < right; n++) {
                result.add(matrix[j][n]);
                count++;
            }
            i = right - 1;
            right--;
            if(count == length*width){
                break;
            }

            for (int n = j+1; n < bottom; n++) {
                result.add(matrix[n][i]);
                count++;
            }
            j = bottom -1;
            bottom--;
            if(count == length*width){
                break;
            }


            for (int n = i-1; n >= left; n--) {
                result.add(matrix[j][n]);
                count++;
            }
            i = left;
            left++;
            if(count == length*width){
                break;
            }

            for (int n = j-1; n > top; n--) {
                result.add(matrix[n][i]);
                count++;
            }
            i++;
            j = top +1;
            top++;
            if(count == length*width){
                break;
            }
        }
        return result;
    }

}
