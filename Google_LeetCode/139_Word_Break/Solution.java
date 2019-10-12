// Solution 1: DFS + HashSet
// Runtime: 4ms
class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
      StringBuilder sb = new StringBuilder();
      Set<String> impossible = new HashSet<>();
      
      return dfs(s, wordDict, sb, impossible);
  }
  
  private boolean dfs(String s, List<String> wordDict, StringBuilder sb, Set<String> impossible) {
      if (s.equals(sb.toString())) {
          return true;
      }
      
      for (String word : wordDict) {
          StringBuilder sbUpdated = new StringBuilder(sb);
          sbUpdated.append(word);
          String curString = sbUpdated.toString();
          
          if (!impossible.contains(curString) && s.startsWith(curString) && dfs(s, wordDict, sbUpdated, impossible)) {
              return true;
          } else {
              impossible.add(curString);
          }
      }
      
      return false;
  }
}