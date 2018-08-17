// Author: Code-Beast

// MY SOLUTION 1 (Binary Search)
// Runtime: 8ms
class Solution {
    public int search(int[] nums, int target) {
        int left = 0,
            right = nums.length - 1,
            mid = 0;
            
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (nums[mid] <= nums[right] && nums[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target < nums[left] && nums[left] <= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}