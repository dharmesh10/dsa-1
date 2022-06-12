package recursionanddp;

import java.util.HashMap;

public class CanConstruct {

  private static boolean canConstruct(String str, String[] words, HashMap<String, Boolean> memo) {
    if (memo.containsKey(str)) return memo.get(str);
    if (str.isEmpty() || "".equals(str)) return true;

    for (String word : words) {
      if (str.startsWith(word)) {
        String target = str.substring(word.length());
        if (canConstruct(target, words, memo)) {
          memo.put(target, true);
          return true;
        }
      }
    }

    memo.put(str, false);
    return false;
  }

  private static boolean canConstruct(String target, String[] words) {
    HashMap<String, Boolean> memo = new HashMap<>();
    return canConstruct(target, words, memo);
  }

  public static void main(String[] args) {
    boolean result = canConstruct("skateboard", new String[] {"ab", "abc", "cd", "def", "abdc"});
    System.out.println(result);
  }
}
