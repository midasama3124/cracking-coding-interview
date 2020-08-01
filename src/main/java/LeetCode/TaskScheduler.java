package LeetCode;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(map.values());
        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }
            for (int i : temp) {
                if (--i > 0) maxHeap.add(i);
            }
            cycles += maxHeap.isEmpty() ? temp.size() : n + 1;
        }
        return cycles;
    }
}
