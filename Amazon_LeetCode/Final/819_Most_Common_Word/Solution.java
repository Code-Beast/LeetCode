// Solution 1: HashMap
// Runtime: 5ms
class Solution {
  public String mostCommonWord(String paragraph, String[] banned) {
      StringBuilder sb = new StringBuilder();
      Map<String, Integer> countMap = new HashMap<>();
      Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
      int n = paragraph.length();
      
      paragraph = paragraph.toLowerCase();
      
      for (int i = 0; i < n; i ++) {
          char ch = paragraph.charAt(i);
          boolean isLetter = false;
          
          if (ch <= 'z' && ch >= 'a') {
              sb.append(ch);
              isLetter = true;
          }
          
          if (sb.length() != 0 && !isLetter || i == n - 1) {
              String word = sb.toString();
              
              if (!bannedWords.contains(word)) {
                  countMap.put(word, countMap.getOrDefault(word, 0) + 1);
              }
              
              sb.setLength(0);
          }
      }
      
      int maxCount = Integer.MIN_VALUE;
      String maxWord = null;
      for (String word : countMap.keySet()) {
          int count = countMap.get(word);
          
          if (count > maxCount) {
              maxWord = word;
              maxCount = count;
          }
      }
      
      return maxWord;
  }
}