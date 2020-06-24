package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence {
  public static boolean isSubsequence(String s, String t) {
    // Time complexity: O(t), t: t string length
    // Time complexity: O(1)
        /*int sIndex = 0;
        for (char c : t.toCharArray()) {
            if (sIndex < s.length() && c == s.charAt(sIndex)) {
                sIndex++;
            }
        }
        return sIndex == s.length();*/
    // Follow up
    // Time complexity: O(s*log(t)), s,t: String lengths
    // Space complexity: O(t)
    // Pre-processing on T string
    Map<Character, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (!map.containsKey(c)) {
        map.put(c, new ArrayList<Integer>(i));
      }
      map.get(c).add(i);
    }
    // Iterate through s string and find out if t has a
    // current character whose index is greater than the previous one
    int prev = -1;   // Previous index
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!map.containsKey(c)) {
        return false;
      } else {
        List<Integer> list = map.get(c);
        prev = binarySearch(prev, list, 0, list.size()-1);
        if (prev == -1) return false;
        prev++;
      }
    }
    return true;
  }

  private static int binarySearch(int index, List<Integer> list, int start, int end) {
    while (start <= end) {
      int mid = start + (end-start)/2;
      if (index > list.get(mid)) start = mid + 1;
      else end = mid - 1;
    }
    return start == list.size() ? -1 : list.get(start);
  }

  public static void main(String[] args) {
    String s = "hlo";
    String t = "hello";
    System.out.println(isSubsequence(s, t));
  }
}
