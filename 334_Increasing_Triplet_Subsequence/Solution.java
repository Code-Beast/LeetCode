class Solution {
  public boolean increasingTriplet(int[] nums) {
    if (nums == null || nums.length <= 2) {
      return false;
    }
    
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    
    for (int i = 0; i < nums.length; i ++) {
      int curr = nums[i];
      
      // case 3
      if (curr > min2) {
        return true;
      } 
      // case 1
      else if (curr < min1) {
        min1 = curr;
      }
      // case 2
      else if (curr > min1 && curr < min2) {
        min2 = curr;
      }
    }
    
    return false;
  }
}