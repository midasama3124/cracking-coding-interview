package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRowsMatrix {
  public static int[] kWeakestRows(int[][] mat, int k) {
    int numRows = mat.length;
    int[] numSoldiers = new int[numRows];
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 1) numSoldiers[i]++;
        else break;
      }
    }
    PriorityQueue<Integer> weakest = new PriorityQueue<>(
        (a,b) -> numSoldiers[a] == numSoldiers[b] ? a - b : numSoldiers[a] - numSoldiers[b]
    );
    // Fill up min heap
    for (int i = 0; i < numRows; i++) {
      weakest.add(i);
    }
    int[] res = new int[k];
    int i = 0;
    while (k-- > 0) {
      res[i++] = weakest.poll();
    }
    return res;
  }

  public static void main(String[] args) {
    int[][] mat = {{1, 1, 0, 0, 0},
        {1, 1, 1, 1, 0},
        {1, 0, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {1, 1, 1, 1, 1}};
    int k = 3;
    int[] weakest = kWeakestRows(mat, k);
    System.out.println(Arrays.toString(weakest));
  }
}
