package 剑指offer.打印从1到最大的n位数17;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wjd
 * @Date 2020/10/30 10:12
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        printNumbers(3);
    }
    public static int[] printNumbers(int n) {
        if(n<1) return new int[0];
        int max = (int) (Math.pow(new Long(10),new Long(n))-1);
        int[] res = new int[max];
        for (int i = 1;i<=max;i++){
            res[i-1] = i;
        }
        return res;
    }
}
