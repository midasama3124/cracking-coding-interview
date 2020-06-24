package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeopleGivenGroupSize {
  public static List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> groups = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < groupSizes.length; i++) {
      int size = groupSizes[i];
      if (!map.containsKey(size) || map.containsKey(size) && groups.get(map.get(size)).size() == size) {
        groups.add(new ArrayList<>());
        map.put(size, groups.size()-1);
      }
      groups.get(map.get(size)).add(i);
    }
    return groups;
  }

  public static void main(String[] args) {
    int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
    List<List<Integer>> groups = groupThePeople(groupSizes);
    System.out.println(groups.toString());
  }
}
