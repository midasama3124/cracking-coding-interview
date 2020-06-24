package LeetCode;

import java.util.PriorityQueue;

public class KClosestsPointsOrigin {
  public int[][] kClosest(int[][] points, int K) {
    // Create MaxHeap by using a PriorityQueue with an appropriate constructor
    // We can compare square distances so we can avoid computing the square root
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
    );
    // Add all points while ensuring that MaxHeap size is less or equal to K
    for (int[] p : points) {
      maxHeap.add(p);
      if (maxHeap.size() > K) {
        maxHeap.remove();
      }
    }
    // Reconstruct result from MaxHeap
    int[][] result = new int[K][2];
    while (K-- > 0) {
      result[K] = maxHeap.remove();
    }
    return result;
  }
}
