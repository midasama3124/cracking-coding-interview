package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
  static class Solution {

    private List<Integer> prices;
    private Stack<Integer> stack;

    public Solution() {
      prices = new ArrayList();
      stack = new Stack();
    }

    // O(n^2) time complexity
    /*public int next(int price) {
      int count = 1;
      for (int i=prices.size()-1; i >= 0; i--) {
        if (prices.get(i) > price) break;
        count++;
      }
      prices.add(price);
      return count;
    }*/

    // O(n) time complexity
    // O(n) space complexity
    public int next (int price) {
      // First price
      if (prices.isEmpty()) {
        prices.add(price);
        stack.push(0);
        return 1;
      }
      // Saving price indexes in descending order
      int span;
      int price_index = prices.size();
      // Pop stack head until a greater value is found
      while (!stack.isEmpty() && prices.get(stack.peek()) <= price) stack.pop();
      if (stack.isEmpty()) span = price_index+1;
      else span = price_index - stack.peek();
      // Update prices ListArray and span Stack
      stack.push(price_index);
      prices.add(price);
      return span;
    }
  }

  public static void main(String[] args) {
    Solution spanner = new Solution();
    System.out.println((spanner.next(31)));
    System.out.println((spanner.next(41)));
    System.out.println((spanner.next(48)));
    System.out.println((spanner.next(59)));
    System.out.println((spanner.next(79)));
  }
}
