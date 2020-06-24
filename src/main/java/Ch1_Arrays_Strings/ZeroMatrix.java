package Ch1_Arrays_Strings;

public class ZeroMatrix {

  static int[][] getZeroMatrix(int[][] matrix) {
    // Input validation
    int m = matrix.length;   // N. rows
    int n = matrix[0].length;      // N. columns
    if (n == 0 || m == 0) return matrix;

    // Zero helpers
    boolean[] row = new boolean[m];
    boolean[] column = new boolean[n];

    // Search and update boolean arrays
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          row[i] = true;
          column[j] = true;
        }
      }
    }

    // Fill up original matrix with corresponding zeros
    for (int i=0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] != 0 & row[i] || column[j]) {
          matrix[i][j] = 0;
        }
      }
    }

    return  matrix;
  }

  public static void main(String[] args) {
    int [][] test = {{1,0,1,1}, {2,2,0,1}, {5,6,4,2}};
    int [][] zeroMat = getZeroMatrix(test);
    for (int i = 0; i < zeroMat.length; i++) {
      for (int j = 0; j < zeroMat[0].length; j++) {
        System.out.print(zeroMat[i][j] + " ");
      }
      System.out.println();
    }
  }

}
