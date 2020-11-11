package hot100.no5最长回文子串;

import com.sun.scenario.effect.impl.state.AccessHelper;

/**
 * @Author wjd
 * @Date 2020/11/11 16:23
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("5"));
    }

    public static String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        String res = null;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            String a = check(arr,i,i);
            String b = check(arr,i,i+1);
            String tmp = a.length() >= b.length() ? a : b;
            if (tmp.length()>max){
                max = tmp.length();
                res = tmp;
            }
        }
        return res;
    }

    static String check(char[] arr, int i, int j) {
        while (i >= 0 && j <= arr.length - 1) {
            if (arr[i] != arr[j]) {
                break;
            } else {
                i--;
                j++;
            }
        }
        i++;//回溯最后一次加减操作防止数组越界
        return String.valueOf(arr, i, j - i);
    }
}
