// Solution 1: HashMap + DFS
// Runtime: 665ms
class Solution {
  private int count = 0;
  
  public int confusingNumberII(int N) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    map.put(1, 1);
    map.put(6, 9);
    map.put(8, 8);
    map.put(9, 6);
    
    int n = N;
    int length = 0;
    while (n > 0) {
      n /= 10;
      length ++;
    }
    
    for (int l = 1; l <= length; l ++) {
      dfs(0, 0, l, l, N, map);
    }
    
    return count;
  }

  void dfs(int num, int rotatedNum, int length, int rest, int N, Map<Integer, Integer> map) {
    if (rest == 0) {
      if (num <= N && num != rotatedNum) {
        count ++;
      }  
      return;
    }
    
    for (int digit : map.keySet()) {
      if (length == rest && length > 1 && digit == 0) continue;
      
      int newNum = num * 10 + digit;
      if ((newNum - digit) / 10 != num) continue;
      
      int newRotatedNum = rotatedNum + (int)(map.get(digit) * Math.pow(10, length - rest));
      
      dfs(newNum, newRotatedNum, length, rest - 1, N, map);
    }
  };
}



// Solution 1.5: HashMap + DFS
// Runtime: 27ms
class Solution {
  private int count = 0;
  private int[] d1 = {0, 1, 6, 8, 9};
  private int[] d2 = {0, 1, 9, 8, 6};
  
  public int confusingNumberII(int N) {
    dfs(0, 0, 1, N);
    
    return count;
  }

  void dfs(int num, int rotatedNum, int pow, int N) {
    if (num > N) return;
    if (num != rotatedNum) count ++;
    
    for (int i = 0; i < 5; i ++) {
      int digit = d1[i];
      if (pow == 1 && digit == 0) continue;
      
      int newNum = num * 10 + digit;
      if ((newNum - digit) / 10 != num) continue;
      
      int newRotatedNum = rotatedNum + d2[i] * pow;
      
      dfs(newNum, newRotatedNum, 10 * pow, N);
    }
  };
}



// Solution 2: HashMap + DFS
// Runtime: 16ms
class Solution {
  int[] d1 = {0,1,6,8,9};
  int[] d2 = {0,1,9,8,6};
  int sum = 0;
  public int confusingNumberII(int N) {
    if (N == 1_000_000_000) {
      N--;
      sum++;
    }
    help(0,0,1, N);
    return sum;
  }
  void help(int cur, int mir,int pow, int n) {
    if (cur > n) return;
    if (cur != mir) sum++;
    for (int i = (cur == 0 ? 1 : 0); i < 5; i++) {
      if (cur  > 100_000_000) continue;
      help(cur * 10 + d1[i], pow*d2[i] + mir, 10*pow, n);
    }
  }
}



// Solution 3: DFS
// Runtime: 100ms
class Solution {
  int sum = 0;
  int[] map = new int[]{0,1,-1,-1,-1,-1,9,-1,8,6};
  public int confusingNumberII(int N) {
    search(0,N);
    return sum;
  }
  private void search(long cur,int N) {
    if (cur > N) return;
    if (!same(cur)) sum++;
    for (int i = 0; i < map.length; i++) {
      if (map[i] == -1) continue;
      if (cur == 0 && i == 0) continue;
      search(cur * 10 + i,N);
    }
  }
  private boolean same(long cur) {
    long mirror = 0, ori = cur;
    for (; cur > 0; cur /= 10) {
      mirror = mirror * 10 + map[(int)(cur % 10)];
    }
    return mirror == ori;
  }
}



// Solution 4: Little Trick
// Runtime: 1ms
class Solution {
  static char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
  public int confusingNumberII(int N) {
      String num = Integer.toString(N);
      int res = findTotal(num);
      for (int len = 1; len <= num.length(); len++) {
          char[] curr = new char[len];
          res -= dfs(curr, num, 0, len - 1);
      }
      return res;
  }
  // count the # of numbers from "01689" that is less than N
  private int findTotal(String s) {
      if (s.length() == 0) return 1;
      char first = s.charAt(0);
      int res = count(first) * (int) (Math.pow(5, s.length() - 1));
      if (first == '0' || first == '1' || first == '6' || first == '8' || first == '9') {
          res += findTotal(s.substring(1));
      }
      return res;
  }
  // count the # of Strobogrammatic numbers
  private int dfs(char[] curr, String num, int left, int right) {
      int res = 0;
      if (left > right) {
          String s = new String(curr);
          if (s.length() < num.length() || s.compareTo(num) < 0) {
              res += 1;
          }
      } else {
          for (char[] p : pairs) {
              curr[left] = p[0];
              curr[right] = p[1];
              if ((curr[0] == '0' && curr.length > 1) || (left == right && p[0] != p[1])) continue;
              res += dfs(curr, num, left + 1, right - 1);
          }
      }
      return res;
  }
  
  // a helper function that counts the # of chars in "01689" less than given 'c'
  private int count(Character c) {
      int res = 0;
      for (char[] p : pairs) {
          if (p[0] < c) res += 1;
      }
      return res;
  }
}