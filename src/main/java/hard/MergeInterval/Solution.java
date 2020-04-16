package hard.MergeInterval;

import javafx.util.Pair;

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。

 示例 1:

 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2:

 输入: [[1,4],[4,5]]
 输出: [[1,5]]
 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

 * Created by wjd on 2020/4/16.
 */
public class Solution {
    class Node {
        Integer order;
        //左区间  右区间
        Pair<Integer, Integer> item;
        Node next;
        Node(Pair<Integer, Integer> p){
            item = p;
            order = p.getKey();
        }
    }
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        int width = intervals[0].length;
//        Node head =

        for(int i = 0;i<width;i++){

        }
        return null;
    }
}
