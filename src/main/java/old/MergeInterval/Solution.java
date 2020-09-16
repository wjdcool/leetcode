package old.MergeInterval;

import javafx.util.Pair;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * Created by wjd on 2020/4/16.
 */
public class Solution {
    class Node {
        //排序左区间为准
        Integer order;
        //左区间  右区间
        Pair<Integer, Integer> item;
        Node next;

        Node(Pair<Integer, Integer> p) {
            item = p;
            order = p.getKey();
        }
    }

//    public int[][] merge(int[][] intervals) {
//        int length = intervals.length;
//        int width = intervals[0].length;
//        Node head = null;
//
//        for (int i = 0; i < width; i++) {
//            if (head == null) {
//                Pair<Integer, Integer> pari = new Pair<>(intervals[0][i], intervals[1][i]);
//                Node node = new Node(pari);
//            } else {
//
//            }
//        }
//        return null;
//    }

//    Node merge(Node head, Pair<Integer, Integer> pair) {
//        if (head.order > pair.getValue()) {
//            Node node = new Node(pair);
//            node.next = head;
//            return node;
//        } else if (head.order == pair.getValue()) {
//            Pair<Integer, Integer> newPair = new Pair<>(pair.getKey(), head.item.getValue());
//            Node node = new Node(newPair);
//            node.next = head.next;
//            return node;
//        } else if (head.order < pair.getValue()) {
//            if (pair.getKey() <= head.order && pair.getValue() <= head.item.getValue()) {
//
//            } else if (pair.getKey() >= head.order && pair.getValue() <= head.item.getValue()) {
//
//            }else if(){
//
//            }
//        }
}
