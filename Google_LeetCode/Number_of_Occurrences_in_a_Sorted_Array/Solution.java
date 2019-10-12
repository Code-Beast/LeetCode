class Solution {
  public int findOccurrances(int[] arr, int target) {
    int leftBound = this.binarySearch(arr, target);
    if (leftBound < 0) return 0;

    int rightBound = this.binarySearch(arr, target + 1);

    return rightBound - leftBound;
  }

  private int binarySearch(int[] arr, int target) {
    int lo = 0, hi = arr.length - 1;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;

      if (arr[mid] >= target) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.findOccurrances(new int[]{4, 4, 8, 8, 8, 15, 16, 23, 23, 42}, 8));
    System.out.println(sol.findOccurrances(new int[]{3, 5, 5, 5, 5, 7, 8, 8}, 6));
    System.out.println(sol.findOccurrances(new int[]{3, 5, 5, 5, 5, 7, 8, 8}, 5));
    System.out.println(sol.findOccurrances(new int[]{3, 5, 5, 5, 6, 6, 7, 8, 8}, 5));
  }
}