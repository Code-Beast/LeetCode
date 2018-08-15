// Author: Code-Beast

// MY SOLUTION 1 (Two pointers: when elements to remove are rare)
// Note: the order of elements could be changed
// Runtime: 52ms
/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    let i = 0,
        length = nums.length;
    while (i < length) {
        if (nums[i] === val) {
            nums[i] = nums[length - 1];
            length --;
        } else {
            i ++;
        }
    }
    return length;
};