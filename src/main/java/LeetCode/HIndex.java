package LeetCode;

import java.util.*;

public class HIndex {
    public static int hIndex(int[] citations) {
        // O(n*log(n))
//        Arrays.sort(citations);
//        int res = 0;
//        for (int i = 0; i < citations.length; i++) {
//            if (citations[i] >= citations.length - i) {
//                res = Math.max(res, citations.length - i);
//            }
//        }
//        return res;
        // O(n) Runtime
        // O(n) Space
        int len = citations.length;
        int[] count = new int[len+1];
        for (int n : citations) {
            if (n <= len) count[n]++;
            else count[len]++;
        }
        int prev = 0;
        for (int idx = len; idx >= 0; idx--) {
            if (count[idx] + prev >= idx) return idx;
            prev += count[idx];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
//        int[] citations = {100};
        int res = hIndex(citations);
        System.out.println(res);
    }
}
