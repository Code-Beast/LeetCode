// Solution 1: BFS
// Runtime: 32ms
class Solution {
  private int[] rowDirs = {-1, 1, 0, 0};
  private int[] colDirs = {0, 0, -1, 1};
  
  public int shortestDistance(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      
      int[][] canReach = new int[m][n];
      int[][] dist = new int[m][n];
      
      int N = 0;
      for (int i = 0; i < m; i ++) {
          for (int j = 0; j < n; j ++) {
              if (grid[i][j] == 1) {
                  N ++;
                  bfs(i, j, grid, canReach, dist);
              }
          }
      }
      
      int minDistance = Integer.MAX_VALUE;
      for (int i = 0; i < m; i ++) {
          for (int j = 0; j < n; j ++) {
              if (grid[i][j] == 0 && canReach[i][j] == N && dist[i][j] < minDistance) {
                  minDistance = dist[i][j];
              }
          }
      }
      
      return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
  }
  
  private void bfs(int i, int j, int[][] grid, int[][] canReach, int[][] dist) {
      Queue<int[]> queue = new LinkedList<>();
      
      queue.offer(new int[]{i, j});
      int d = 0;
      boolean[][] visited = new boolean[grid.length][grid[0].length];
      
      while (!queue.isEmpty()) {
          d ++;
          int count = queue.size();
          
          for (int c = 0; c < count; c ++) {
              int[] pos = queue.poll();
          
              for (int k = 0; k < 4; k ++) {
                  int row = pos[0] + rowDirs[k];
                  int col = pos[1] + colDirs[k];
                  
                  if (isValid(row, col, grid, visited)) {
                      visited[row][col] = true;
                      queue.offer(new int[]{row, col});
                      canReach[row][col] ++;
                      dist[row][col] += d;
                  }
              }
          }
      }
  }
  
  private boolean isValid(int row, int col, int[][] grid, boolean[][] visited) {
      if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
          return false;
      }
      
      if (grid[row][col] != 0) {
          return false;
      }
      
      if (visited[row][col]) {
          return false;
      }
      
      return true;
  }
}