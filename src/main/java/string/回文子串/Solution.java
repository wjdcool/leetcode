package string.回文子串;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wjd on 2020/5/14.
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 */
public class Solution {
    char[] c;
    int total = 0;

    public int countSubstrings(String s) {
        Set<Character> single = new HashSet<>();
        c = s.toCharArray();
        int mid = (c.length - 1) / 2;
        dfs(mid, mid);
        return total-2;
    }

    void dfs(int left, int right) {
        if ((left == 0 && right == c.length - 1) || (left == 0 || right == 0) || (left == c.length - 1 && right == c.length - 1)) {
            total++;
            return;
        }
        int tmpl = left;
        int tmpr = right;
        while (true) {
            if (left == right) {
                total++;
                break;
            }
            if (c[left] == c[right]) {
                if (right - left > 1) {
                    left++;
                    right--;
                } else if (right - left == 1) {
                    total++;
                    break;
                }
            }
        }
        if (right < c.length - 1 && left > 0) {
            dfs(tmpl - 1, tmpr + 1);
            dfs(tmpl + 1, tmpr + 1);
            dfs(tmpl - 1, tmpr - 1);
            dfs(tmpl, tmpr + 1);
            dfs(tmpl - 1, tmpr);
        }
        if (right < c.length - 1 && left == 0) {
            dfs(tmpl, tmpr + 1);
            dfs(tmpl, tmpr - 1);
        }

        if (right == c.length - 1 && left > 0) {
            dfs(tmpl - 1, tmpr);
            dfs(tmpl + 1, tmpr);
        }


    }
}
