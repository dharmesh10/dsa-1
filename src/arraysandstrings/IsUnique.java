package arraysandstrings;

public class IsUnique {

  private boolean isUnique(String str) {
    int[] counts = buildFreqTable(str);

    for (int i = 0; i < 26; i++) {
      if (counts[i] > 1) return false;
    }

    return true;
  }

  private int[] buildFreqTable(String str) {
    int[] table = new int[26];

    for (char c : str.toCharArray()) {
      table[c - 'a']++;
    }

    return table;
  }
}
