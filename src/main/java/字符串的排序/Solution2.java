package 字符串的排序;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wjd on 2020/5/7.
 * * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 * * <p>
 * * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 * * <p>
 * * 返回任意一种符合条件的字符串T。
 * * <p>
 * * 示例:
 * * 输入:
 * * S = "cba"
 * * T = "abcd"
 * * 输出: "cbad"
 * * 解释:
 * * S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 * * 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 */
public class Solution2 {
    char[] c;
    List<String> res = new ArrayList<>();

    public List<String> permutation(String s) {
        c = s.toCharArray();
        cesh(0);
        return res;
    }

    public void cesh(int level) {
        Set<Character> jz = new HashSet<>();
        if (level == c.length - 1) {
            res.add(String.valueOf(c));
        }
        for (int i = level; i < c.length; i++) {
            sweap(i, level);
            cesh(level + 1);
            sweap(i, level);
        }
    }

    void sweap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
