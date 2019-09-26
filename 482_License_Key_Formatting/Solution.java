class Solution {
  public String licenseKeyFormatting(String S, int K) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    
    for (int i = S.length() - 1; i >= 0; i --) {
      char ch = S.charAt(i);
      if (count == K && ch != '-') {
        count = 0;
        sb.append('-');
      }
      
      if (ch != '-' && count < K) {
        sb.append(ch);
        count ++;
      }
    }
    
    return sb.reverse().toString().toUpperCase();
  }
}