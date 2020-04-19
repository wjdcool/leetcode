package JumpGame;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionDfs {
    public static boolean canJump(int[] nums) {
        int length = nums.length;
        Queue<Pair<Integer, Integer>> que = new LinkedList<Pair<Integer, Integer>>();
        que.add(new Pair<>(0, nums[0]));
        while (!que.isEmpty()) {
            Pair<Integer, Integer> pair = que.poll();
            if (pair.getValue() + pair.getKey() >= length-1) {
                return true;
            } else {
                for (int i = 1; i <= pair.getValue(); i++) {
                    if(pair.getKey()+ i> 0){
                        que.add(new Pair<>(pair.getKey()+i, nums[pair.getKey()+i]));
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
