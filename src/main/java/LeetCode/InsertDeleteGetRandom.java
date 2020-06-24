package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class InsertDeleteGetRandom {
  public static void main(String[] args) {
    RandomizedSet obj = new RandomizedSet();
    int val2 = 2;
    boolean param_1 = obj.insert(1);
    obj.insert(2);
    obj.insert(3);
    obj.insert(4);
    obj.insert(5);
    obj.insert(6);
    obj.insert(7);
    boolean param_2 = obj.remove(val2);
    int param_3 = obj.getRandom();
    System.out.println(param_1);
    System.out.println(param_2);
    System.out.println(param_3);
  }
}

class RandomizedSet {

  List<Integer> dataStr;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    dataStr = new ArrayList<>();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (dataStr.contains(val)) return false;
    dataStr.add(val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    int index = dataStr.indexOf(val);
    if (index == -1) return false;
    dataStr.remove(index);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int rand = (int)((dataStr.size()-1)*Math.random());
//    System.out.println(rand);
    return dataStr.get(rand);
  }
}