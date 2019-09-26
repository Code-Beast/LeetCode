// Solution 1: Swap
// Runtime: 0ms
class Solution {
  public String strWithout3a3b(int A, int B) {
    StringBuilder sb = new StringBuilder();
    char a = 'a';
    char b = 'b';
    
    if (A < B) {
      char tempCh = a;
      a = b;
      b = tempCh;

      int tempNum = A;
      A = B;
      B = tempNum;    
    }
    
    while (A > 0 || B > 0) {
      if (A > 0) {
        sb.append(a);
        A --;
      }
      if (A > B) {
        sb.append(a);
        A --;
      }
      if (B > 0) {
        sb.append(b);
        B --;
      }
    }
    
    return sb.toString();
  }
}