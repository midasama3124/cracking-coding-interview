package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
  public static int nthUglyNumber(int n) {
    if (n <= 0) return 0;
    List<Integer> uglyNums = new ArrayList<>();
    uglyNums.add(1);
    int i = 0;  // Counter multiples of 2
    int j = 0;  // Counter multiples of 3
    int k = 0;  // Counter multiples of 5
    while (uglyNums.size() < n) {
      int factorOf2 = uglyNums.get(i) * 2;
      int factorOf3 = uglyNums.get(j) * 3;
      int factorOf5 = uglyNums.get(k) * 5;
      int nth = Math.min(factorOf2,
          Math.min(factorOf3,
              factorOf5));
      uglyNums.add(nth);
      System.out.println(uglyNums.toString());
      if (nth == factorOf2) i++;
      if (nth == factorOf3) j++;
      if (nth == factorOf5) k++;
    }
    return uglyNums.get(n-1);
  }

  public static void main(String[] args) {
    int n = 10;
    System.out.println(nthUglyNumber(n));
  }
}
