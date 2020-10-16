package 剑指offer.空格替换05;

/**
 * @Author wjd
 * @Date 2020/10/16 9:52
 * @Description
 **/
public class Solution {
    public static String replaceSpace(String s) {
        char[] arr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : arr) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }


}
