package 剑指offer.字符串的排序38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author wjd
 * @Date 2020/11/4 10:09
 * @Description
 **/
public class Solution {
    char[] arr;
    List<String> res = new ArrayList<>();

    public String[] permutation(String s) {
        arr = s.toCharArray();
        dfs(0);
        return res.toArray(new String[arr.length]);
    }

    void dfs(int j) {
        if (j == arr.length - 1) {
            res.add(String.valueOf(arr));
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = j; i < arr.length; i++) {
            if (set.contains(arr[i])) continue;
            set.add(arr[i]);
            swap(i, j);
            dfs(j + 1);
            swap(i, j);
        }
    }
    void swap(int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
