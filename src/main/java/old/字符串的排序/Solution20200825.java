package old.字符串的排序;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wjd
 * @Date 2020/8/5 11:25
 * @Description
 **/
public class Solution20200825 {
    char[] c;
    List<String> res = new ArrayList<>();

    public List<String> permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res;
    }

    public void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
        }
        for (int i = x; i < c.length; i++) {
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    public void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
