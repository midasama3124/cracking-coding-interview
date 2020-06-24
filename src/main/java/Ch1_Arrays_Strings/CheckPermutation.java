package Ch1_Arrays_Strings;

import java.util.HashMap;

public class CheckPermutation {
  static boolean isPermutation(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    HashMap<Character, Integer> freq1 = findFreq(str1);
    HashMap<Character, Integer> freq2 = findFreq(str2);
    return freq1.equals(freq2);
  }

  private static HashMap<Character, Integer> findFreq(String str) {
    HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
    for (int i=0; i < str.length(); i++) {
      char key = str.charAt(i);
      if(!freq.containsKey(key)) {
        freq.put(key, 1);
      } else {
        freq.replace(key, freq.get(key)+1);
      }
    }
    return freq;
  }

  public static void main(String[] args) {
    String str1 = "abc";
    String str2 = "bac";
    System.out.println(isPermutation(str1, str2));
  }
}
