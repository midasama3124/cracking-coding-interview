package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a,b) -> freq.get(b) - freq.get(a)
        );
        for (int key : freq.keySet()) {
            maxHeap.add(key);
        }
        int i = 0;
        int[] res = new int[k];
        while (!maxHeap.isEmpty() && i < k) {
            res[i] = maxHeap.poll();
            i++;
        }
        return res;
    }
}
