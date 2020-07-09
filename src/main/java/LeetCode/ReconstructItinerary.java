package LeetCode;

import java.util.*;

public class ReconstructItinerary {
  private static Map<String, PriorityQueue<String>> map = new HashMap<>();
  private static List<String> paths = new LinkedList<>();
  public static List<String> findItinerary(List<List<String>> tickets) {
    // Map given tickets
    for (List<String> ticket : tickets) {
      String dep = ticket.get(0);
      String arr = ticket.get(1);
      if (!map.containsKey(dep)) {
        map.put(dep, new PriorityQueue<>());
      }
      map.get(dep).add(arr);
    }
    System.out.println(map.toString());
    dfs("JFK");
    return paths;
  }

  public static void dfs(String stop) {
    while (map.containsKey(stop) && !map.get(stop).isEmpty()) {
      dfs(map.get(stop).poll());
    }
    paths.add(0, stop);
  }

  public static void main(String[] args) {
    List<List<String>> tickets = new ArrayList<>();
    // Test case # 1
//    List<String> ticket1 = new ArrayList<>();
//    ticket1.add("JFK");
//    ticket1.add("SFO");
//    tickets.add(ticket1);
//    List<String> ticket2 = new ArrayList<>();
//    ticket2.add("JFK");
//    ticket2.add("ATL");
//    tickets.add(ticket2);
//    List<String> ticket3 = new ArrayList<>();
//    ticket3.add("SFO");
//    ticket3.add("ATL");
//    tickets.add(ticket3);
//    List<String> ticket4 = new ArrayList<>();
//    ticket4.add("ATL");
//    ticket4.add("JFK");
//    tickets.add(ticket4);
//    List<String> ticket5 = new ArrayList<>();
//    ticket5.add("ATL");
//    ticket5.add("SFO");
//    tickets.add(ticket5);
    // Test case # 2
    List<String> ticket1 = new ArrayList<>();
    ticket1.add("JFK");
    ticket1.add("KUL");
    tickets.add(ticket1);
    List<String> ticket2 = new ArrayList<>();
    ticket2.add("JFK");
    ticket2.add("NRT");
    tickets.add(ticket2);
    List<String> ticket3 = new ArrayList<>();
    ticket3.add("NRT");
    ticket3.add("JFK");
    tickets.add(ticket3);
    List<String> itinerary = findItinerary(tickets);
    System.out.println(itinerary.toString());
  }
}
