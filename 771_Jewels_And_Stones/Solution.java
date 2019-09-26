// Solution 1: HashMap
// Runtime: 2ms
/*
class Solution {
  public int numJewelsInStones(String J, String S) {
    if (S.length() == 0 || S == null || J.length() == 0 || J == null) return 0;
    
    Map<Character, Integer> stoneNumMap = new HashMap<>();

    for (int i = 0; i < S.length(); i ++) {
      char stone = S.charAt(i);
      stoneNumMap.put(stone, stoneNumMap.getOrDefault(stone, 0) + 1);
    }
    
    int res = 0;
    for (int i = 0; i < J.length(); i ++) {
      char jewel = J.charAt(i);
      res += stoneNumMap.getOrDefault(jewel, 0);
    }
    
    return res;
  }
}
*/

// Solution 2: Contains
// Runtime: 1ms
class Solution {
  public int numJewelsInStones(String J, String S) {
    if (S == null || S.length() < 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < S.length(); i++) {
      if (J.contains(S.charAt(i) + "")) {
        count++;
      }
    }
    return count;
  }
}