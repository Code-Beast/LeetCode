// Solution 1: Comparator
// Runtime: 4ms
class Solution {
  public static class LogComparator implements Comparator<String> {
      public int compare(String a, String b) {
          int aIdx = getSplitIndex(a);
          int bIdx = getSplitIndex(b);
          
          String aContent = a.substring(aIdx + 1, a.length());
          String bContent = b.substring(bIdx + 1, b.length());
          
          boolean aIsNumber = isNumber(aContent);
          boolean bIsNumber = isNumber(bContent);
          
          if (aIsNumber && bIsNumber) {
              return 0;
          } else if (aIsNumber && !bIsNumber) {
              return 1;
          } else if (!aIsNumber && bIsNumber) {
              return -1;
          } else {
              int temp = aContent.compareTo(bContent);
              
              return temp == 0 ? a.substring(0, aIdx).compareTo(b.substring(0, bIdx)) : temp;
          }
      }
  }
  
  public String[] reorderLogFiles(String[] logs) {
      if (logs == null || logs.length == 0) {
          return null;
      }
      
      Arrays.sort(logs, new LogComparator());
      return logs;
  }
  
  private static int getSplitIndex(String log) {
      for (int i = 0; i < log.length(); i ++) {
          if (log.charAt(i) == ' ') {
              return i;
          }
      }
      
      return -1;
  }
  
  private static boolean isNumber(String str) {
      char firstCh = str.charAt(0);
      
      return firstCh <= '9' && firstCh >= '0';
  }
}