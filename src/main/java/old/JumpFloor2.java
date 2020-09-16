package old;

public class JumpFloor2 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target + 1];
        if (target == 1) {
            return 1;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                count = count + dp[j];
            }
            dp[i] = count + 1;
        }
        return dp[target];
    }
}
