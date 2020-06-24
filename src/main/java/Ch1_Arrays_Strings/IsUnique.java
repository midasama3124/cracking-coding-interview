package Ch1_Arrays_Strings;

import java.util.Arrays;

public class IsUnique {
  // My solution
  /*static boolean isUnique(String str) {
    for (int i=0; i < str.length(); i++) {
      for (int j=i+1; j < str.length(); j++) {
        if (str.charAt(i) == str.charAt(j)) {
          return false;
        }
      }
    }
    return true;
  } // end method isUnique() */

  // Using additional structure (Time complexity: O(n))
  static boolean isUniqueWith(String str) {
    if (str.length() > 256) return false;   // no possible to build unique string with more characters
    boolean[] char_set = new boolean[256];
    for (int i=0; i < str.length(); i++) {
      int character = str.charAt(i);
      if (!char_set[character]) char_set[character] = true;   // Update if found once
      else return false;      // If found twice
    }
    return true;
  }

  // Without using additional structure (Time complexity: O(n*log(n)))
  static boolean isUniqueWithout(String str) {
    char[] tempArray = str.toCharArray();
    Arrays.sort(tempArray);
    for (int i=0; i<str.length()-1; i++) {
      if (tempArray[i] == tempArray[i+1]) {    // Look for consecutive identical elements
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String test = "abcgdkslwo";
    System.out.println(isUniqueWith(test));
    System.out.println(isUniqueWithout(test));
  }
}
