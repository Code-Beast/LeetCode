// Solution 1: Dijakstra's Algorithm
// Runtime: 28ms
class Solution {
  public int networkDelayTime(int[][] times, int N, int K) {
      Map<Integer, List<int[]>> graph = buildGraph(times);
      if (graph.size() < N) {
          return -1;
      }
      
      Map<Integer, Integer> timeMap = new HashMap<>();
      int maxTime = Integer.MIN_VALUE;
      
      for (int node : graph.keySet()) {
          timeMap.put(node, Integer.MAX_VALUE);
      }
      
      timeMap.put(K, 0);
      int minCurTime = 0;
      int minNode = K;
      
      while (timeMap.size() > 0) {
          if (minNode == 0) {
              return -1;
          }
          
          maxTime = Math.max(maxTime, minCurTime);
          List<int[]> dstNodes = graph.get(minNode);
          
          for (int[] dstNode : dstNodes) {
              if (!timeMap.containsKey(dstNode[0])) {
                  continue;
              }

              int newTime = timeMap.get(minNode) + dstNode[1];
              
              if (newTime < timeMap.get(dstNode[0])) {
                  timeMap.put(dstNode[0], newTime);
              }
          }
          
          timeMap.remove(minNode);
          
          minNode = 0;
          minCurTime = Integer.MAX_VALUE;
          for (int node : timeMap.keySet()) {
              if (timeMap.get(node) < minCurTime) {
                  minCurTime = timeMap.get(node);
                  minNode = node;
              }
          }
      }
      
      return maxTime;
  }
  
  private Map<Integer, List<int[]>> buildGraph(int[][] times) {
      Map<Integer, List<int[]>> graph = new HashMap<>();
      
      for (int[] edge : times) {
          List<int[]> dstNodes = graph.getOrDefault(edge[0], new ArrayList<int[]>());
          dstNodes.add(new int[]{edge[1], edge[2]});
          graph.put(edge[0], dstNodes);
          
          if (!graph.containsKey(edge[1])) {
              graph.put(edge[1], new ArrayList<int[]>());
          }
      }
      
      return graph;
  }
}



// Solution 2: 
// Runtime: Bell-Ford
class Solution {
  public int networkDelayTime(int[][] times, int N, int K) {
      int[] dist = new int[N];
      Arrays.fill(dist, Integer.MAX_VALUE);
      
      dist[K - 1] = 0;
      
      for (int i = 1; i < N; i ++) {
          for (int[] time : times) {
              int u = time[0] - 1;
              int v = time[1] - 1;
              int w = time[2];
              
              if (dist[u] != Integer.MAX_VALUE) {
                  dist[v] = Math.min(dist[v], dist[u]+ w);
              }
          }
      }
      
      Arrays.sort(dist);
      int maxTime = dist[dist.length - 1];
      
      return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
  }
}



// Solution 3: Floyd-Warshall
// Runtime: 39ms
class Solution {
  public int networkDelayTime(int[][] times, int N, int K) {
      int[][] dist = new int[N][N];
      
      for (int i = 0; i < N; i ++) {
          Arrays.fill(dist[i], Integer.MAX_VALUE);
          dist[i][i] = 0;
      }
      
      for (int[] time : times) {
          dist[time[0] - 1][time[1] - 1] = time[2];
      }
      
      for (int k = 0; k < N; k ++) {
          for (int i = 0; i < N; i ++) {
              for (int j = 0; j < N; j ++) {
                  if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                      continue;
                  }
                  
                  dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
              }
          }
      }
      
      int maxTime = Integer.MIN_VALUE;
      for (int i = 0; i < N; i ++) {
          if (dist[K - 1][i] == Integer.MAX_VALUE) return -1;
          
          maxTime = Math.max(maxTime, dist[K - 1][i]);
      }
      
      return maxTime;
  }
}

