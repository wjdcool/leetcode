package 最大子序和;

public class Dp {
    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            if (max + nums[i] > 0) {
                if(max<0){
                    max = nums[i];
                }else{
                    max = max + nums[i];
                }
                if(result < max){
                    result = max;
                }
            } else {
                if(i<nums.length-1){
                    if(nums[i] > result){
                        result = nums[i];
                    }
                    max = 0;
                    if(nums[i] >= 0){
                        max = nums[i];
                        if(result<max){
                            result = max;
                        }
                    }
                }else{
                    max = nums[i];
                    if(max > result){
                        result = max;
                    }
                }

            }
        }
        if(max > result){
            result = max;
        }
        return result;
    }
}
