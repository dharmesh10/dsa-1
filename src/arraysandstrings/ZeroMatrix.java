package arraysandstrings;

public class ZeroMatrix {

  private void nullify(int[][] matrix) {
    boolean[] rows = new boolean[matrix.length];
    boolean[] columns = new boolean[matrix[0].length];

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        if (matrix[row][col] == 0) {
          rows[row] = true;
          columns[col] = true;
        }
      }
    }

    // Nullify Rows
    for (int i = 0; i < rows.length; i++) {
      if (rows[i]) {
        nullifyRows(matrix, i);
      }
    }

    // Nullify columns
    for (int i = 0; i < columns.length; i++) {
      if (columns[i]) {
        nullifyCols(matrix, i);
      }
    }
  }

  void nullifyRows(int[][] matrix, int row) {
    for (int j = 0; j < matrix[0].length; j++) {
      matrix[row][j] = 0;
    }
  }

  void nullifyCols(int[][] matrix, int col) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }
}
