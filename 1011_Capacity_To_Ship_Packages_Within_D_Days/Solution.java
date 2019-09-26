// Solution 1: Binary Search
// Runtime: 8ms
class Solution {
  public int shipWithinDays(int[] weights, int D) {
    int lo = 1;
    for (int i = 0; i < weights.length; i ++) {
      if (lo < weights[i]) {
        lo = weights[i];
      }
    }
    
    int hi = 0;
    for (int i = 0; i < weights.length; i ++) {
      hi += weights[i];
    }
    
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
 
      if (minShips(weights, mid) > D) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    
    return lo;
  }
  
  private int minShips(int[] weights, int capacity) {
    int i = 0;
    int sum = 0;
    int res = 0;
    
    while (i < weights.length) {
      sum += weights[i];
      if (sum > capacity) {
        res ++;
        sum = 0;
      } else if (sum == capacity) {
        res ++;
        sum = 0;
        i ++;
      } else {
        i ++;
      }
    }
    
    if (sum != 0) res ++;
    return res;
  }
}