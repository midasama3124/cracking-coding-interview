package LeetCode;

public class FindDuplicateNumber {
  public int findDuplicate(int[] nums) {
    int n = nums.length;
    int currMax = 0;
    int maxIndex = 0;
    for (int i = 0; i < n; i++) {
      int index = nums[i] % n;
      nums[index] += n;
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] > currMax) {
        currMax = nums[i];
        maxIndex = i;
      }
      nums[i] %= n;
    }
    return maxIndex;
  }
}
