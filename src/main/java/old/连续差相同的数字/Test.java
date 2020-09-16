package old.连续差相同的数字;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
 * <p>
 * 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 3, K = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 * 示例 2：
 * <p>
 * 输入：N = 2, K = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 9
 * 0 <= K <= 9
 */
public class Test {
    static List<Integer> result = new ArrayList<>();

    public static int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        for (int i = 1; i < 10; i++) {
            count(n - 1, i, i, k);
        }
        int[] nums = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            nums[i] = result.get(i);
        }
        return nums;
    }

    /**
     * @param deep 数字位数
     * @param last 当前个位上的值
     * @param value 总值
     * @param diff  差值
     */
    public static void count(int deep, int last, int value, int diff) {
        if (deep <= 0) {
            result.add(value);
            return;
        } else {
            deep--;
            //防止第一个递归后value发生变化
            int value2 = value;
            //新的个位比之前的大
            if (last + diff < 10) {
                value = value * 10 + diff + last;
                count(deep, diff + last, value, diff);
            }
            //新的个位比之前的小
            if (last - diff >= 0 && diff>0) {
                value2 = value2 * 10 + last - diff;
                count(deep, last - diff, value2, diff);
            }
            return;
        }
    }

    public static void main(String[] args) {
        numsSameConsecDiff(2, 0);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
