package old;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by wjd on 2020/4/10.
 */
public class CoinChange {

    static class Node {
        int left;
        int coins;
        String permutation;

        Node(int a, int b, String c) {
            left = a;
            coins = b;
            permutation = c;
        }
    }

    public static int change(int amount, int[] coins) {
        if(amount == 0){
            return 1;
        }
        Set<Integer> result = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(amount, 0, ""));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] < node.left) {
                    queue.add(new Node(node.left - coins[i], node.coins + 1, node.permutation + "+" + coins[i]));
                } else if (coins[i] == node.left) {
                    result.add(node.coins + 1);
                } else {
                    continue;
                }
            }
        }
        return result.size();
    }

    public static void main(String[] args) {
        int[] coins = {};
        System.out.println(change(0, coins));
    }
}
