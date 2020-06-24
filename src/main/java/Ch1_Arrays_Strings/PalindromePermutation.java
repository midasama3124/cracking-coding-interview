package Ch1_Arrays_Strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
  static boolean isPalindromePermutation(String str) {
    // Computing string length without blank spaces
    int strLen = 0;
    for (char c : str.toCharArray()) {
      if (c != ' ') strLen++;     // Count up only if not blank space
    }
    // Checking character frequency
    HashMap<Character, Integer> freq = computeFreq(str);
    int cont = 0;  // Counter of single letters
    for (Map.Entry mapElem : freq.entrySet()) {
      int value = (int) mapElem.getValue();
      if (cont > 1 && value%2 != 0) return false;
      if (value%2 != 0 && strLen%2 != 0) {
        System.out.println("cont: " + cont);
      }
    }
    return true;
  }

  private static HashMap<Character, Integer> computeFreq(String str) {
    HashMap<Character, Integer> freq = new HashMap<>();
    for (char c : str.toLowerCase().toCharArray()) {
      if (c != ' ') {  // Leaving out blank spaces
        if (!freq.containsKey(c))
          freq.put(c, 1);
        else
          freq.replace(c, freq.get(c) + 1);
      }
    }
    return freq;
  }

  public static void main(String[] args) {
    String test = "Adchhsh";
    System.out.println(isPalindromePermutation(test));
  }
}
