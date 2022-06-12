package arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
  private static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> complementMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (complementMap.containsKey(complement)) {
        return new int[]{i, complementMap.get(complement)};
      }
      complementMap.put(nums[i], i);
    }

    return new int[]{-1, -1};
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4 ,5};
    int target = 3;
    int[] result = twoSum(nums, target);
    System.out.println(Arrays.toString(result));
  }
}
