// Solution 1: TreeMap and DP
// Runtime: 80ms

class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        boolean[][] dp = new boolean[n][2];
        TreeMap<Integer, Integer> minMap = new TreeMap<>();
        
        minMap.put(A[n - 1], n - 1);
        
        dp[n - 1][0] = true;
        dp[n - 1][1] = true;
        
        int res = 1;
        
        for (int i = n - 2; i >= 0; i --) {
            if (minMap.containsKey(A[i])) {
                dp[i][0] = dp[minMap.get(A[i])][1];
                dp[i][1] = dp[minMap.get(A[i])][0];
            } else {
                Integer lowerBound = minMap.lowerKey(A[i]);
                dp[i][0] = lowerBound == null ? false : dp[minMap.get(lowerBound)][1];
                
                Integer upperBound = minMap.higherKey(A[i]);
                dp[i][1] = upperBound == null ? false : dp[minMap.get(upperBound)][0];
            }
            
            minMap.put(A[i], i);
            res += dp[i][1] ? 1 : 0;
        }
        
        return res;
    }
}


