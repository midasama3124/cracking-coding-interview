package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int lastIncluded = 0, count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[lastIncluded][1] > intervals[i][0]) {    // Overlap
                count++;
                if (intervals[i][1] < intervals[lastIncluded][1]) lastIncluded = i;
            } else
                lastIncluded = i;
        }
        return count;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 2},{2, 3},{3, 4},{1, 3}};
        int[][] intervals = {{1, 2},{1, 2},{1, 2},{1, 2}};
        int res = eraseOverlapIntervals(intervals);
        System.out.println(res);
    }
}
