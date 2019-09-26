// Solution 1
// Runtime: 6ms
class Solution {
  public int totalFruit(int[] tree) {
    if (tree == null || tree.length == 0) {
      return 0;
    }

    int max = 0;
    // Map<Integer, Integer> fruitIdxMap = new HashMap<>();
    int secondTypeIdx = -1;
    int firstType = tree[0];
    int secondType = -1;
    int i = 1;
    int currMax = 1;
    
    while (i < tree.length) {
      int currType = tree[i];
      
      if (secondType == -1 && firstType != currType) {
        secondType = currType;
        secondTypeIdx = i;
      }

      if (currType == firstType && secondType != -1) {
        currMax ++;
        int temp = firstType;
        firstType = secondType;
        secondType = temp;
        secondTypeIdx = i;
      } else if (currType == secondType || currType == firstType && secondType == -1) {
        currMax ++;
      } else {
        max = Math.max(max, currMax);
        currMax = 0;
        firstType = secondType;
        secondType = currType;
        i = secondTypeIdx;
        secondTypeIdx = i;
        continue;
      }
      
      i ++;
    }
    
    return Math.max(max, currMax);
  }
}



// Solution 2: Double Pointers
// Runtime: 39ms
class Solution {
  public int totalFruit(int[] tree) {
    if (tree == null || tree.length == 0) {
      return 0;
    }

    int max = 1;
    Map<Integer, Integer> map = new HashMap<>();
    int i = 0;
    int j = 0;
    while (j < tree.length) {
      if (map.size() <= 2) {
        map.put(tree[j], j ++);
      }
      
      if (map.size() > 2) {
        int min = tree.length - 1;
        for (int value: map.values()) {
          min = Math.min(min, value);
        }
        
        i = min + 1;
        map.remove(tree[min]);
      }
      
      max = Math.max(max, j - i);
    }
    
    return max;
  }
}