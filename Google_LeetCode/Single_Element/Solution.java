// Given an array nums of length n. All elements appear in pairs except one of them. 
// Find this single element that appears alone. Pairs of the same element cannot be adjacent

class Solution {
  // Solution 1: One Pass
  // Runtime: O(n)
  public int singleElement1(int[] nums) {
    for (int i = 0; i < nums.length - 1; i += 2) {
      if (nums[i] != nums[i + 1]) {
        return nums[i];
      }
    }

    return nums[nums.length - 1];
  }

  // Solution 2: Binary Search
  // Runtime: O(lgn)
  public int singleElement2(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    int lo = 0;
    int hi = nums.length - 1;

    while (hi - lo > 2) {
      int mid = lo + (hi - lo) / 2;

      if (nums[mid] == nums[mid + 1]) {
        lo = mid + 2;
      } else if (nums[mid] == nums[mid - 1]) {
        hi = mid - 2;
      } else {
        return nums[mid];
      }
    }

    int mid = (lo + hi) / 2;
    return nums[mid] == nums[lo] ? nums[hi] : nums[lo];
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.singleElement1(new int[]{2, 2, 1, 1, 9, 9, 5, 2, 2}));
    System.out.println(sol.singleElement1(new int[]{1, 1, 2}));
    System.out.println(sol.singleElement1(new int[]{3, 3, 2, 3, 3}));
    System.out.println(sol.singleElement1(new int[]{3, 1, 1}));

    System.out.println(sol.singleElement2(new int[]{2, 2, 1, 1, 9, 9, 5, 2, 2}));
    System.out.println(sol.singleElement2(new int[]{1, 1, 2}));
    System.out.println(sol.singleElement2(new int[]{3, 3, 2, 3, 3}));
    System.out.println(sol.singleElement2(new int[]{3, 1, 1}));
  }
}