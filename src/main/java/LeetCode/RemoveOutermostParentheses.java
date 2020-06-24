package LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveOutermostParentheses {
  public static String removeOuterParentheses(String S) {
    Stack<Integer> s = new Stack<>();
    Set<Integer> indexes = new HashSet<>();
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (c == '(') s.push(i);
      else if (!s.isEmpty() && c == ')') {
        int index = s.pop();
        if (s.isEmpty()) {
          indexes.add(index);
          indexes.add(i);
        }
      }
    }
    StringBuilder strBld = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      if (!indexes.contains(i)) strBld.append(S.charAt(i));
    }
    return strBld.toString();
  }

  public static void main(String[] args) {
    String test = "(())()";
    String res = removeOuterParentheses(test);
    System.out.println(res);
  }
}
