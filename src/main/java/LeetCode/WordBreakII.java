package LeetCode;

import java.util.*;

public class WordBreakII {
    /* First approach with recursion and prefix tree */
//    static List<String> res = new ArrayList();
//    public static List<String> wordBreak(String s, List<String> wordDict) {
//        // Preprocessing (i.e. insert dictionary words into trie)
//        PrefixTree trie = new PrefixTree();
//        for (String str : wordDict) {
//            trie.insert(str);
//        }
//        // Search solutions recursively
//        search(s, trie, 0, 0, new String());
//        return res;
//    }
//
//    private static void search(String s, PrefixTree trie, int left, int right, String sol) {
//        String tmp = s.substring(left, right + 1);
//        // Base case
//        if (right == s.length() - 1) {
//            if (trie.search(tmp)) {
//                sol += tmp;
//                res.add(sol);
//            }
//            return;
//        }
//        if (trie.search(tmp)) {
//            search(s, trie, right + 1, right + 1, sol + tmp + " ");
//        }
//        search(s, trie, left, right + 1, sol);
//    }

    /* Better solution with recursion and memoization */
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return search(s, wordDict, new HashMap<String, List<String>>());
    }

    private static List<String> search(String s, List<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        // Base case
        List<String> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String rest = s.substring(word.length());
                List<String> subStrings = search(rest, wordDict, memo);

                for (String subString : subStrings) {
                    String optSpace = subString.isEmpty() ? "" : " ";
                    res.add(word + optSpace + subString);
                }
            }
        }
        memo.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> res = wordBreak(s, wordDict);
        System.out.println(res.toString());
    }
}
