package LeetCode;

import java.util.*;

public class GoatLatin {
    public static String toGoatLatin(String S) {
        int wordIdx = 1;
        int charIdx = 0;
        boolean firstChar = true;
        StringBuilder res = new StringBuilder();
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U');
        String consonant = new String();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            charIdx++;
            if (firstChar) {
                firstChar = false;
                if (!vowels.contains(c)) {
                    consonant = String.valueOf(c);
                    if (i < S.length() - 1) continue;
                } else consonant = "";
            }
            if (c != ' ') res.append(c);
            if (c == ' ' || i == S.length() - 1) {
                if (charIdx > 1) res.append(consonant);
                res.append("ma");
                for (int j = 0; j < wordIdx; j++) res.append('a');
                if (i < S.length() - 1) res.append(' ');
                wordIdx++;
                firstChar = true;
                charIdx = 0;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String test = "I speak Goat Latin";
//        String test = "HZ sg L";
        String res = toGoatLatin(test);
        System.out.println("\"" + res + "\"");
    }
}
