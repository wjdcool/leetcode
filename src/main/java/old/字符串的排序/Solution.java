package old.字符串的排序;

import java.util.*;

/**
 * Created by wjd on 2020/4/22.
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 * <p>
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 * <p>
 * 返回任意一种符合条件的字符串T。
 * <p>
 * 示例:
 * 输入:
 * S = "cba"
 * T = "abcd"
 * 输出: "cbad"
 * 解释:
 * S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 * 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 */
public class Solution {

    char[] c;
    List<String> list = new ArrayList<>();

    public List<String> permutation(String s) {
        c = s.toCharArray();
        seq(0);
        Collections.sort(list);
        return list;
    }

    public void seq(int x) {
        Set<Character> set = new HashSet<>();
        if (x == c.length - 1) {
            list.add(String.valueOf(c));
        }
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue;//剪枝操作，防止交换c[x] c[i] 相同的值时，防止abbc 这种abb出现两个分叉，实际上一个就可以
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位：可以理解为， 以a开头，然后进行第二层递归， 以ab或者ac开头进行第三层递归。。。。
            seq(x + 1); // 进行下一层递归
            swap(i, x); // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
