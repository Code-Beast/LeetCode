// Solution 1: Binary Search
// Runtime: 1ms
class Solution {
  public int splitArray(int[] nums, int m) {
      int sum = 0;
      int max = 0;
      
      for (int num : nums) {
          sum += num;
          max = num > max ? num : max;
      }
      
      int lo = max;
      int hi = sum;
      
      while (lo < hi) {
          int mid = lo + (hi - lo) / 2;
          int count = 1;
          int curSum = 0;
          
          for (int num : nums) {
              if (curSum + num > mid) {
                  count ++;
                  curSum = 0;
              }
              
              curSum += num;
          }
          
          if (count > m) {
              lo = mid + 1;
          } else {
              hi = mid;
          }
      }
      
      return lo;
  }
}