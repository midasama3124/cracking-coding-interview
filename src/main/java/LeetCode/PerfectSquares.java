package LeetCode;

public class PerfectSquares {
  public static int numSquares(int n) {
    int[] dp = new int[n+1];
    for (int i = 1; i <= n; i++) {
      int minValue = i;   // Take only ones
      int square = 1, j = 1;
      while (square <= i) {
        minValue = Math.min(minValue, 1 + dp[i-square]);
        j++;
        square = j*j;
      }
      dp[i] = minValue;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int n = 43;
    int res = numSquares(n);
    System.out.println(res);
  }
}
