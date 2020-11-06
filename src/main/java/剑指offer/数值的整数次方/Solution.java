package 剑指offer.数值的整数次方;

/**
 * @Author wjd
 * @Date 2020/10/30 9:34
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(myPow(2,4));
    }
    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) {
                System.out.println(b);
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
