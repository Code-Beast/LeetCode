// Solution 1: HashMap
// Runtime: 0ms
class Solution {
  public boolean confusingNumber(int N) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 0);
      map.put(1, 1);
      map.put(6, 9);
      map.put(8, 8);
      map.put(9, 6);
      
      int n = N;
      int newN = 0;
      
      while (n > 0) {
          int digit = n % 10;
          n /= 10;
          
          if (!map.containsKey(digit)) {
              return false;
          }
          
          newN = newN * 10 + map.get(digit);
      }
      
      return newN != N;
  }
}

