package LRU缓存机制;

/**
 * Created by wjd on 2020/5/19.
 */
public class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
