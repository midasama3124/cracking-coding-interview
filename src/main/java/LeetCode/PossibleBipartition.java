package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PossibleBipartition {
  public boolean possibleBipartition(int N, int[][] dislikes) {
    // Graph connecting all people with their corresponding dislikes
    HashMap<Integer, Set<Integer>> graph = new HashMap<>();
    // Fill up the graph
    for (int[] dislike : dislikes) {
      int a = dislike[0];
      int b = dislike[1];
      graph.putIfAbsent(a, new HashSet<>());
      graph.putIfAbsent(b, new HashSet<>());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    // Check if graph is bipartite (each edge has the opposite color
    // of adjacent nodes)
    int[] colors = new int[N+1];   // Colors: 1 and -1
    for (int i = 0; i < N; i++) {
      if (colors[i] == 0 && !dfs(colors, i, 1, graph))
        return false;
    }
    return true;
  }

  // Depth-first search
  private boolean dfs(int[] colors, int node, int color, HashMap<Integer, Set<Integer>> graph) {
    if (colors[node] != 0) return colors[node] == color;  // Base case
    colors[node] = color;    // Otherwise, color it
    if (graph.get(node) == null) return true;     // If no more adjacent nodes to check
    // Otherwise, keep searching for the opposite color in adjacent nodes
    for (int adjacentNode : graph.get(node)) {
      if (!dfs(colors, adjacentNode, -color, graph))
        return false;
    }
    return true;
  }
}
