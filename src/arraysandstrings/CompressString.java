package arraysandstrings;

public class CompressString {

  private String compress(String str) {
    int compressedLength = compressedLength(str);
    if (compressedLength >= str.length()) {
      return str;
    }
    StringBuilder compressed = new StringBuilder(compressedLength);
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;
      if (i + 1 >= str.length() || str.charAt(i + 1) != str.charAt(i)) {
        compressed.append(str.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }
    return compressed.toString();
  }

  private int compressedLength(String str) {
    int compressedLength = 0;
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;
      if (i + 1 >= str.length() || str.charAt(i + 1) != str.charAt(i)) {
        compressedLength += 1 + String.valueOf(countConsecutive).length();
        countConsecutive = 0;
      }
    }
    return compressedLength;
  }
}
