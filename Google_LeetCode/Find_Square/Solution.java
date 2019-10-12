// Given a matrix of size m x n, there exists a square of all 1s in the matrix 
// (all other entries in the matrix are 0s). 
// The square of 1s is sqrt(n) or greater in size. 
// Find the top left corner of the square and return the size of the square as well.

class Solution {
  public int findSquare(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int sqrt = (int)Math.floor(Math.sqrt(n));

    int i = 0;
    int j = 0;
    
    for (; i < m - 2; i += sqrt) {
      j = 0;
      for (; j < n - 2; j += sqrt) {
        if (matrix[i][j] == 1) {
          break;
        }
      }

      if (j < n - 2) {
        break;
      }
    }

    int row = i;
    int col = j;

    int lo = 0;
    int hi = row;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      
      if (matrix[mid][col] == 1) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    int top = lo;

    // lo = 0;
    // hi = col;

    // while (lo < hi) {
    //   int mid = lo + (hi - lo) / 2;

    //   if (matrix[row][mid] == 1) {
    //     hi = mid;
    //   } else {
    //     lo = mid + 1;
    //   }
    // }

    // int left = lo;

    lo = row;
    hi = m - 1;
    
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;

      if (matrix[mid][col] == 0) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    int bottom = matrix[lo][col] == 0 ? lo - 1 : lo;

    return bottom - top + 1;
    
    // lo = col;
    // hi = n - 1;

    // while (lo < hi) {
    //   int mid = lo + (hi - lo) / 2;

    //   if (matrix[row][mid] == 1) {
    //     lo = mid;
    //   } else {
    //     hi = mid - 1;
    //   }
    // }

    // int right = lo;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.findSquare(new int[][]{
      {0, 0, 0, 0, 0, 0, 0},
      {0, 1, 1, 1, 0, 0, 0},
      {0, 1, 1, 1, 0, 0, 0},
      {0, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0}
    }));

    System.out.println(sol.findSquare(new int[][]{
      {0, 0, 0, 0, 0, 0, 0},
      {0, 1, 1, 1, 1, 0, 0},
      {0, 1, 1, 1, 1, 0, 0},
      {0, 1, 1, 1, 1, 0, 0},
      {0, 1, 1, 1, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0}
    }));

    System.out.println(sol.findSquare(new int[][]{
      {0, 0, 0, 0, 0, 0, 0, 0},
      {1, 1, 1, 1, 1, 0, 0, 0},
      {1, 1, 1, 1, 1, 0, 0, 0},
      {1, 1, 1, 1, 1, 0, 0, 0},
      {1, 1, 1, 1, 1, 0, 0, 0},
      {1, 1, 1, 1, 1, 0, 0, 0}
    }));
  }
}