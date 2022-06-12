package arraysandstrings;

public class URLify {

  void urlify(char[] str, int tureLength) {
    int newIndex = countSpaces(str, 0, str.length, ' ');
    if (newIndex + 1 < str.length) {
      str[newIndex + 1] = '\0';
    }
    for (int oldIndex = tureLength - 1; oldIndex >= 0; oldIndex--) {
      if (str[oldIndex] == ' ') {
        str[newIndex] = '0';
        str[newIndex - 1] = '2';
        str[newIndex - 2] = '%';
        newIndex -= 2;
      } else {
        str[newIndex] = str[oldIndex];
        newIndex -= 1;
      }
    }
  }

  private int countSpaces(char[] str, int start, int end, char target) {
    int count = 0;
    for (int i = start; i < end; i++) {
      if (str[i] == target) {
        count++;
      }
    }

    return count;
  }
}
