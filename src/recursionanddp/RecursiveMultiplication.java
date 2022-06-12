package recursionanddp;

public class RecursiveMultiplication {
  public int minProduct(int a, int b) {
    int smaller = a < b ? a : b;
    int bigger = a < b ? b : a;
    int[] memo = new int[smaller + 1];
    return minProduct(smaller, bigger, memo);
  }

  private int minProduct(int smaller, int bigger, int[] memo) {
    if (smaller == 0) {
      return 0; // 0 * bigger = 0
    } else if (smaller == 1) {
      return bigger; // 1 * bigger = bigger
    } else if (memo[smaller] > 0) {
      return memo[smaller];
    }

    int s = smaller >> 1; // Divide by 2
    int side1 = minProduct(s, bigger, memo);
    int side2 = side1;
    if (smaller % 2 == 1) {
      side2 = minProduct(smaller - s, bigger, memo);
    }
    memo[smaller] = side1 + side2;
    return memo[smaller];
  }

  public static void main(String[] args) {
    int product = new RecursiveMultiplication().minProduct(7, 5);
    System.out.println(product);
  }
}
