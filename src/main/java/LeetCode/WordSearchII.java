package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Trie {
  public Trie[] children;
  public boolean endOfWord;

  public Trie() {
    endOfWord = false;
    children = new Trie[26];
    for (int i = 0; i < 26; i++) {
      children[i] = null;
    }
  }

  public void insert(String word) {
    Trie curr = this;
    for (char c : word.toCharArray()) {
      if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Trie();
      curr = curr.children[c - 'a'];
    }
    curr.endOfWord = true;
  }
}

class WordSearchII {
  private void dfs(char[][] board, Trie trie, Set<String> result, int i, int j, String s) {
    char c = board[i][j];
    if (c == '$') return;
    board[i][j] = '$';   // Use special character to avoid going in circles while recursing
    Trie t = trie.children[c - 'a'];
    if (t != null) {
      String ss = s + c;
      if (t.endOfWord == true) result.add(ss);
      if (i < board.length - 1) dfs(board, t, result, i+1, j, ss);
      if (j < board[0].length - 1) dfs(board, t, result, i, j+1, ss);
      if (i > 0) dfs(board, t, result, i-1, j, ss);
      if (j > 0) dfs(board, t, result, i, j-1, ss);
    }
    board[i][j] = c;   // Recovering changed character
  }

  public List<String> findWords(char[][] board, String[] words) {
    if (words.length == 0) return new ArrayList<>();
    // Fill up trie
    Trie trie = new Trie();
    for (String s : words) {
      trie.insert(s);
    }
    // Recursing through board while comparing to
    Set<String> result = new HashSet<>();  // Use HashSet to avoid repetitions of words
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, trie, result, i, j, "");
      }
    }
    return new ArrayList<>(result);
  }
}
