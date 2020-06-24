package Ch1_Arrays_Strings;

public class OneAway {
  static boolean isOneAway(String str1, String str2) {
    if (Math.abs(str1.length()-str2.length()) > 1) return false;
    if (str1.equals(str2)) return true;
    if (str1.length() > str2.length()) return isOneAwayDiffLen(str2, str1);
    else return isOneAwayDiffLen(str1, str2);
  }

  private static boolean isOneAwayDiffLen(String shorter, String longer) {
    boolean oneDiff = false;
    for (int i=0; i < shorter.length(); i++) {
      if (shorter.charAt(i) != longer.charAt(i)) {
        if (shorter.length() == longer.length()) {
          if (oneDiff) return false;
          oneDiff = true;
        } else {
          String reconst =
              shorter.substring(0, i) + longer.substring(i, i + 1) + shorter.substring(i);
          return longer.equals(reconst);
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String str1 = "abcde";
    String str2 = "abdcaasdasddasd";
    System.out.println(isOneAway(str1, str2));
  }
}
