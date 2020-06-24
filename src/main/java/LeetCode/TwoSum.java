package LeetCode;

public class TwoSum {
  static int[] findIndeces(int[] nums, int target) {
    int diff, index2, index3;
    for (int index1=0; index1 < nums.length; index1++) {
      diff = target - nums[index1];
      index2 = lastIndexOf(nums, diff);
      if (index2 != -1 && index2 != index1) {
        return new int[]{index1, index2};
      }
    }
    return new int[]{0, 0};
  }

  private static int lastIndexOf(int[] nums, int value) {
    for (int i=nums.length-1; i >= 0; i--) {
      if (nums[i] == value) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {3,2,4};
    int target = 6;
    int[] indeces = findIndeces(nums, target);
    for (int tmp : indeces) {
      System.out.print(tmp + " ");
    }
  }
}
