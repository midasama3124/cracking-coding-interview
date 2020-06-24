package Ch1_Arrays_Strings;

public class URLify {
  static String urlify(String str) {
    int cont = 0;
    String result = "";
    for (int i=0; i < str.length(); i++) {
      String temp = str.substring(i, i+1);
      if (!temp.equals(" ")) {
        if (cont > 0) result += "%20";
        result += temp;
        cont = 0;
      } else {
        cont++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String test = "Mr John  Smith   ";
    System.out.println(urlify(test));
  }
}
