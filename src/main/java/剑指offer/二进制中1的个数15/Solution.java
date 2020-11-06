package 剑指offer.二进制中1的个数15;

import java.sql.SQLOutput;

/**
 * @Author wjd
 * @Date 2020/10/28 10:25
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        System.out.println("结果" + hammingWeight(Integer.MAX_VALUE));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
