package 复杂链表的复制;

import base.Node;

import java.util.HashMap;

/**
 * Created by wjd on 2020/4/22.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * ，返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution {
    /**
     *    Solution solution = new Solution();
     Node node1 = new Node(1);
     Node node2 = new Node(2);
     Node node3 = new Node(3);
     Node node4 = new Node(4);

     //        node1.random = node1;

     node1.next = node2;
     node2.next = node3;
     node3.next = node4;
     node1.random = node3;
     node2.random = node3;

     //        node3.next = node4;
     //        node4.next = node5;
     //        node2.random = node1;
     //        node3.random = node5;
     //        node4.random = node3;
     //        node5.random = node1;
     solution.copyRandomList(node1);
     * @param pHead
     * @return
     */
    public Node copyRandomList(Node pHead) {
        HashMap<Integer, Node> map = new HashMap<>();
        if (pHead == null) {
            return null;
        } else {
            Node node = new Node(0);
            Node newHead = new Node(0);
            newHead.next = node;
            while (pHead != null) {
                node.val = pHead.val;
                Node oldNextNode = pHead.next;
                if (oldNextNode != null) {
                    if (map.get(oldNextNode.hashCode()) != null) {
                        node.next = map.get(oldNextNode.hashCode());
                    } else {
                        Node nextNode = new Node(oldNextNode.val);
                        node.next = nextNode;
                        map.put(pHead.hashCode(), node);
                        map.put(oldNextNode.hashCode(), nextNode);
                    }
                }
                if (pHead.random != null) {
                    if (map.get(pHead.random.hashCode()) != null) {
                        node.random = map.get(pHead.random.hashCode());
                    } else {
                        if (pHead.random == pHead) {
                            node.random = node;
                            map.put(pHead.hashCode(), node);
                            map.put(pHead.random.hashCode(), node);
                        } else {
                            Node randomNode = new Node(pHead.random.val);
                            node.random = randomNode;
                            map.put(pHead.hashCode(), node);
                            map.put(pHead.random.hashCode(), randomNode);
                        }

                    }
                }
                pHead = pHead.next;
                node = node.next;
            }

            return newHead.next;
        }
    }
}
