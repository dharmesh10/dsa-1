package arraysandstrings;

public class CheckPermutation {

  private boolean isPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    int[] counts = buildFreqTable(s1);

    for (char c : s2.toCharArray()) {
      counts[c - 'a']--;
      if (counts[c - 'a'] < 0) {
        return false;
      }
    }

    return true;
  }

  int[] buildFreqTable(String str) {
    int[] table = new int[26];
    for (char c : str.toCharArray()) {
      table[c - 'a']++;
    }

    return table;
  }
}
