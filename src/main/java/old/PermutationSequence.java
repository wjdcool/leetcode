package old;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/4/10.
 */
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<Integer> nList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nList.add(i);
        }
        List<Integer> result = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            int permutationCount = 1;
            for (int j = 1; j < i; j++) {
                permutationCount = permutationCount * j;
            }
            int temp = k;
            k = k % permutationCount;
            int index = 0;
            //除法向上取整
            if (k > 0) {
                index = temp / permutationCount;
                result.add(nList.get(index));
                nList.remove(index);
            } else {
                index = temp / permutationCount == 0 ? 0 : temp / permutationCount - 1;
                result.add(nList.get(index));
                nList.remove(index);
                for (int c = nList.size() - 1; c >= 0; c--) {
                    result.add(nList.get(c));
                }
                break;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Integer integer : result) {
            sb.append(integer);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }
}
