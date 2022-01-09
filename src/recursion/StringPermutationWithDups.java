package recursion;

import java.util.ArrayList;
import java.util.HashMap;

public class StringPermutationWithDups {

  public ArrayList<String> printPerms(String s) {
    ArrayList<String> result = new ArrayList<>();
    HashMap<Character, Integer> map = buildFreqTable(s);
    printPerms(map, "", s.length(), result);
    return result;
  }

  private HashMap<Character, Integer> buildFreqTable(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (Character c : s.toCharArray()) {
      if (!map.containsKey(c)) {
        map.put(c, 0);
      }
      map.put(c, map.get(c) + 1);
    }
    return map;
  }

  private void printPerms(
      HashMap<Character, Integer> map, String prefix, int remainder, ArrayList<String> result) {
    // Base case
    if (remainder == 0) {
      result.add(prefix);
      return;
    }

    for (Character c : map.keySet()) {
      int count = map.get(c);
      if (count > 0) {
        map.put(c, count - 1);
        printPerms(map, prefix + c, remainder - 1, result);
        map.put(c, count);
      }
    }
  }

  public static void main(String[] args) {
    String input = "aabbbbc";
    ArrayList<String> output = new StringPermutationWithDups().printPerms(input);
    int count = 0;
    for (String s : output) {
      ++count;
      System.out.printf(count + "-" + s + "\n");
    }
  }
}
