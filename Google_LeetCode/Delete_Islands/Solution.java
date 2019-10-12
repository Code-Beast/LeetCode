// Given a binary grid where 0 represents water and 1 represents land. 
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
// Delete all islands except their borders. 
// A border is land adjacent to water. You may assume all four edges of the grid are surrounded by water.

// Solution 1: Two Pass
// Runtime: O(n^2)
class Solution {
  public int[][] deleteIslands(int[][] grid) {
    int[] rowDirs = new int[]{-1, 1, 0, 0};
    int[] colDirs = new int[]{0, 0, -1, 1};

    for (int i = 1; i < grid.length - 1; i ++) {
      for (int j = 1; j < grid[0].length - 1; j ++) {
        boolean doChange = true;

        for (int k = 0; k < 4; k ++) {
          int neighbor = grid[i + rowDirs[k]][j + colDirs[k]];
          if (neighbor != 1 && neighbor != -1) {
            doChange = false;
            break;
          }
        }

        if (doChange) {
          grid[i][j] = -1;
        }
      }
    }

    for (int i = 1; i < grid.length - 1; i ++) {
      for (int j = 1; j < grid[0].length - 1; j ++) {
        if (grid[i][j] == -1) {
          grid[i][j] = 0;
        }
      }
    }

    return grid;
  }

  public static void main(String[] args) {
    int[][] grid1 = new int[][]{
      {0, 0, 0, 1, 1, 1},
      {0, 0, 0, 1, 1, 1},
      {1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1}
    };

    int[][] grid2 = new int[][] {
      {1, 1, 1, 0, 1, 1, 1},
      {1, 1, 1, 0, 1, 1, 1},
      {1, 1, 1, 0, 1, 1, 1},
      {0, 0, 0, 0, 1, 1, 1},
      {1, 1, 1, 0, 1, 1, 1}
    };

    Solution sol = new Solution();
    printGrid(sol.deleteIslands(grid1));
    printGrid(sol.deleteIslands(grid2));
  }

  public static void printGrid(int[][] grid) {
    for (int[] row : grid) {
      for (int e : row) {
        System.out.print(e);
      }

      System.out.println();
    }

    System.out.println();
    System.out.println();
  }
}