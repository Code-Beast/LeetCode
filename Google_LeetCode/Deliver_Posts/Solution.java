// There are n post offices in a row, You are given the distance of each post office from your home. 
// A post office can send a post to another post office if the distance between the two places is less than or equal to x. 
// You are given q queries. Each query contain indices of two post offices. 
// You have to find whether the post offices can deliver post to each other or not. 
// You may use any number of post offices between two post offices if they satisfy the distance criteria
// Expected time complexity= O(n+q)

// Assume distances are sorted ascendingly

// Solution 1: Brute Force
// Runtime: O(q*t), t is the average idx difference
/*
import java.util.Arrays;

class Solution {
  public boolean[] deliverPosts(int[] distances, int[][] queries, int x) {
    boolean[] res = new boolean[queries.length];
    Arrays.fill(res, true);

    for (int i = 0; i < queries.length; i ++) {
      int[] query = queries[i];
      int lo, hi;

      if (query[0] > query[1]) {
        lo = query[1];
        hi = query[0];
      } else {
        lo = query[0];
        hi = query[1];
      }

      for (int k = lo; k < hi; k ++) {
        if (distances[k + 1] - distances[k] > x) {
          res[i] = false;
          break;
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    int[] distances = new int[]{1, 4, 5, 9, 10, 15, 18, 19, 20};
    int[][] queries = new int[][]{{0, 1}, {3, 4}, {4, 5}, {1, 7}, {2, 4}, {4, 7}, {5, 8}};

    printArr(sol.deliverPosts(distances, queries, 2));
    printArr(sol.deliverPosts(distances, queries, 3));
    printArr(sol.deliverPosts(distances, queries, 4));
    printArr(sol.deliverPosts(distances, queries, 5));
  }

  private static void printArr(boolean[] arr) {
    for (boolean bool : arr) {
      System.out.print(bool + " ");
    }

    System.out.println();
  }
}
*/


// Solution 2: Union Find
// Runtime: O(n + q)
class Solution {
  public boolean[] deliverPosts(int[] distances, int[][] queries, int x) {
    boolean[] res = new boolean[queries.length];
    int[] groupMap = new int[distances.length];
    int curGroup = 0;

    groupMap[0] = curGroup;

    for (int i = 1; i < distances.length; i ++) {
      if (distances[i] - distances[i - 1] > x) {
        curGroup ++;
      }

      groupMap[i] = curGroup;
    }

    for (int i = 0; i < queries.length; i ++) {
      if (groupMap[queries[i][0]] == groupMap[queries[i][1]]) {
        res[i] = true;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    int[] distances = new int[]{1, 4, 5, 9, 10, 15, 18, 19, 20};
    int[][] queries = new int[][]{{0, 1}, {3, 4}, {4, 5}, {1, 7}, {2, 4}, {4, 7}, {5, 8}};

    printArr(sol.deliverPosts(distances, queries, 2));
    printArr(sol.deliverPosts(distances, queries, 3));
    printArr(sol.deliverPosts(distances, queries, 4));
    printArr(sol.deliverPosts(distances, queries, 5));
  }

  private static void printArr(boolean[] arr) {
    for (boolean bool : arr) {
      System.out.print(bool + " ");
    }

    System.out.println();
  }
}