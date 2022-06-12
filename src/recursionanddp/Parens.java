package recursionanddp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Parens {
  public ArrayList<String> generateParens(int count) {
    char[] str = new char[count * 2];
    ArrayList<String> list = new ArrayList<>();
    addParens(list, count, count, str, 0);
    return list;
  }

  private void addParens(ArrayList<String> list, int leftParens, int rightParens, char[] str, int index) {
    if (leftParens < 0 || rightParens < leftParens) return; // Invalid state.

    if (leftParens == 0 && rightParens == 0) { // Out of parens.
      list.add(String.copyValueOf(str));
    } else {
      str[index] = '('; // Insert left paren.
      addParens(list, leftParens - 1, rightParens, str, index + 1);
      str[index] = ')';
      addParens(list, leftParens, rightParens - 1, str, index + 1);
    }
  }

  public Set<String> generateParens2(int remaining) {
    Set<String> set = new HashSet<>();
    if (remaining == 0) {
      set.add("");
    } else {
      Set<String> prev = generateParens2(remaining - 1);
      for (String str : prev) {
        for (int i = 0; i < str.length(); i++) {
          String s = insertAtIndex(str, i);
          set.add(s);
        }
        set.add("()" + str);
      }
    }
    return set;
  }

  private String insertAtIndex(String str, int leftIndex) {
    String left = str.substring(0, leftIndex + 1);
    String right = str.substring(leftIndex + 1, str.length());
    return left + "()" + right;
  }

  public static void main(String[] args) {
    ArrayList<String> output = new Parens().generateParens(2);
    System.out.println(output);
//    Set<String> set = new Parens().generateParens2(2);
//    System.out.println(set);
  }
}
