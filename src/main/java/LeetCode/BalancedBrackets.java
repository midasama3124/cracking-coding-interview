package LeetCode;

import java.util.Stack;

public class BalancedBrackets {
  // Check if brackets are balanced by using a stack
  static boolean areBracketsBalanced(String string) {
    // Create empty stack
    Stack<Character> stack = new Stack<>();
    // Iterate through string
    for (int i = 0; i < string.length(); i++) {
      // If i is a starting bracket, then push it into stack
      if (string.charAt(i) == '{' || string.charAt(i) == '[' || string.charAt(i) == '(')
        stack.push(string.charAt(i));

      // If i is ending bracket, pop from stack and check if they are matching brackets
      if (string.charAt(i) == '}' || string.charAt(i) == ']' || string.charAt(i) == ')') {
        // If no starting bracket has been stacked, return false
        if (stack.isEmpty()) return false;
        // Compare ending bracket with lastly-stacked starting bracket (i.e. popped)
        else if (!areMatchingBrackets(stack.pop(), string.charAt(i))) return false;
      }
    }
    // If there is something left in stack, there is an unclosed bracket
    if (stack.isEmpty()) return true;   // Balanced string
    else return false;   // Unbalanced
  }

  // Return true if given characters are left and right brackets
  private static boolean areMatchingBrackets(char chr1, char chr2) {
    if (chr1 == '(' && chr2 == ')')
      return true;
    else if (chr1 == '{' && chr2 == '}')
      return true;
    else if (chr1 == '[' && chr2 == ']')
      return true;
    else
      return false;
  }

  public static void main(String[] args) {
    String test = "{aak}[{]aasssad}";
    boolean result = false;
    assert areBracketsBalanced(test) == result;
  }
}
