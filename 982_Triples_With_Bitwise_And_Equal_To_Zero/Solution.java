// Solution 1: Data Compression
// 92ms
class Solution {
  public int countTriplets(int[] A) {
    int n = (int)Math.pow(2, 16);
    int[] twoAndMap = new int[n];

    for (int i = 0; i < A.length; i ++) {
      for (int j = 0; j < A.length; j ++) {
        twoAndMap[A[i] & A[j]] ++;
      }
    }

    int res = 0;

    for (int k = 0; k < A.length; k ++) {
      for (int twoAnd = 0; twoAnd < n; twoAnd ++) {
        if ((A[k] & twoAnd) == 0) {
          res += twoAndMap[twoAnd];
        }
      }
    }
    
    return res;
  }
}