package LeetCode;

import java.util.Stack;

public class RemoveKDigits {
  /*public static String removeKdigits(String num, int k) {
    int tmp;   // Temp value from substring to compare with local minimum
    int index; // Index of local minimum
    int min;   // Minimum value
    for (int i=0; i < k; i++) {
      min = Integer.parseInt(num.substring(0,1));
      index = 0;
      for (int j=0; j < num.length(); j++) {
        tmp = Integer.parseInt(num.substring(0,j) + num.substring(j+1, num.length()));
        if (tmp < min) {
          min = tmp;
          index = j;
          System.out.println("Found! " + tmp);
        }
      }
      num = num.replaceFirst(num.substring(index, index+1), "");
    }
    return num;
  }*/

  // Remove k digits so that least number is left afterwards
  // by using greedy algorithm, i.e. use a stack to save locally-optimal integer
  // and a StringBuilder to handle resulting String
  public static String removeKdigits(String num, int k) {
    int size = num.length();
    // Base condition
    if (k == size) return "0";
    // Greedy algorithm
    Stack<Character> stack = new Stack();
    for (int i=0; i < size; i++) {
      while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
        stack.pop();
        k--;
      }
      stack.push(num.charAt(i));
    }
    // Remove remaining k elements if any
    while (k > 0) {
      stack.pop();
      k--;
    }
    // Create string builder, reverse it and remove zeros on the left
    StringBuilder stringBuilder = new StringBuilder();
    while (!stack.isEmpty()) {
      stringBuilder.append(stack.pop());
    }
    stringBuilder.reverse();  // Reverse stack elements
    // Remove zeros on the left side of string
    while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
      stringBuilder.deleteCharAt(0);
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    String test = "1432219";
    int k = 3;
    System.out.println(removeKdigits(test, k));
  }
}
