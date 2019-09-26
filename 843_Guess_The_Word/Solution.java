// Solution 1: Elimination
// Runtime: 1ms
/*
class Solution {
  public void findSecretWord(String[] wordlist, Master master) {
    int numMatchedChars = 0;
    List<String> remainedWordList = Arrays.asList(wordlist);
    
    while (numMatchedChars < 6) {
      String chosenWord = getRandomWord(remainedWordList);
      numMatchedChars = master.guess(chosenWord);
      
      List<String> tempRemainedWordList = new ArrayList<>();
      
      for (String word : remainedWordList) {
        if (isMatched(word, chosenWord, numMatchedChars)) {
          tempRemainedWordList.add(word);
        }
      }
      
      remainedWordList = tempRemainedWordList;
    }
  }
  
  private boolean isMatched (String word1, String word2, int target) {
    int numMatchedChars = 0;
    
    for (int i = 0; i < 6; i ++) {
      if (word1.charAt(i) == word2.charAt(i)) {
        numMatchedChars ++;
      }
      
      if (numMatchedChars > target) {
        return false;
      }
    }
    
    return numMatchedChars == target;
  }
  
  private String getRandomWord (List<String> wordList) {
    int randomNum = (int)Math.floor(Math.random() * wordList.size());
    
    return wordList.get(randomNum);
  }
}
*/

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
  public void findSecretWord(String[] wordlist, Master master) {
    int numMatchedChars = 0;
    int size = wordlist.length;
    String chosenWord = "";
    int remainedSize = 0;
    
    while (numMatchedChars < 6) {
      remainedSize = size;
      size = 0;
      chosenWord = getRandomWord(wordlist, remainedSize);
      numMatchedChars = master.guess(chosenWord);
      
      for (int i = 0; i < remainedSize; i ++) {
        if (isMatched(wordlist[i], chosenWord, numMatchedChars)) {
          wordlist[size] = wordlist[i];
          size ++;
        }
      }
    }
  }
  
  private boolean isMatched(String word1, String word2, int target) {
    int numMatchedChars = 0;
    
    for (int i = 0; i < 6; i ++) {
      if (word1.charAt(i) == word2.charAt(i)) {
        numMatchedChars ++;
      }
      
      if (numMatchedChars > target) {
        return false;
      }
    }
    
    return numMatchedChars == target;
  }
  
  private String getRandomWord(String[] wordList, int size) {
    int randomNum = (int)Math.floor(Math.random() * size);
    
    return wordList[randomNum];
  }
}