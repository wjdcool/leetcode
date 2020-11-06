package 剑指offer.股票的最大利润63;

import java.util.List;

/**
 * @Author wjd
 * @Date 2020/10/30 10:23
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        int[] a = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > res) {
                res = prices[i] - min;
            }
        }
        return res;
    }

}
