// Solution 1
// Runtime: 5ms
class Solution {
  public int minDominoRotations(int[] A, int[] B) {
    if (A.length != B.length) {
      return -1;
    }
    
    int n = A.length;
    int[] countA = new int[6];
    int[] countB = new int[6];
    int[] same = new int[6];
    
    for (int i = 0; i < n; i ++) {
      int a = A[i];
      int b = B[i];
      
      countA[a - 1] ++;
      countB[b - 1] ++;
      
      if (a == b) {
        same[a - 1] ++;
      }
    }
    
    for (int i = 0; i < 6; i ++) {
      if (countA[i] + countB[i] - same[i] >= n) {
        return Math.min(countA[i], countB[i]) - same[i];
      }
    }
    
    return -1;
  }
}