// Solution 1: DFS
// Runtime: 45ms
class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
      StringBuilder sb = new StringBuilder();
      List<String> res = new ArrayList<>();
      Set<String> impossible = new HashSet<>();
      List<String> words = new ArrayList<>();
      
      dfs (s, wordDict, sb, res, impossible, words);
      
      return res;
  }
  
  private boolean dfs(String s, List<String> wordDict, StringBuilder temp, List<String> res, Set<String> impossible, List<String> words) {  
      if (s.equals(temp.toString())) {
          res.add(concatWords(words));
          return true;
      }
      
      boolean isPossible = false;
      
      for (String word : wordDict) {
          StringBuilder sb = new StringBuilder(temp);
          sb.append(word);
          words.add(word);
          String curStr = sb.toString();
          
          if (!impossible.contains(curStr) && s.startsWith(curStr) && dfs(s, wordDict, sb, res, impossible, words)) {
              isPossible = true;
          } else {
              impossible.add(curStr);
          }
          
          words.remove(words.size() - 1);
      }
      
      return isPossible;
  }
  
  private String concatWords(List<String> words) {
      StringBuilder sb = new StringBuilder();
      sb.append(words.get(0));
      
      for (int i = 1; i < words.size(); i ++) {
          sb.append(' ');
          sb.append(words.get(i));
      }
      
      return sb.toString();
  }
}



// Solution 2: DFS + Cache
// Runtime: 4ms
class Solution {
  private Map<String, List<String>> cache = new HashMap<>();
  
  public List<String> wordBreak(String s, List<String> wordDict) {
      if (cache.containsKey(s)) return cache.get(s);
      
      List<String> res = new ArrayList<>();
      
      for (String word : wordDict) {
          if (s.equals(word)) {
              res.add(word);
          } else if (s.startsWith(word)) {
              for (String rightStr : wordBreak(s.substring(word.length()), wordDict)) {
                  res.add(word + " " + rightStr);
              }
          }
      }
      
      cache.put(s, res);
      return res;
  }
}