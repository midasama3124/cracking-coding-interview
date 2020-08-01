package LeetCode;

import java.util.*;

public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0));
        while(!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int lastNode = path.get(path.size() - 1);
            if (lastNode == target) {
                res.add(path);
            } else {
                for (int adj : graph[lastNode]) {
                    List<Integer> list = new ArrayList<>(path);
                    list.add(adj);
                    queue.add(list);
                }
            }
        }
        return res;
    }
}
