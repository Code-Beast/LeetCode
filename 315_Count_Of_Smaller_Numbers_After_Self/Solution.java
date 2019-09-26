// Solution 1: Binary Search
// Runtime: 35ms
/*
class Solution {
  public List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<Integer>();
    }
    
    int n = nums.length;
    List<Integer> rightSortedNums = new ArrayList<>();
    rightSortedNums.add(nums[n - 1]);
    
    List<Integer> res = new ArrayList<>();
    res.add(0);
    
    for (int i = n - 2; i >= 0; i --) {
      res.add(0, binarySearch(rightSortedNums, nums[i]));
    }
    
    return res;
  }
  
  private int binarySearch(List<Integer> sortedNums, int bound) {
    int lo = 0, hi = sortedNums.size() - 1;
    
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      
      if (sortedNums.get(mid) >= bound) {
        hi = mid;
      } else if (sortedNums.get(mid) < bound) {
        lo = mid + 1;
      }
    }
    
    if (sortedNums.get(lo) >= bound) {
      sortedNums.add(lo, bound);
      return lo;
    } else {
      sortedNums.add(lo + 1, bound);
      return lo + 1;
    }
  }
}
*/



// Solution 2: Merge Sort
// Runtime: 6ms
class Solution {
  class Item {
    int val;
    int index;
    
    public Item(int v, int i) {
      val = v;
      index = i;
    }
  }
  public List<Integer> countSmaller(int[] nums) {
    int n = nums.length;
    Item[] items = new Item[n];
    for (int i = 0; i < n; i ++) {
      items[i] = new Item(nums[i], i);
    }
    
    int[] count = new int[n];
    mergeSort(items, 0, n - 1, count);
    List<Integer> res = new ArrayList<>();
    for (int c: count) {
      res.add(c);
    }
    
    return res;
  }
  
  private void mergeSort(Item[] items, int lo, int hi, int[] count) {
    if (lo >= hi) return;
    int mid = lo + (hi - lo) / 2;
    mergeSort(items, lo, mid, count);
    mergeSort(items, mid + 1, hi, count);
    merget(items, lo, mid, mid + 1, hi, count);
  }
  
  private void merget(Item[] items, int lo, int loEnd, int hi, int hiEnd, int[] count) {
    int m = hiEnd - lo + 1;
    Item[] sorted = new Item[m];
    int loPtr = lo, hiPtr = hi;
    int rightCounter = 0;
    
    int index = 0;
    while (loPtr <= loEnd && hiPtr <= hiEnd) {
      if (items[hiPtr].val < items[loPtr].val) {
        rightCounter ++;
        sorted[index ++] = items[hiPtr ++];
      } else {
        count[items[loPtr].index] += rightCounter;
        sorted[index ++] = items[loPtr ++];
      }
    }
    
    while (loPtr <= loEnd) {
      count[items[loPtr].index] += rightCounter;
      sorted[index ++] = items[loPtr ++];
    }
    
    while (hiPtr <= hiEnd) {
      sorted[index ++] = items[hiPtr ++];
    }
    
    System.arraycopy(sorted, 0, items, lo, m);
  }
}