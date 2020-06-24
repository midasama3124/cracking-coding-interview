package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionHeight {
  public static int[][] reconstructQueue(int[][] people) {
    /*// Sort array in ascending order in terms of height and k
    Arrays.sort(people, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
        else return Integer.compare(a[0], b[0]);
      }
    });*/
    // Sort in descending order to tackle the problem with
    // ArrayList instead of integer arrays
    Arrays.sort(people,
        (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]
    );
    /*// Fill resulting array based on following rules:
    // 1. Current position has not been taken
    // 2. Counter of greater numbers has already run off
    int[][] output = new int[people.length][2];
    boolean[] taken = new boolean[people.length];
    for (int[] person : people) {
        int count = person[1];
        for (int i = 0; i < taken.length; i++) {
            if (!taken[i]) {
                if (count == 0) {
                    output[i] = person;
                    taken[i] = true;
                    break;
                }
                count--;
            }
        }
        for (int[] p : output) {
          System.out.print(String.format("[%s, %s] ", p[0], p[1]));
        }
        System.out.println();
    }
    return output;*/
    // Instead of using arrays, avoid nested loops by iterating through
    // sorted array and inserting them into an ArrayList
    List<int[]> list = new ArrayList<>();
    for (int[] person : people) {
      list.add(person[1], person);
      for (int[] p : list) {
        System.out.print(String.format("[%s, %s] ", p[0], p[1]));
      }
      System.out.println();
    }
    return list.toArray(new int[people.length][2]);
  }

  public static void main(String[] args) {
    int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
    int[][] output = reconstructQueue(input);
  }
}
