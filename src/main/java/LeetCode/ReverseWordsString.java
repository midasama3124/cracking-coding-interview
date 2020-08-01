package LeetCode;

public class ReverseWordsString {
    public static String reverseWords(String s) {
        StringBuilder strBld = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int right = i + 1;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            int left = i + 1;
            if (left != right) {
                strBld.append(' ');
                strBld.append(s.substring(left, right));
            }
        }
        if (strBld.length() > 0) strBld.deleteCharAt(0); // Remove first space character if any
        return strBld.toString();
    }

    public static void main(String[] args) {
        String s =  "the sky is blue";
        String res = reverseWords(s);
        System.out.println(res);
    }
}
