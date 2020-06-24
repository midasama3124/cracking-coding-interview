package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsKStops {
  int minCost;

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    // Build and fill adjacency matrix to represent ticket prices
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] f : flights) {
      graph.putIfAbsent(f[0], new ArrayList<>());
      graph.get(f[0]).add(new int[] {f[1], f[2]});
    }
    minCost = Integer.MAX_VALUE;
    // Conduct BFS on given graph
    Queue<int[]> q = new LinkedList<>();
    int stops = 0;
    q.add(new int[] {src, 0});
    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        int[] currentStop = q.poll();
        if(currentStop[0] == dst) {
          minCost = Math.min(minCost, currentStop[1]);
        }
        if(!graph.containsKey(currentStop[0])) {
          continue;
        }
        for(int[] f : graph.get(currentStop[0])) {
          if(currentStop[1] + f[1] > minCost)
            continue; // prunning
          q.add(new int[] {f[0], f[1] + currentStop[1]});
        }
      }
      if(stops++ > K)
        break;
    }
    // Conduct DFS on given graph
        /*int currentCost = 0;
        dfs(graph, src, dst, K+1, currentCost);*/
    return minCost == Integer.MAX_VALUE ? -1 : minCost;
  }

  private void dfs(Map<Integer, List<int[]>> graph, int src, int dst, int k, int currCost) {
    // Base cases
    if (k < 0) return;  // If stop threshold has been underpassed and destination has not been found yet
    if (src == dst) {   // Destination has been found
      minCost = currCost;
      return;
    }
    if (!graph.containsKey(src)) return;
    for (int[] f : graph.get(src)) {
      if (currCost + f[1] > minCost) continue;  // Discard this path
      dfs(graph, f[0], dst, k - 1, currCost + f[1]);
    }
  }
}
