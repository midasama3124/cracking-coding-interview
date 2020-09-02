package LeetCode;

import java.util.HashMap;

/** Inner class for node representation */
class TrieNode {
  char value;
  HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  boolean isWord;

  public TrieNode() {}

  public TrieNode(char value) {
    this.value = value;
  }
}

class PrefixTree {
  public TrieNode root;
  /** Initialize your data structure here. */
  public PrefixTree() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    HashMap<Character, TrieNode> children = root.children;
    for (int i=0; i < word.length(); i++) {
      char c = word.charAt(i);
      TrieNode t;
      if (children.containsKey(c)) t = children.get(c);
      else {
        t = new TrieNode(c);
        children.put(c, t);
      }
      children = t.children;
      // Flag of last TrieNode must be turned to true
      if (i == word.length()-1) t.isWord = true;
    }

  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode t = searchNode(word);
    if (t != null && t.isWord) return true;
    else return false;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    if (searchNode(prefix) != null) return true;
    else return false;
  }

  /** Looks for ending node given a string if any, otherwise returns null */
  private TrieNode searchNode(String str) {
    HashMap<Character, TrieNode> children = root.children;
    TrieNode t = null;
    for (int i=0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (children.containsKey(c)) {
        t = children.get(c);
        children = t.children;
      }
      else return null;
    }
    return t;
  }

  public static void main(String[] args) {
    String word = "apple";
    PrefixTree prefixTree = new PrefixTree();
    prefixTree.insert(word);
    System.out.println(prefixTree.startsWith("app"));
  }
}
