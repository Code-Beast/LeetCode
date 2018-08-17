// Author: Code-Beast

// MY SOLUTION 1 (Binary Search)
// Runtime: 52ms
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let left = 0,
        right = nums.length - 1;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (nums[mid] === target) {
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
};