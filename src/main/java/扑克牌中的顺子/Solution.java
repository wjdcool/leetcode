package 扑克牌中的顺子;

import java.util.HashSet;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        int king = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int c : nums) {
            if (c == 0) {
                king++;
            } else {
                if (c < min) {
                    min = c;
                }
                if (c > max) {
                    max = c;
                }
                set.add(c);
            }
        }
        int diff = max - min - 1;
        int rest = set.size() - 2 < 0 ? 0 : set.size() - 2;//除去头尾剩下不重复的牌
        if (king + set.size() < 5) {
            return false;
        }
        if (diff > rest + king) {
            return false;
        } else {
            return true;
        }
    }
}
