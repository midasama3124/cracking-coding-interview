package LeetCode;

import java.util.*;

public class NumbersSameConsecutiveDifferences {
    private static List<Integer> res = new ArrayList<>();
    public static int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) res.add(0);
        for (int i = 1; i <= 9; i++)
            iterate(N, K, i, new String());
        return res.stream().mapToInt(i -> i).toArray();
    }

    private static void iterate(int n, int k, int i, String str) {
        if (str.length() == n) {
            int sol = Integer.parseInt(str);
            if (!res.contains(sol)) res.add(sol);
            return;
        }
        if (i >= 0 && i <= 9) {
            str += String.valueOf(i);
            iterate(n, k, i + k, str);
            iterate(n, k, i - k, str);
        }
    }

    public static void main(String[] args) {
//        int N = 3, K = 7;
        int N = 2, K = 1;
//        int N = 1, K = 6;
        int[] res = numsSameConsecDiff(N, K);
        System.out.println(Arrays.toString(res));
    }
}
