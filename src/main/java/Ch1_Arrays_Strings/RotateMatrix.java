package Ch1_Arrays_Strings;

public class RotateMatrix {

  // Returns input matrix if it is not NxN
  static int[][] rotateMatrix(int[][] matrix) {
    // Input validation
    if (matrix.length == 0 || matrix[0].length != matrix.length) return matrix;
    int n = matrix.length;
    int[][] rotated = new int[n][n];
    for (int i=0; i < n; i++) {
      for (int j=0; j < n; j++) {
       rotated[j][n-1-i] = matrix[i][j];
      }
    }
    return rotated;
  }

  public static void main(String[] args) {
    int[][] test = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    int[][] rotatedTest = rotateMatrix(test);
    for (int[] array : rotatedTest) {
      for (int elem : array) {
        System.out.print(elem + " ");
      }
      System.out.println();
    }
  }

}
