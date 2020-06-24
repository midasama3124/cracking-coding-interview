package LeetCode;

import java.util.HashMap;

public class ContiguousArray {
  public int findMaxLength(int[] nums) {
    int maxLength = 0;
    int count = 0;       // Counter
    // HashMap of counter->first found index
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    hashMap.put(0,-1);   // We have not found any element
    // Iterate through binary array updating the HashMap accordingly
    for (int i = 0; i < nums.length; i++) {
      // By handling the counter in this way, indeces with same count will
      // represent a contiguous subarray, as the counter balances itself
      // when there is an equal number of ones and zeros
      count += nums[i] == 0 ? -1 : 1;
      if (hashMap.containsKey(count)) {
        // Update max. length if another index has already been found
        maxLength = Math.max(maxLength, i-hashMap.get(count));
      } else {
        // Only save the first found index with the given counter
        hashMap.put(count, i);
      }
    }
    return maxLength;
  }
}
