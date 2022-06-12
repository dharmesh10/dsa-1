package arraysandstrings;

public class PalindromeCheckForPermutation {

  private boolean isPermutation(String phrase) {
    int[] count = new int[128]; // Assuming ASCII string.
    int countOdd = 0;

    for (char c : phrase.toCharArray()) {
      int code = getCharCode(c);
      if (code != -1) {
        count[code]++;
        if (count[code] % 2 == 1) {
          countOdd++;
        }
      }
    }

    return countOdd <= 1;
  }

  private int getCharCode(char c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if (a <= val && val <= z) {
      return val;
    }
    return -1;
  }
}
