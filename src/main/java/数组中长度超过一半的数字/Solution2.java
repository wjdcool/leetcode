package 数组中长度超过一半的数字;

/**
 * Created by Administrator on 2020/4/23.
 */
public class Solution2 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int vote = 0;
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (vote == 0) {
                num = array[i];
                vote++;
            } else {
                if (num == array[i]) {
                    vote++;
                } else {
                    vote--;
                    num = array[i];
                }
            }
        }
        return num;
    }
}
