package LeetCode;

import java.util.*;

public class StreamCharacters {
    class Trie {
        public Trie[] children;
        public boolean isWord;

        public Trie() {
            children = new Trie[26];
            isWord = false;
        }

        public void insert(String s) {
            Trie t = this;
            for (char c : s.toCharArray()) {
                if (t.children[c-'a'] == null)
                    t.children[c-'a'] = new Trie();
                t = t.children[c-'a'];
            }
            t.isWord = true;
        }

        public boolean search(Deque<Character> queries) {
            Trie t = this;
            for (char c : queries) {
                if (t.children[c-'a'] == null) return false;
                t = t.children[c-'a'];
                if (t.isWord) return true;
            }
            return false;
        }
    }

    private static Trie trie;
    private static Deque queries;

    public StreamCharacters(String[] words) {
        trie = new Trie();
        for (String s : words) {
            String strRev = new StringBuilder(s).reverse().toString();
            trie.insert(strRev);
        }
        queries = new LinkedList();
    }

    public static boolean query(char letter) {
        queries.addFirst(letter);
        return trie.search(queries);
    }

    public static void main(String[] args) {
        String[] str = {"cd", "f", "kl"};
        StreamCharacters stream = new StreamCharacters(str);
        System.out.println(stream.query('a'));
        System.out.println(stream.query('b'));
        System.out.println(stream.query('c'));
        System.out.println(stream.query('d'));
        System.out.println(stream.query('e'));
        System.out.println(stream.query('f'));
    }
}
