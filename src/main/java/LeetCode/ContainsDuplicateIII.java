package LeetCode;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            // Maximum value which is less than current value in array
            Long floor = set.floor((long) nums[i]);
            if (floor != null && nums[i] - floor <= t) return true;
            // Minimum value which is greater than current value in array
            Long ceiling = set.ceiling((long) nums[i]);
            if (ceiling != null && ceiling - nums[i] <= t) return true;
            // Add value to set
            set.add((long) nums[i]);
            // Remove value if k is exceeded
            if (set.size() > k) set.remove((long) nums[i - k]);
        }
        return false;
    }
}
