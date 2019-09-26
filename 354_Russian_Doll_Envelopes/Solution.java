// Solution: DP
// Runtime: 40ms
class Solution {
  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes == null || envelopes.length == 0) {
      return 0;
    }

    int n = envelopes.length;
    int[] dp = new int[n];
    int len = 0;
    Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    
    for (int[] e : envelopes) {
      int index = Arrays.binarySearch(dp, 0, len, e[1]);
      if (index < 0) {
        // pos = -index - 1
        index = -(index + 1);
      }
      
      dp[index] = e[1];
      if (index == len) {
        len ++;
      }
    }
    
    return len;
  }
}