package LeetCode;

import java.util.*;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int firstRow = 0, lastRow = matrix.length - 1;
        int firstCol = 0, lastCol = matrix[0].length - 1;
        while (firstCol <= lastCol && firstRow <= lastRow) {
            // First row
            for (int j = firstCol; j <= lastCol; j++) {
                res.add(matrix[firstRow][j]);
            }
            // Last col
            for (int i = firstRow + 1; i <= lastRow; i++) {
                res.add(matrix[i][lastCol]);
            }
            if (firstRow < lastRow && firstCol < lastCol) {
                // Last row
                for (int j = lastCol - 1; j > firstCol; j--) {
                    res.add(matrix[lastRow][j]);
                }
                // First col
                for (int i = lastRow; i > firstRow; i--) {
                    res.add(matrix[i][firstCol]);
                }
            }
            firstRow++;
            lastRow--;
            firstCol++;
            lastCol--;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};
        int[][] matrix = {
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        };
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res.toString());
    }
}
