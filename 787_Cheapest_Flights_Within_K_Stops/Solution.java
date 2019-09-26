// Solution 1: Bell Ford
// Runtime: 5ms
class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
  {
    int[] costs = new int[n];
    Arrays.fill(costs, Integer.MAX_VALUE);
    costs[src] = 0;
    
    for (int i = 0; i < K + 1; i ++) {
      // Can also use temp.clone() or System.arrayCopy()
      int[] temp = Arrays.copyOfRange(costs, 0, n);
      
      for (int[] flight : flights) {
        int from = flight[0];
        int to = flight[1];
        int price = flight[2];
        
        if (costs[from] == Integer.MAX_VALUE) continue;
        
        temp[to] = Math.min(costs[from] + price, temp[to]);
      }
      
      costs = temp;
    }
    
    return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
  }
}


// Solution 2: DFS
// Runtime: 57ms
import javafx.util.Pair;

class Solution {
  private int ans;
  private Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
  
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
  {
    int[] visited = new int[n];
    visited[src] = 1;
    
    ans = Integer.MAX_VALUE;
    
    for (int[] flight : flights) {
      if (map.containsKey(flight[0])) {
        List<Pair<Integer, Integer>> inFlights = map.get(flight[0]);
        inFlights.add(new Pair<Integer, Integer>(flight[1], flight[2]));
      } else {
        List<Pair<Integer, Integer>> inFlights = new ArrayList<>();
        inFlights.add(new Pair<Integer, Integer>(flight[1], flight[2]));
        map.put(flight[0], inFlights);
      }
    }
    // System.out.println(map);
    
    dfs(src, dst, K + 1, 0, visited);
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
  
  private void dfs(int src, int dst, int k, int cost, int[] visited) {
    if (src == dst) {
      ans = cost;
      return;
    }
    
    if (k == 0 || !map.containsKey(src)) return;
    
    // System.out.println(dst);
    // System.out.println(src);
    for (Pair<Integer, Integer> toFlight : map.get(src)) {
      if (visited[toFlight.getKey()] == 1) continue;
      if (cost + toFlight.getValue() > ans) continue;
      
      visited[toFlight.getKey()] = 1;
      dfs(toFlight.getKey(), dst, k - 1, cost + toFlight.getValue(), visited);
      visited[toFlight.getKey()] = 0;
    }
  }
}


// Solution 3: BFS (deque offer and poll)
// Runtime: 70ms
import javafx.util.Pair;

class Solution {
  private int ans;
  private Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
  
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
  {
    int[] visited = new int[n];
    visited[src] = 1;
    
    ans = Integer.MAX_VALUE;
    
    for (int[] flight : flights) {
      if (map.containsKey(flight[0])) {
        List<Pair<Integer, Integer>> inFlights = map.get(flight[0]);
        inFlights.add(new Pair<Integer, Integer>(flight[1], flight[2]));
      } else {
        List<Pair<Integer, Integer>> inFlights = new ArrayList<>();
        inFlights.add(new Pair<Integer, Integer>(flight[1], flight[2]));
        map.put(flight[0], inFlights);
      }
    }
    
    Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
    queue.push(new Pair<Integer, Integer>(src, 0));
    int step = 0;

    while (queue.size() != 0) {
      int size = queue.size();
      System.out.println(queue);
      
      while (size > 0) {
        size --;
        Pair<Integer, Integer> curFlight = queue.poll();
        int cur = curFlight.getKey();
        int cost = curFlight.getValue();
        
        System.out.println("haha" + curFlight);
        if (cur == dst) {
          ans = Math.min(ans, cost);
          continue;
        }
        
        if (!map.containsKey(cur)) continue;
        
        for (Pair<Integer, Integer> toFlight : map.get(cur)) {
          // System.out.println(cur + "-" + toFlight + '-' + ans);
          if (cost + toFlight.getValue() > ans) continue;
          queue.offer(new Pair<Integer, Integer>(toFlight.getKey(), cost + toFlight.getValue()));
        }
      }
      
      if (step ++ > K) break;
    }
    
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}