package recursionanddp;

import java.util.ArrayList;

public class PlaceHolder {
  public static void test(int n, int m, ArrayList<Integer> result) {
    if ( n == 0) {
      result.add(m);
      return;
    }

    for (int i = 0; i < n; i++) {
      --n;
      test(n, m, result);
    }
  }

  public static void main(String[] args) {
    test(3, 4, new ArrayList<>());
  }
}
