package number.汉明距离;

/**
 * Created by wjd on 2020/5/6.
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int c = x ^ y;
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = 1 << i;
            int d = tmp & c;
            if (d != 0) {
                total++;
            }
        }
        return total;
    }
}
