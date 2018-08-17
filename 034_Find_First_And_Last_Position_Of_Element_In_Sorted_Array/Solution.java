// Author: Code-Beast

// MY SOLUTION 1 (Two binary searches)
// Runtime: 4ms
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0,
            mid = 0,
            right = nums.length - 1,
            start = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else {
                start = mid;
                right = mid - 1;
            }
        }

        // Binary search end
        left = 0;
        mid = 0;
        right = nums.length - 1;
        int end = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else {
                end = mid;
                left = mid + 1;
            }
        }

        int[] res = new int[]{start, end};
        return res;
    }
}