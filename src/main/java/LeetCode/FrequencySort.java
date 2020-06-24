package LeetCode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {
  public String frequencySort(String s) {
    if (s.length() == 0) return new String();
    // Use HashMap to store character frequency
    HashMap<Character, Integer> freq = new HashMap();
    for (int i = 0; i < s.length(); i++) {
      freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
    }
    // Sort HashMap by values in descending order and save into LinkedHashMap
        /*Map<Character, Integer> sorted = freq
            .entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                    LinkedHashMap::new));*/
    // Or rather build a MaxHeap and throw all elements in HashMap to it
    PriorityQueue<Character> maxHeap = new PriorityQueue<>(
        (a,b) -> freq.get(b) - freq.get(a));   // Contructor with comparator
    maxHeap.addAll(freq.keySet());
    // Reconstruct string using sorted HashMap
    StringBuilder newString = new StringBuilder();
    // With LinkedHashMap
        /*for (Map.Entry<Character, Integer> entry : sorted.entrySet()) {
            int count = entry.getValue();
            while (count-- > 0) newString.append(entry.getKey());
        }*/
    // With MaxHeap
    while (!maxHeap.isEmpty()) {
      char current = maxHeap.remove();
      for (int i = 0; i < freq.get(current); i++)
        newString.append(current);
    }
    return newString.toString();
  }
}
