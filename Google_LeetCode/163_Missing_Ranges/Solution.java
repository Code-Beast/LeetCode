// Solution 1: Traversal
// Runtime: 0ms
class Solution {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
      int n = nums.length;
      List<String> res = new ArrayList<>();
      
      if (n == 0) {
          res.add(rangeStr(lower, upper));
          return res;
      }
      
      int lo = lower;
      int up = upper;
      
      for (int i = 0; i < n; i ++) {
          if (lo < nums[i]) {
              res.add(rangeStr(lo, nums[i] - 1));
          }
  
          lo = nums[i] + 1;
          if (lo < nums[i]) {
              break;
          }
      }
      
      if (nums[n - 1] < upper) {
          res.add(rangeStr(nums[n - 1] + 1, upper));
      } 
      
      return res;
  }
  
  private String rangeStr(int lower, int upper) {
      if (lower == upper) {
          return String.valueOf(lower);
      }
      
      StringBuilder sb = new StringBuilder();
      
      sb.append(lower);
      sb.append("->");
      sb.append(upper);
      
      return sb.toString();
  }
}