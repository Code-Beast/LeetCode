// Solution 1: Bell-ford
// Runtime: 33ms
class Solution {
  public int networkDelayTime(int[][] times, int N, int K) {
    int MAX_TIME = 101 * 100;
    int[] dist = new int[N];
    Arrays.fill(dist, MAX_TIME);
    dist[K - 1] = 0;
    
    for (int i = 1; i < N; i ++) {
      for (int[] time : times) {
        int u = time[0] - 1;
        int v = time[1] - 1;
        int w = time[2];
        dist[v] = Math.min(dist[v], dist[u] + w);
      }
    }
    
    Arrays.sort(dist);
    int max_dist = dist[dist.length - 1];
    
    return max_dist == MAX_TIME ? -1 : max_dist;
  }
}



// Solution 2: Floyd-Warshall
// Runtime: 38ms
class Solution {
  public int networkDelayTime(int[][] times, int N, int K) {
    int MAX_TIME = 101 * 100;
    int[][] dp = new int[N][N];
    for (int i = 0; i < N; i ++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    
    for (int[] time : times) {
      dp[time[0] - 1][time[1] - 1] = time[2];
    }
    
    for (int i = 0; i < N; i ++) {
      dp[i][i] = 0;
    }
    
    for (int k = 0; k < N; k ++) {
      for (int i = 0; i < N; i ++) {
        for (int j = 0; j < N; j ++) {
          if (dp[i][k] == Integer.MAX_VALUE || dp[k][j] == Integer.MAX_VALUE) continue;
          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        }
      }
    }
    
    int ans = Integer.MIN_VALUE;
    
    for (int i = 0; i < N; i ++) {
      if (dp[K - 1][i] >= MAX_TIME) return -1;
      ans = Math.max(ans, dp[K - 1][i]);
    }
    
    return ans;
  }
}



// Solution 3: Dijkstra's algorithm
// Runtime: 18ms
class Solution {
  Map<Integer, Integer> dist;
  
  public int networkDelayTime(int[][] times, int N, int K) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    
    for (int[] edge : times) {
      graph.putIfAbsent(edge[0], new ArrayList<int[]>());
      graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }
    
    dist = new HashMap<>();
    for (int node = 1; node <= N; node ++) {
      dist.put(node, Integer.MAX_VALUE);
    }
    
    dist.put(K, 0);
    boolean[] seen = new boolean[N + 1];
    
    while (true) {
      int candNode = -1;
      int candDist = Integer.MAX_VALUE;
      for (int i = 1; i <= N; i ++) {
        // Find the current closest unseen node to the src node
        if (!seen[i] && dist.get(i) < candDist) {
          candDist = dist.get(i);
          candNode = i;
        }
      }
        
      if (candNode < 0) break;
      seen[candNode] = true;
      if (graph.containsKey(candNode)) {
        for (int[] info : graph.get(candNode)) {
          dist.put(info[0], Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
        }
      }
    }
    
    int ans = 0;
    for (int cand : dist.values()) {
      if (cand == Integer.MAX_VALUE) return -1;
      ans = Math.max(ans, cand);
    }
    
    return ans;
  }
}