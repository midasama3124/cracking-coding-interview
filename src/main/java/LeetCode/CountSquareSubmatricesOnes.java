package LeetCode;

public class CountSquareSubmatricesOnes {
  public static int countSquares(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return 0;
    // Solution (O(n^3))
        /*// Maximum side length for square submatrices
        int n = 0;
        n = Math.min(matrix.length, matrix[0].length);
        int count = 0;
        while (n > 0) {
            for (int i = 0; i <= matrix.length-n; i++) {
                for (int j = 0; j <= matrix[0].length-n; j++) {
                    int sum = 0;
                    for (int k = i; k < i+n; k++) {
                        for (int l = j; l < j+n; l++) {
                            sum += matrix[k][l];
                        }
                    }
                    if (sum == n*n) count++;
                }
            }
            n--;
        }*/
    // Solution (O(m*n))
    int m = matrix.length;   // n. rows
    int n = matrix[0].length;   // n. columns
    int[][] aux = new int[m][n];  // Auxiliary matrix
    // Sum of elements of auxiliary matrix is the solution
    // First row and first column remain the same
    int count = 0;
    for (int j = 0; j < n; j++) {
      aux[0][j] = matrix[0][j];
      count += aux[0][j];
    }
    for (int i = 1; i < m; i++) {
      aux[i][0] = matrix[i][0];
      count += aux[i][0];
    }
    // Iterate trough remaining submatrix and fill auxiliary matrix
    // with the result of min(prev. row, prev. column, prev. diagonal) + 1
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 1) {
          aux[i][j] = Math.min(aux[i - 1][j], Math.min(aux[i][j - 1], aux[i - 1][j - 1])) + 1;
          count += aux[i][j];
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println(countSquares(matrix));
  }
}
