// Solution 1: DP
// Runtime: 1ms
class Solution {
  public int mincostTickets(int[] days, int[] costs) {
    if (days == null || days.length == 0 || costs == null || costs.length == 0) {
      return 0;
    }
    
    int[] dp = new int[366];
    dp[0] = 0;
    int nextDayIdx = 0;
    
    for (int i = 1; i <= 365; i ++) {
      if (i == days[nextDayIdx]) {
        dp[i] = Math.min(dp[Math.max(0, i - 1)] + costs[0], Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));

        if (nextDayIdx + 1 == days.length) {
          break;
        }
    
        nextDayIdx ++;
      } else {
        dp[i] = dp[i - 1];
      }
    }
    return dp[days[nextDayIdx]];
  }
}