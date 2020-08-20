package 剑指offer.剪绳子II;

/**
 * @Author wjd
 * @Date 2020/8/12 11:11
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }
    public static int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        long res=1L;
        int p=(int)1e9+7;
        //贪心算法，优先切三，其次切二
        while(n>4){
            res=res*3;
            n-=3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int)(res*n);
    }

    //最大值问题
//    public static int cuttingRope(int n) {
//        int p=(int)1e9+7;
//        if (n <= 3) {
//            return n - 1;
//        }
//        if (n % 3 == 0) {
//            double a =  Math.pow(3, n / 3);
//            return (int) (a%p);
//        } else if (n % 3 == 1) {
//            double a = (Math.pow(3, n / 3 - 1) * (n % 3 + 3));
//            return (int) (a%p);
//        } else {
//            double a = (Math.pow(3, n / 3) * (n % 3));
//            return (int) (a%p);
//        }
//    }
}
