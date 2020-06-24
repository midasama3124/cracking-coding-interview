package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
  public static List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums.length <= 1) {
      for (int i : nums) {
        result.add(i);
      }
      return result;
    }
    // Runtime O(n^2)
    // Space O(n)
    // Sort input array in ascending order
    Arrays.sort(nums);
    // Save into current ArrayList if divisible has been found
    int[][] divisible = new int[nums.length][2];
    for (int i = nums.length-1; i >= 0; i--) {
      divisible[i][0] = -1;
      divisible[i][1] = 1;
      int max = 0;
      for (int j = i+1; j < nums.length; j++) {
        if (nums[j] % nums[i] == 0 && divisible[j][1] > max) {
          divisible[i][0] = j;
          max = divisible[j][1];
          divisible[i][1] = max + 1;
        }
      }
    }
    // Find index with maximum size
    int max_size = 0;
    int max_index = -1;
    for (int i = 0; i < divisible.length; i++) {
      if (divisible[i][1] > max_size) {
        max_size = divisible[i][1];
        max_index = i;
      }
    }
    // Reconstruct resulting list by iterating through divisible starting
    // from max. index previously found

    int i = max_index;
    while (divisible[i][0] != -1) {
      result.add(nums[i]);
      i = divisible[i][0];
    }
    result.add(nums[i]);
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    List<Integer> result = largestDivisibleSubset(nums);
    System.out.println(result.toString());
  }
}
