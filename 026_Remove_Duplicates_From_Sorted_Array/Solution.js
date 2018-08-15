// Author: Code-Beast

// MY SOLUTION 1 (Two Pointers)
// Runtime: 68ms
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
        let count = 0;
        for (let i = 0; i < nums.length; i ++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count ++;
            }
        }
        return count;
};