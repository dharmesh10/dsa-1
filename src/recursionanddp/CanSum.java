package recursionanddp;

public class CanSum {

  static boolean canSum(int[] nums, int target, Boolean[] memo) {
    if (memo[target] != null) return memo[target];
    if (target == 0) return true;
    if (target < 0) return false;

    for (int num : nums) {
      if (target - num >= 0 && canSum(nums, target - num, memo)) {
        memo[target - num] = true;
        return true;
      }
    }

    memo[target] = false;
    return false;
  }

  static boolean canSum(int[] nums, int target) {
    Boolean[] memo = new Boolean[target + 1];
    return canSum(nums, target, memo);
  }

  public static void main(String[] args) {
    boolean isPossible = canSum(new int[]{1, 14}, 300);
    System.out.println(isPossible);
  }
}
