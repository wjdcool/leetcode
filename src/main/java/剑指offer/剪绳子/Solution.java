package 剑指offer.剪绳子;

/**
 * @Author wjd
 * @Date 2020/8/11 17:34
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }

    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            return (int) (Math.pow(3, n / 3-1) * (n % 3 +3));
        } else {
            return (int) (Math.pow(3, n / 3) * (n % 3));
        }
    }
}
