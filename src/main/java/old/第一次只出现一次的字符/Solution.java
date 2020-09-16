package old.第一次只出现一次的字符;

import java.util.LinkedHashMap;

/**
 * Created by wjd on 2020/4/24.
 * <p>
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 */
public class Solution {

    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        char[] c = s.toCharArray();
        for (char x : c) {
            if (map.get(x) == null) {
                map.put(x, true);
            } else {
                map.put(x, false);
            }
        }
        for (Character result : map.keySet()) {
            if (map.get(result) == true) {
                return result;
            }
        }
        return ' ';
    }
}
