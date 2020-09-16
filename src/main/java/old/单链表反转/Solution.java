package old.单链表反转;

import base.Node;

/**
 * @Author wjd
 * @Date 2020/8/12 18:26
 * @Description
 **/
public class Solution {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverse(node1);

    }
    public static Node reverse(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node p = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }
}
