package LeetCode;

import java.util.*;

public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        // With extra space
//        if (rowIndex == 0) return Arrays.asList(1);
//        List<Integer> res = Arrays.asList(1, 1);
//        for (int i = 2; i <= rowIndex; i++) {
//            List<Integer> tmp = new ArrayList<>();
//            for (int j = 0; j < res.size() - 1; j++) {
//                tmp.add(res.get(j) + res.get(j + 1));
//            }
//            // Initial and final ones
//            tmp.add(0, 1);
//            tmp.add(1);
//            res = tmp;
//        }
//        return res;
        // Without extra space
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(1);
        }
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j) +  res.get(j - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int rowIndex = 5;
        List<Integer> res = getRow(rowIndex);
        System.out.println(res.toString());
    }
}
