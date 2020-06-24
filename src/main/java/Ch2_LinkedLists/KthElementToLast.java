package Ch2_LinkedLists;

import java.util.Iterator;
import java.util.LinkedList;

public class KthElementToLast {
  // Knowing the LinkedList size
  /*static int findKthElementToLast(LinkedList<Integer> linkedList, int k) {
    int count = 0;   // LinkedList index
    int nodeValue = 0;
    for (Object node : linkedList) {
      if (count == linkedList.size()-k) {
        nodeValue = (int)node;
      }
      count++;
    }
    return nodeValue;
  }*/

  // Not knowing the LinkedList size by using two pointers
  static int findKthElementToLast(LinkedList<Integer> linkedList, int k) {
    Iterator p1 = linkedList.iterator();
    Iterator p2 = linkedList.iterator();
    for (int i=0; i < k; i++) {
      p1.next();
    }
    while (p1.hasNext()) {
      p1.next();
      p2.next();
    }
    return (int)p2.next();
  }

  public static void main(String[] args) {
    LinkedList<Integer> nums = new LinkedList<Integer>();
    nums.add(1);
    nums.add(2);
    nums.add(8);
    nums.add(3);
    nums.add(7);
    nums.add(0);
    nums.add(4);
    nums.add(1);
    nums.add(2);
    nums.add(3);
    nums.add(4);
    int k = 3;
    int kthElem = findKthElementToLast(nums, k);
    System.out.println(kthElem);

  }
}
