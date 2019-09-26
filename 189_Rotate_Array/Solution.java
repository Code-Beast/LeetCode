// Because it is allowed to shift the array with an offset larger than the length of the array
// We need to use MOD operation to get the net offset

// Solution 1: System.arraycopy()
// Runtime: 0ms
// Space: O(n)
class Solution {
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    int[] rotatedNums = new int[n];
    k = k % n;
    
    System.arraycopy(nums, n - k, rotatedNums, 0, k);
    System.arraycopy(nums, 0, rotatedNums, k, n - k);
    System.arraycopy(rotatedNums, 0, nums, 0, n);
  }
}



// Solution 2: System.arraycopy()
// Runtime: 0ms
// Space: O(k)
class Solution {
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    int[] numsPutFront = new int[k];
    
    System.arraycopy(nums, n - k, numsPutFront, 0, k);
    System.arraycopy(nums, 0, nums, k, n - k);
    System.arraycopy(numsPutFront, 0, nums, 0, k);
  }
}



// Solution 3: 