package recursionanddp;

import java.util.ArrayList;
import java.util.HashMap;

public class BestSum {

  static ArrayList<Integer> bestSum(int[] nums, int target, HashMap<Integer, ArrayList<Integer>> memo) {
    if (memo.containsKey(target)) return memo.get(target);
    if (target == 0) return new ArrayList<>();
    if (target < 0) return null;

    ArrayList<Integer> shortestList = null;

    for (int num : nums) {
      int remainder = target - num;
      ArrayList<Integer> list = bestSum(nums, remainder, memo);
      if (list != null) {
        list.add(num);
        if (shortestList == null || list.size() < shortestList.size()) {
          shortestList = list;
        }
      }
    }

    memo.put(target, shortestList);
    return shortestList;
  }

  static ArrayList<Integer> bestSum(int[] nums, int target) {
    HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();
    return bestSum(nums, target, memo);
  }

  public static void main(String[] args) {
    ArrayList<Integer> result = bestSum(new int[]{150}, 300);
    if (result != null) {
      System.out.println(result);
    } else {
      System.out.println(":(");
    }

  }
}
