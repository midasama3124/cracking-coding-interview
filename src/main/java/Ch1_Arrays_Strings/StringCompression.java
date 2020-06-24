package Ch1_Arrays_Strings;

public class StringCompression {
  // My solution
  /* static String compressString(String str) {
    if (str.length() < 2) return str;
    int cont = 1; // Character counter
    String temp = "";
    for (int i=1; i < str.length(); i++) {
      if (str.charAt(i) != str.charAt(i-1)) {
        temp += str.substring(i-1, i) + cont;
        cont = 1;
      }
      else cont++;
    }
    // Adding last character count
    temp += str.substring(str.length()-1) + cont;
    return str.length() > temp.length() ? temp : str;
  } */

  static String compressString(String str) {
    if (str.length() < 2) return str;
    int cont = 1; // Character counter
    int compressedLen = 0; // Length of compressed string
    StringBuilder compressedStr = new StringBuilder();
    for (int i=1; i < str.length(); i++) {
      if (str.charAt(i) != str.charAt(i-1) || i+1 >= str.length()) {  // Also appends
        compressedStr.append(str.charAt(i-1));
        compressedStr.append(cont);
        compressedLen += 1 + String.valueOf(cont).length();
        if (compressedLen > str.length()) return str;
        cont = 1;
      }
      else cont++;
    }
    return compressedStr.toString();
  }

  public static void main(String[] args) {
    String test = "aabddjddhhs";
    // String test = "a2b1d7j1d6h6";
    System.out.println(compressString(test));
  }
}
