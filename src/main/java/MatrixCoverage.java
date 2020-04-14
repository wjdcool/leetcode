public class MatrixCoverage {
    public int RectCover(int target) {
        //动态规划解法
//        if (target == 1) {
//            return 1;
//        }
//        int[] dp = new int[target + 1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for(int i = 3;i<=target;i++){
//            dp[i]  = dp[i-1]+dp[i-2];
//        }
//        return dp[target];


        //递归解法--本质Fibonacci数
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target-2) + RectCover(target -1);
    }
}
