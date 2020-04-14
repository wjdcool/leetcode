package 青蛙过河;

import java.util.*;

public class Test {
    public static boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        /**
         * 解题思路：
         * 每一步保存当前步数可有上一步通过+n步到达，然后根据当前n+-1的操作，看看后续是否有这些石头，如果没有则无法过河
         */
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            Set<Integer> preSteps = map.get(stones[i]);
            for (Integer num : preSteps) {
                int same = stones[i] + num;
                if (map.get(same) != null && same != stones[i]) {
                    map.get(same).add(num);
                }
                int bigger = stones[i] + num + 1;
                if (map.get(bigger) != null && bigger != stones[i]) {
                    map.get(bigger).add(num + 1);
                }
                int smaller = stones[i] + num - 1;
                if (map.get(smaller) != null && smaller != stones[i]) {
                    map.get(smaller).add(num - 1);
                }
            }
        }
        if (map.get(stones[stones.length - 1]).size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int nums[] = {0,1,3,4,5,7,9,10,12};
        System.out.println(canCross(nums));
    }
}
