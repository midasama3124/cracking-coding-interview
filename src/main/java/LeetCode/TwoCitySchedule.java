package LeetCode;

import java.util.Arrays;

public class TwoCitySchedule {
  public int twoCitySchedCost(int[][] costs) {
    // Sort array based on difference between A cost and B cost in ascending order
    Arrays.sort(costs,
        (a,b) -> Integer.compare(a[0]-a[1], b[0]-b[1])
    );
    // Add first N candidates with A cost and last N candidates with B cost
    int nCandidates = costs.length;
    int minCost = 0;
    for (int i = 0; i < nCandidates; i++) {
      if (i < nCandidates/2) {
        minCost += costs[i][0];
      } else {
        minCost += costs[i][1];
      }
    }
    return minCost;
  }
}
