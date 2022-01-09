package recursion;

import java.util.ArrayList;

public class StringPermutation {
  public ArrayList<String> getPerms(String str) {
    ArrayList<String> result = new ArrayList<String>();
    getPerms("", str, result);
    return result;
  }

  private ArrayList<String> getPerms1(String str) {
    ArrayList<String> permutations = new ArrayList<String>();
    if (str.length() == 0) {
      permutations.add("");
      return permutations;
    }

    char first = str.charAt(0);
    String remainder = str.substring(1);
    ArrayList<String> words = getPerms1(remainder);
    for (String word : words) {
      for (int j = 0; j <= word.length(); j++) {
        String s = insertCharAt(word, first, j);
        permutations.add(s);
      }
    }
    return permutations;
  }

  private static String insertCharAt(String str, char c,  int i) {
    String start = str.substring(0, i);
    String end = str.substring(i);
    return new StringBuilder(start).append(c).append(end).toString();
  }

  private void getPerms(String prefix, String remainder, ArrayList<String> result) {
    if (remainder.length() == 0) result.add(prefix);

    int len = remainder.length();
    for (int i = 0; i < len; i++) {
      String before = remainder.substring(0, i);
      String after = remainder.substring(i + 1, len);
      char c = remainder.charAt(i);
      getPerms(prefix + c, before + after, result);
    }
  }

  public static void main(String[] args) {
    String input = "abcd";
    // ArrayList<String> output = new StringPermutation().getPerms(input);
    ArrayList<String> output = new StringPermutation().getPerms1(input);
    for (String result : output) {
      System.out.printf(result + "\n");
    }
  }
}
