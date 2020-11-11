package hot100.no3无重复字符的最长子串;

import java.util.HashSet;

/**
 * @Author wjd
 * @Date 2020/11/11 11:23
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int max = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < arr.length) {
            if (set.contains(arr[right])){
                set.remove(arr[left]);
                left++;
            }else{
                set.add(arr[right]);
                right++;
                max = Math.max(right-left,max);
            }
        }
        return max;
    }
}
