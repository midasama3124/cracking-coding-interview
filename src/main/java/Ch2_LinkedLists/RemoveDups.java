package Ch2_LinkedLists;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class RemoveDups {
  // Remove duplicates from a given LinkedList by using a frequency counter (HashMap)
  // and then removing each repeated Object as much times as needed.
  static LinkedList<Object> removeDups(LinkedList<Object> linkedList) {
    // Counting object frequency in LinkedList
    HashMap<Object, Integer> freq = new HashMap<>();
    linkedList.forEach((node) -> {
      if (!freq.containsKey(node)) {
        freq.put(node, 1);
      } else {
        freq.replace(node, freq.get(node)+1);
      }
    });

    // Removing dups based on the frequency counter used as buffer
    for (Object key : freq.keySet()) {
      int value = (int)freq.get(key);
      for (int i = 0; i < value - 1; i++) {
        linkedList.remove(key);
      }

    }

    return linkedList;
  }

  public static void main(String[] args) {
    LinkedList<Object> integers = new LinkedList<>();

    integers.add(1);
    integers.add(1);
    integers.add(2);
    integers.add(2);
    integers.add(1);

    integers = removeDups(integers);
    Iterator<Object> iter = integers.iterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }
}
