// Solution 1: Bitmap + DP
// Runtime: 3ms
class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int minDist = Integer.MAX_VALUE;
        int N = workers.length;
        int M = bikes.length;
        int[] dp = new int[1 << M];
        
        for (int s = 1; s < (1 << M); ++s) {
            int w = Integer.bitCount(s);
            if (w > N) continue;
            
            dp[s] = Integer.MAX_VALUE;
            for (int i = 0; i < M; ++i) {
                if ((s & (1 << i)) == 0) continue;
                
                int preS = s ^ (1 << i);
                dp[s] = Math.min(dp[s], dp[preS] + getDistance(workers[w-1], bikes[i]));
            }
            
            if (w == N)
                minDist = Math.min(minDist, dp[s]);
        }
        
        return minDist;
    }
    
    private int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}



// Solution 2: DFS
// Runtime: 90ms
class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(workers, 0, bikes, new boolean[bikes.length], 0);
        return min;
    }
    
    int min = Integer.MAX_VALUE;
    void dfs(int[][] workers, int i, int[][] bikes, boolean[] used, int sum) {
        if (i == workers.length) {
            min = Math.min(min, sum);
            return;
        }
        
        if (sum > min) return;  // early termination
        
        for (int j = 0; j < bikes.length; ++j) {
            if (used[j]) continue;
            used[j] = true;
            dfs(workers, i+1, bikes, used, sum + getDistance(workers[i], bikes[j]));
            used[j] = false;
        }
    }
    
    int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}