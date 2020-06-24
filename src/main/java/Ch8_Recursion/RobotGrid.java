package Ch8_Recursion;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotGrid {
  static class Point {
    private int row, column;

    public Point(int row, int column) {
      this.row = row;
      this.column = column;
    }
  }

  static ArrayList<Point> findRobotPath(boolean[][] maze) {
    if (maze == null || maze.length == 0) return null;
    ArrayList<Point> path = new ArrayList<>();
    HashSet<Point> failedPoints = new HashSet<>();
    if (findRobotPath(maze, maze.length-1, maze[0].length-1, path, failedPoints)) {
      return path;
    }
    return null;
  }

  static private boolean findRobotPath(boolean[][] maze, int row, int column,
      ArrayList<Point> path, HashSet<Point> failedPoints) {
    // If out of bounds or off-limit, return false
    if (row < 0 || column < 0 || !maze[row][column]) return false;

    Point p = new Point(row, column);

    // If point was already visited, return false
    if (failedPoints.contains(p)) return false;

    boolean pointAtOrigin = row == 0 && column == 0;

    // If point at origin or possible way out, add point to path and return true
    if (pointAtOrigin || findRobotPath(maze, row-1, column, path, failedPoints) ||
        findRobotPath(maze, row, column-1, path, failedPoints)) {
      path.add(p);
      return true;
    }

    // Otherwise, add point to failedPoints
    failedPoints.add(p);
    return false;
  }

  public static void main(String[] args) {
    boolean[][] maze = {{true, true, false, false, false},
        {true, false, true, false, true},
        {true, true, false, false, true},
        {false, true, false, true, true},
        {false, true, true, true, true}};
    ArrayList<Point> path = findRobotPath(maze);
    for (Point p : path) {
      System.out.println(String.format("%s, %s", p.row, p.column));
    }
  }
}
