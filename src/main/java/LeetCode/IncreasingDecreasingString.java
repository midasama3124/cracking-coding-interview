package LeetCode;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class IncreasingDecreasingString {
  public static String sortString(String s) {
    Map<Character, Integer> map = new TreeMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c,0) + 1);
    }
    boolean ascending = true;
    StringBuilder strBuilder = new StringBuilder();
    TreeSet<Character> ts;
    while (!map.isEmpty()) {
      ts = new TreeSet<Character>(map.keySet());
      if (!ascending) {
        ts = (TreeSet<Character>)ts.descendingSet();
      }
      for (Character c : ts) {
        strBuilder.append(c);
        map.put(c, map.get(c) - 1);
        if(map.get(c) == 0) map.remove(c);
      }
      ascending = !ascending;
    }
    return strBuilder.toString();
  }

  public static void main(String[] args) {
    String s = "aabbcc";
    System.out.println(sortString(s));
  }
}
