package LeetCode;

public class FloodFill {
  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    boolean[][] memo = new boolean[image.length][image[0].length];
    printMatrix(memo);
    return floodFill(image, sr, sc, newColor, memo);
  }

  // flood fill the given image from a starting point by coloring the 4-directionally matching points
  // recursively
  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor, boolean[][] memo) {
    // if input array is empty
    if (image.length == 0 || image[0].length == 0) return image;
    int pixel = image[sr][sc];   // Pixel of starting point before flood-filling
    if (memo[sr][sc]) return image;    // If pixel has been already flood-filling
    image[sr][sc] = newColor;    // Flood-filling corresponding pixel
    memo[sr][sc] = true;         // Update memo
    // Upper value
    if (sr > 0) {
      if (pixel == image[sr-1][sc]) {
        System.out.println("Upper");
        floodFill(image, sr-1, sc, newColor, memo);
      }
    }
    System.out.println("Passed Upper");
    // Lower value
    if (sr < image.length-1) {
      if (pixel == image[sr+1][sc]) {
        System.out.println("Lower");
        floodFill(image, sr+1, sc, newColor, memo);
      }
    }
    System.out.println("Passed Lower");
    // Left value
    if (sc > 0) {
      if (pixel == image[sr][sc-1]) {
        System.out.println("Left");
        floodFill(image, sr, sc-1, newColor, memo);
      }
    }
    System.out.println("Passed Left");
    // Right value
    if (sc < image[0].length-1) {
      if (pixel == image[sr][sc+1]) {
        System.out.println("Right");
        floodFill(image, sr, sc+1, newColor, memo);
      }
    }
    System.out.println("Passed Right");
    printMatrix(image);
    return image;
  }

  public static void printMatrix (int[][] matrix) {
    for (int[] a : matrix) {
      for (int b : a) {
        System.out.print(b + " ");
      }
      System.out.println();
    }
  }

  public static void printMatrix (boolean[][] matrix) {
    for (boolean[] a : matrix) {
      for (boolean b : a) {
        System.out.print(b + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[][] test = {{0,0,0},
        {0,1,1}};
    int sr = 1, sc = 1;
    int color = 1;
    int[][] floodFilled = floodFill(test, sr, sc, color);
    //printMatrix(floodFilled);
  }
}
