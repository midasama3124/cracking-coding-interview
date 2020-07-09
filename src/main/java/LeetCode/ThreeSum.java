package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
//  public static List<List<Integer>> threeSum(int[] nums) {
//    List<List<Integer>> triplets = new ArrayList();
//    // Casting integer array to list
//    ArrayList<Integer> numsList = IntStream.of(nums)
//        .boxed().collect(Collectors.toCollection(ArrayList::new));
//    // Sorting integer array
//    Collections.sort(numsList);
//    // Iterating through integer array
//    for (int i=0; i < numsList.size(); i++) {
//      // Create sublist leaving out corresponding item
//      List<Integer> numsSublist = numsList.subList(i+1, numsList.size());
//      // Find 2sum for each array element
//      List<List<Integer>> twoSum = twoSum(numsSublist, -numsList.get(i));
//      // Add triplet if sum adds up to zero
//      if (twoSum.isEmpty()) continue;
//      for (List<Integer> dup : twoSum) {
//        List<Integer> tmpTriplet = Arrays.asList(numsList.get(i), dup.get(0), dup.get(1));
//        Collections.sort(tmpTriplet);
//        int sum = tmpTriplet.stream().mapToInt(Integer::intValue).sum();
//        if (sum == 0 && !triplets.contains(tmpTriplet)) triplets.add(tmpTriplet);
//      }
//    }
//    return triplets;
//  }

//  private static List<List<Integer>> twoSum(List<Integer> numsList, int target) {
//    int index2, diff;
//    List<List<Integer>> dups = new ArrayList();
//    for (int index1=0; index1 < numsList.size(); index1++) {
//      diff = target - numsList.get(index1);    // Difference to reach target
//      index2 = numsList.lastIndexOf(diff);
//      // Updating array if list contains difference
//      if (index2 != -1 && index1 != index2) {
//        ArrayList<Integer> dup = new ArrayList<>();
//        dup.add(numsList.get(index1));
//        dup.add(numsList.get(index2));
//        Collections.sort(dup);
//        if (!dups.contains(dup)) dups.add(dup);
//      }
//    }
//    return dups;
//  }

  // Optimal solution
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums.length < 3) return res;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length-2; i++) {
      if (i == 0 || nums[i] != nums[i-1]) {
        int l = i + 1;
        int r = nums.length - 1;
        while (l < r) {
          int sum = nums[i] + nums[l] + nums[r];
          if (sum == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[l]);
            list.add(nums[r]);
            res.add(list);
            while(l < r && nums[l] == nums[l+1]) l++;
            while(l < r && nums[r] == nums[r-1]) r--;
            l++;
            r--;
          }
          else if (sum > 0) r--;
          else l++;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
    List<List<Integer>> triplets = threeSum(nums);
    for (List<Integer> trip : triplets) {
      trip.forEach((elem) -> System.out.print(elem + " "));
      System.out.println();
    }
  }
}
