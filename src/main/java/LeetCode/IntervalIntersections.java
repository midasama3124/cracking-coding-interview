package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersections {
  public static int[][] intervalIntersection(int[][] A, int[][] B) {
    int len1 = A.length;
    int len2 = B.length;
    if (len1 == 0 || len2 == 0) return new int[][] {};
    int i = 0, j = 0;      // Pointers
    List<int[]> intersect = new ArrayList<>();
    while (i < len1 && j < len2) {
      // Build potential intersection
      int starting = Math.max(A[i][0], B[j][0]);
      int ending = Math.min(A[i][1], B[j][1]);
      // Only append it to list if it makes sense
      if (starting <= ending)
        intersect.add(new int[] {starting, ending});
      // Update pointers
      if (A[i][1] < B[j][1]) i++;
      else if (B[j][1] < A[i][1]) j++;
      else {
        i++;
        j++;
      }
    }
    // Convert list to array
    int[][] intersectArray = new int [intersect.size()][];
    intersect.toArray(intersectArray);
    return intersectArray;
  }

  public static void main(String[] args) {
    int[][] A = {{0,2}, {5, 10}, {13, 23}, {24, 25}};
    int[][] B = {{1,5}, {8, 12}, {15, 24}, {25, 26}};
    int[][] output = intervalIntersection(A, B);
    for (int i = 0; i < output.length; i++) {
      System.out.println(String.format("%s, %s", output[i][0], output[i][1]));
    }
  }
}
