package old.最小k个数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wjd on 2020/4/23.
 */
public class Solution {
    public int[] smallestK(int[] arr, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
        }
        Collections.sort(list);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }
        ArrayList<Integer> ceshi = new ArrayList<>(list.subList(0,k));
        list.subList(0,k);
        return result;
    }
}
