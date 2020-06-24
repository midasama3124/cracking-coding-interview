package Ch8_Recursion;

import java.util.ArrayList;

public class PermutationsString {
  public static ArrayList<String> findAllPermutations(String str) {
    ArrayList<String> permutations = new ArrayList<>();
    findAllPermutations(str, permutations);
    return permutations;
  }

  private static void findAllPermutations(String str, ArrayList<String> permutations) {
    if (str.isEmpty()) return;  // Base case

  }

  public static void main(String[] args) {
    String str = "abc";
    ArrayList<String> permutations = findAllPermutations(str);
    permutations.forEach(System.out::println);
  }
}
