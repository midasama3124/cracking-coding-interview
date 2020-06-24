package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
  public static List<Integer> findAnagrams(String s, String p) {
    // Base case
    if (p.length() > s.length()) return new ArrayList();
    // Finding p's character frequency
    int[] pFreq = findCharFreq(p);
    // Going through s and matching anagrams
    List<Integer> indeces = new ArrayList<Integer>();
    int anagramSize = p.length();
    for (int i = 0; i < s.length()-anagramSize+1; i++) {
      int[] freq = pFreq.clone();
      if (areAnagrams(freq, s.substring(i, i+anagramSize)))
        indeces.add(i);
    }
    return indeces;
  }

  // Finds character frequency for strings with only lowercase letters
  public static int[] findCharFreq(String str) {
    int[] freq = new int[26];
    int letter;
    for (int i=0; i < str.length(); i++) {
      letter = (int)(str.charAt(i) - 'a');
      freq[letter]++;
    }
    return freq;
  }

  // Check if given strings are anagrams
  // str1Freq: Character frequency of first string
  // str2: Second string
  public static boolean areAnagrams(int[] str1Freq, String str2) {
    // Going through second string while comparing frequency with that of first string
    int letter;
    for (int j=0; j < str2.length(); j++) {
      letter = (int)(str2.charAt(j) - 'a');
      str1Freq[letter]--;
      if (str1Freq[letter] < 0) return false;
    }
    return true;
  }

  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;   // Base case
    // Counting character frequency of first string
    int[] freqStr1 = new int[26];
    for (char c : s1.toCharArray()) {
      freqStr1[c-'a']++;
    }
    // Comparing substring of string 2 with found frequency
    int permSize = s1.length();  // Permutation size
    int right = 0, left = 0;       // Boundary pointers
    int count = s1.length();     // Character counter
    while (right < s2.length()) {
      if (freqStr1[s2.charAt(right++)-'a']-- >= 1) count--;
      if (count == 0) return true;
      if (right - left == permSize && freqStr1[s2.charAt(left++)-'a']++ >= 0) count++;
      System.out.println("Left, right, count: " + left + ", " + right + ", " + count);
    }
    return false;
  }

  public static void main(String[] args) {
    String s = "cbaebabacd";
    String p = "abc";
    List<Integer> indeces = findAnagrams(s, p);
    // indeces.forEach((tmp) -> System.out.println(tmp));
    String s1 = "abc";
    String s2 = "eidoooacb";
    System.out.println(checkInclusion(s1, s2));
  }
}
