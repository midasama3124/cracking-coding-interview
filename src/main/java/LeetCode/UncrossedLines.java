package LeetCode;

public class UncrossedLines {
  public int maxUncrossedLines(int[] A, int[] B) {
    // Memo matrix
    int[][] matrix = new int[A.length+1][B.length+1];
    // Update matrix as you recurse both input arrays in O(m*n)
    // First row and first column
    for (int i = 1; i <= A.length; i++) {
      for (int j = 1; j <= B.length; j++) {
        // If match, prev. diagonal + 1
        if (A[i-1] == B[j-1]) {
          matrix[i][j] = matrix[i-1][j-1] + 1;
        } else {
          // Else, max(prev.row, prev.column)
          matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
        }
      }
    }
    return matrix[A.length][B.length];
  }
}
