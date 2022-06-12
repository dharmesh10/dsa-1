package recursionanddp;

import java.util.Arrays;
import java.util.HashMap;

public class GridTraveller {

  static double numWays(int m, int n, double[][] memo) {
    if (memo[m][n] != -1) return memo[m][n];
    if (m == 1 && n == 1) return 1;
    if (m == 0 || n == 0) return 0;
    memo[m][n] = numWays(m - 1, n, memo) + numWays(m, n - 1, memo);

    return memo[m][n];
  }

  static double numWays(int m, int n) {
    double[][] memo = new double[m + 1][n + 1];
    for (double[] row : memo)
      Arrays.fill(row, -1);
    return numWays(m, n, memo);
  }

  public static void main(String[] args) {
    double result = numWays(18, 18);
    System.out.println(result);
  }
}
