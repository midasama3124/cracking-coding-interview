package LeetCode;

public class CountingBits {
  public int[] countBits(int num) {
    // Memo array and base cases
    int[] memo = new int[num+1];
    // Recurse til num updating memo with given conditions
    // based on whether the current num is even or odd
    for (int i = 1; i <= num; i++) {
      if (i%2 == 0) {  // If number is even...
        memo[i] = memo[i/2];
      } else {   // If number is odd...
        memo[i] = memo[i/2] + 1;
      }
    }
    return memo;
  }
}
