package recursionanddp;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotMaze {
  class Point {
    int row;
    int col;

    Point(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  public ArrayList<Point> getPaths(boolean[][] maze) {
    if (maze == null || maze.length == 0) return null;
    ArrayList<Point> paths = new ArrayList<>();
    HashSet<Point> failedPoints = new HashSet<>();
    if (getPaths(maze, maze.length, maze[0].length, failedPoints, paths)) {
      return paths;
    }
    return null;
  }

  private boolean getPaths(
      boolean[][] maze, int row, int col, HashSet<Point> failedPoints, ArrayList<Point> paths) {
    if (row < 0 || col < 0 || !maze[row][col]) return false;
    Point p = new Point(row, col);
    if (failedPoints.contains(p)) {
      return false;
    }
    boolean isAtOrigin = row == 0 && col == 0;
    if (isAtOrigin
        || getPaths(maze, row - 1, col, failedPoints, paths)
        || getPaths(maze, row, col - 1, failedPoints, paths)) {
      paths.add(p);
      return true;
    }
    failedPoints.add(p);
    return false;
  }
}
