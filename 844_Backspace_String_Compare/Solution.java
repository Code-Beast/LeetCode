// Solution 1: String processing
// Runtime: 1ms
class Solution {
  public boolean backspaceCompare(String S, String T) {
    return eliminateBackspace(S).equals(eliminateBackspace(T));
  }
  
  private String eliminateBackspace(String s) {
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < s.length(); i ++) {
      char ch = s.charAt(i);
      
      if (ch == '#') {
        if (sb.length() != 0) {
          sb.setLength(sb.length() - 1);
        }
      } else {
        sb.append(ch);
      }
    }
    
    return sb.toString();
  }
}



// Solution 2: Two Pointers
// Runtime: 0ms
class Solution {
  public boolean backspaceCompare(String S, String T) {
    int i = S.length() - 1, j = T.length() - 1;
    int skipS = 0, skipT = 0;
    
    while (i >= 0 || j >= 0) {
      while (i >= 0) {
        if (S.charAt(i) == '#') {
          skipS ++;
          i --;
        } else if (skipS > 0) {
          skipS --;
          i --;
        } else break;
      }
      
      while (j >= 0) {
        if (T.charAt(j) == '#') {
          skipT ++;
          j --;
        } else if (skipT > 0) {
          skipT --;
          j --;
        } else break;
      }
      
      if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
        return false;
      }
      
      if ((i >= 0) != (j >= 0)) {
        return false;
      }
      
      i --;
      j --;
    }
    
    return true;
  }
}