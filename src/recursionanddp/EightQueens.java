package recursionanddp;

import java.util.ArrayList;
import java.util.Arrays;

public class EightQueens {

  private static final int GRID_SIZE = 8;

  static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
    if (row == GRID_SIZE) {
      results.add(columns.clone());
    } else {
      for (int col = 0; col < GRID_SIZE; col++) {
        if (checkValid(columns, row, col)) {
          columns[row] = col;
          placeQueens(row + 1, columns, results);
        }
      }
    }
  }

  static boolean checkValid(Integer[] columns, int row1, int column1) {
    for (int row2 = 0; row2 < row1; row2++) {
      int column2 = columns[row2];
      if (column1 == column2) {
        return false;
      }

      int columnDistance = Math.abs(column1 - column2);
      int rowDistance = row1 - row2;

      if (rowDistance == columnDistance) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    ArrayList<Integer[]> results = new ArrayList<Integer[]>();
    placeQueens(0, new Integer[8], results);

    for (Integer[] result : results) {
      System.out.println(Arrays.deepToString(result));
    }
  }
}
