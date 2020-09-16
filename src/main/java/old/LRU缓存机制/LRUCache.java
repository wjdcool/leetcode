package old.LRU缓存机制;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wjd on 2020/5/19.运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
public class LRUCache {

    Node head;
    int capacity;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    class Node {
        public Node(int value) {
            this.value = value;
        }

        public Node next;
        public Node pre;
        public Node end;
        public int value;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            mvTop(key);
            return map.get(key);
        }
        return -1;
    }

    public void addTop(int key,Boolean full){
        Node node = new Node(key);
        node.next= head;
        if(full){
            node.end = head.end.pre;
        }else{
            node.end = head.end;
        }
        head.end = null;
        head = node;
    }

    public void mvTop(int key) {
        Node node = head;
        while (node != null) {
            if (node.value == key) {
                Node pre = node.pre;
                Node next = node.next;
                if (pre != null) {
                    pre.next = next;
                }
                if (next != null) {
                    next.pre = pre;
                }
                head.pre = node;
                if (node == head.end) {
                    node.end = pre;
                } else {
                    node.end = head.end;
                }
                head.end = null;
                node.next = head;
                head.pre = node;
                break;
            }
            node = node.next;
        }
    }

    public void put(int key, int value) {

    }
}
