package MinimumWindowSubstring;

import java.util.HashMap;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 示例：
 输入: S = "ADOBECODEBANC", T = "ABC"
 输出: "BANC"
 * Created by wjd on 2020/4/15.
 */
public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> needMap = new HashMap<>();
        char[] charArr = t.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            int count = needMap.getOrDefault(charArr[i], 0);
            needMap.put(charArr[i], count + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int total = 0;
        int length = 0;
        HashMap<Integer, String> result = new HashMap<>();
        char[] targetArr = s.toCharArray();
        while (true) {
            if (right < targetArr.length && total < charArr.length) {
                //右指针滑动
                if (needMap.containsKey(targetArr[right])) {
                    if(window.getOrDefault(targetArr[right], 0) < needMap.get(targetArr[right])){
                        total++;
                    }
                    Integer count = window.getOrDefault(targetArr[right], 0);
                    count++;
                    window.put(targetArr[right], count);
                }
                right++;
            }

            //左指针滑动
            if (total == charArr.length || right >= targetArr.length) {
                if (total == charArr.length) {
                    if (result.keySet().size() == 0) {
                        result.put(right - left, s.substring(left, right));
                        length = right - left;
                    } else {
                        if (length > (right - left) && total == charArr.length) {
                            result.put(right - left, s.substring(left, right));
                            length = right - left;
                        }
                    }
                }
                Character cutItem = targetArr[left];
                left++;
                int count = window.getOrDefault(cutItem,0);
                count--;
                window.put(cutItem,count);
                if (needMap.containsKey(cutItem) && window.get(cutItem)<needMap.get(cutItem)) {
                    total--;
                }
            }
            if (right >= targetArr.length && left >= targetArr.length) {
                break;
            }
        }
        return result.getOrDefault(length, "");
    }
}
