package recursionanddp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HowSum {

  static ArrayList<Integer> howSum(int[] nums, int target, HashMap<Integer, ArrayList<Integer>> memo) {
    if (memo.containsKey(target)) return memo.get(target);
    if (target == 0) return new ArrayList<Integer>();
    if (target < 0) return null;

    for (int num : nums) {
      int remainder = target - num;
      ArrayList<Integer> list = howSum(nums, remainder, memo);
      if (list != null) {
        list.add(num);
        memo.put(remainder, list);
        return list;
      }
    }

    memo.put(target, null);
    return null;
  }

  static ArrayList<Integer> howSum(int[] nums, int target) {
    HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();
    return howSum(nums, target, memo);
  }

  public static void main(String[] args) {
    ArrayList<Integer> result = howSum(new int[]{300, 1, 14}, 300);
    if (result != null) {
      System.out.println(result.toString());
    } else {
      System.out.println(":(");
    }

  }
}
