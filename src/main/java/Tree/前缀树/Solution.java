package Tree.前缀树;

/**
 * Created by wjd on 2020/5/9.
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 */
public class Solution {
    public static class Trie {

        Trie[] node;

        public String value;

        public boolean end;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            node = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] c = word.toCharArray();
            Trie[] tmp = node;
            for (int i = 0; i < c.length; i++) {
                if (tmp[c[i] - 'a'] != null) {
                    if (i == c.length - 1) {
                        tmp[c[i] - 'a'].end = true;
                    }
                    tmp = tmp[c[i] - 'a'].node;
                } else {
                    tmp[c[i] - 'a'] = new Trie();
                    tmp[c[i] - 'a'].value = String.valueOf(c[i]);
                    if (i == c.length - 1) {
                        tmp[c[i] - 'a'].end = true;
                    }
                    tmp = tmp[c[i] - 'a'].node;
                }
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] c = word.toCharArray();
            Trie[] tmp = node;
            boolean end = false;
            for (int i = 0; i < c.length; i++) {
                if (tmp[c[i] - 'a'] != null) {
                    if (i == c.length - 1) {
                        if (tmp[c[i] - 'a'].end != true) {
                            return false;
                        }
                    }
                    tmp = tmp[c[i] - 'a'].node;
                } else {
                    return false;
                }
            }
            return true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] c = prefix.toCharArray();
            Trie[] tmp = node;
            for (int i = 0; i < c.length; i++) {
                if (tmp[c[i] - 'a'] != null) {
                    tmp = tmp[c[i] - 'a'].node;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
