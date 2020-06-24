package LeetCode;

public class EditDistance {
  public int minDistance(String word1, String word2) {
    int a = word1.length();
    int b = word2.length();
    if (a == 0 && b == 0) return 0;   // If both strings are empty
    // Initialize a dynamic programming table
    int[][] dp = new int[a+1][b+1];
    // Our key
    // -----------------------------------
    // |  replace   |        insert      |
    // |---------------------------------|
    // |  delete    |**current problem** |
    // -----------------------------------
    // Fill up first column and row, corresponding to insertion/deletion
    // operations to reach empty string
    for (int j = 1; j <= b; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= a; i++) {
      dp[i][0] = i;
    }
    // Update dynamic programming table as we tackle each sub-problem individually
    for (int i = 1; i <= a; i++) {
      for (int j = 1; j <= b; j++) {
        // If characters mismatch we opt for the least-costly previous operation
        // and add up one additional replacement operation
        if (word1.charAt(i-1) != word2.charAt(j-1)) {
          dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
          // Otherwise, we encounter a problem that requires the same amount of
          // operations the case without those two last characters, so we opt for
          // for the previous diagonal
        } else {
          dp[i][j] = dp[i-1][j-1];
        }
      }
    }
    // Return the result of final sub-problem, i.e. last characters of given strings
    return dp[a][b];
  }
}
