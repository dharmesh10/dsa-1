package recursionanddp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
  HashMap<Character, String> map = new HashMap<Character, String>();

  public List<String> letterCombinations(String digits) {
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    ArrayList<String> result = new ArrayList<String>();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    generateCombinations(digits, 0, new StringBuilder(), result);
    return result;
  }

  void generateCombinations(
      String digits, int index, StringBuilder temp, ArrayList<String> result) {
    if (index == digits.length()) {
      result.add(temp.toString());
      return;
    }

    String str = map.get(digits.charAt(index));

    for (char c : str.toCharArray()) {
      temp.append(c);
      generateCombinations(digits, index + 1, temp, result);
      temp.deleteCharAt(temp.length() - 1);
    }
  }

  public static void main(String[] args) {
    String num = "23";
    List<String> result = new LetterCombinations().letterCombinations(num);
    for (String s  : result) {
      System.out.println(s);
    }
  }
}
