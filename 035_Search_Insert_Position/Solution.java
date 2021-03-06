// Author: Code-Beast

// MY SOLUTION 1 (Binary search)
// Runtime: 3ms
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;

        int left = 0,
            right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
        }
        return nums[left] >= target ? left : left + 1;
    }
}
