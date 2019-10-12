// You are given a phone number as an array of n digits. To help you memorize the number, you want to divide it into groups of contiguous digits. Each group must contain exactly 2 or 3 digits. There are 3 kinds of groups:

// Excellent: A group that contains only the same digits. For example, 000 or 77.
// Good: A group of 3 digits, 2 of which are the same. For example, 030, 229 or 166.
// Usual: A group in which all the digits are distinct. For example, 123 or 90.
// The quality of a group assignment is defined as 2 × (number of excellent groups) + (number of good groups). Divide the phone number into groups such that the quality is maximized.

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
  private Map<Integer, Integer> qualityMap;

  // Solution 1: DFS
  // Runtime: O(n)
  public int findBestQuality(int[] digits) {
    qualityMap = new HashMap<>();

    return findBestQualityHelper(digits, 0);
  }  

  private int findBestQualityHelper(int[] digits, int start) {
    if (qualityMap.containsKey(start)) {
      return qualityMap.get(start);
    }

    if (digits.length - start < 2) {
      qualityMap.put(start, Integer.MIN_VALUE);
      return Integer.MIN_VALUE;
    }

    int qualityTwo = getTwoQuality(new int[]{digits[start], digits[start + 1]});

    if (digits.length - start == 2) {
      return qualityTwo;
    }

    int qualityThree = getThreeQuality(new int[]{digits[start], digits[start + 1], digits[start + 2]});
    int quality = Math.max(findBestQualityHelper(digits, start + 2) + qualityTwo, findBestQualityHelper(digits, start + 3) + qualityThree);
    
    qualityMap.put(start, quality);

    return quality;
  }

  private int getTwoQuality(int[] digits) {
    if (digits[0] == digits[1]) {
      return 2;
    }

    return 0;
  }

  private int getThreeQuality(int[] digits) {
    Set<Integer> set = new HashSet<>();

    for (int digit : digits) {
      set.add(digit);
    }

    int size = set.size();
    if (size == 3) {
      return 0;
    } else if (size == 2) {
      return 1;
    } else {
      return 2;
    }
  }

  // Solution 2: DP
  // Runtime: O(n)
  public int findBestQualityDP(int[] digits) {
    int n = digits.length;
    int[] dp = new int[n];

    dp[0] = Integer.MIN_VALUE;
    dp[1] = getTwoQuality(new int[]{digits[0], digits[1]});
    dp[2] = getThreeQuality(new int[]{digits[0], digits[1], digits[2]});

    int bestQuality = Math.max(dp[1], dp[2]);

    for (int i = 3; i < n; i ++) {
      int quality = Math.max(getTwoQuality(new int[]{digits[i], digits[i - 1]}) + dp[i - 2], getThreeQuality(new int[]{digits[i], digits[i - 1], digits[i - 2]}) + dp[i - 2]);
      dp[i] = quality;

      if (quality > bestQuality) {
        bestQuality = quality;
      }
    }

    return bestQuality;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.findBestQuality(new int[]{1, 3, 2, 2, 0, 0, 1, 0, 1, 2, 3, 3, 3}));
    System.out.println(sol.findBestQualityDP(new int[]{1, 3, 2, 2, 0, 0, 1, 0, 1, 2, 3, 3, 3}));
  }
}