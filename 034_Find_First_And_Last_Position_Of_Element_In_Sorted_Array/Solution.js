// Author: Code-Beast

// MY SOLUTION 1 (Two binary searches)
// Runtime: 56ms
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    // Binary search start
    let left = 0,
        mid = 0,
        right = nums.length - 1,
        start = -1;
    while (left <= right) {
        mid = Math.floor((left + right) / 2);
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
    let end = -1;
    while (left <= right) {
        mid = Math.floor((left + right) / 2);
        if (nums[mid] < target) left = mid + 1;
        else if (nums[mid] > target) right = mid - 1;
        else {
            end = mid;
            left = mid + 1;
        }
    }

    return [start, end];
};