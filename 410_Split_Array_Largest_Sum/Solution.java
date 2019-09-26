// Solution 1: Binary Search
// Runtime: 0ms
class Solution {
  public int splitArray(int[] nums, int m) {
    int n = nums.length;
    int max = 0;
    int sum = 0;
    for (int num : nums) {
      max = Math.max(max, num);
      sum += num;
    }
    
    int lo = max;
    int hi = sum;
    
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int pieces = split(nums, mid);
      
      if (pieces > m) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
      
    return lo;
  }
  
  private int split(int[] nums, int largestSum) {
    int pieces = 1;
    int tmpSum = 0;
    
    for (int num : nums) {
      if (tmpSum + num > largestSum) {
        tmpSum = num;
        pieces ++;
      } else {
        tmpSum += num;
      }
    }
    
    return pieces;
  }
}