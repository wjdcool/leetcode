package Tree.二叉搜索树与双向链表;

/**
 * Created by Administrator on 2020/4/22.
 */
public class Solution {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head;
    Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        check(root);
        //最后一次循环后，pre及是最后一个节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    void check(Node node) {
        if (null == node) return;
        check(node.left);
        if(pre!=null){
            pre.right = node;
        }else{
            head = node;
        }
        node.left = pre;
        pre = node;
        check(node.right);
    }

}
