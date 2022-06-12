package recursionanddp;

public class MagicIndex {

  public int magicIndexDistinct(int[] nums) {
    return magicIndexDistinct(nums, 0, nums.length - 1);
  }

  public int magicIndexDistinct(int[] nums, int start, int end) {
    if (end < start) {
      return -1;
    }
    int mid = (start + end) / 2;
    if (nums[mid] == mid) {
      return mid;
    } else if (nums[mid] > mid) {
      return magicIndexDistinct(nums, start, mid - 1);
    } else {
      return magicIndexDistinct(nums, mid + 1, end);
    }
  }

  public int magicIndexDuplicates(int[] nums, int start, int end) {
    if (end < start) {
      return -1;
    }
    int midIndex = (start + end) / 2;
    int midValue = nums[midIndex];
    if (midIndex == midValue) {
      return midIndex;
    }
    int leftIndex = Math.min(midIndex - 1, midValue);
    int left = magicIndexDuplicates(nums, leftIndex, midValue);
    if (left >= 0) {
      return left;
    }
    int rightIndex = Math.max(midIndex + 1, midValue);
    int right = magicIndexDuplicates(nums, rightIndex, end);
    return right;
  }
}
