package LeetCode;

public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        return word.equals(word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase()) ||
                word.equals(word.toUpperCase()) ||
                word.equals(word.toLowerCase());
    }

    public static void main(String[] args) {
        String word = "USA";
        boolean res = detectCapitalUse(word);
        System.out.println(res);
    }
}
