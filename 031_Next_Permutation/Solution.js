// Author: Code-Beast

// MY SOLUTION 1 (Iteraiton)
// Runtime: 64ms
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
    let length = nums.length;

    // Define reverse function
    let reverse = function(start) {
        for (let i = 0; i <  Math.floor((length - (start)) / 2); i ++) {
            swap(start + i, length - 1 - i);
        }
    };

    // Define swap function
    let swap = function(idx1, idx2) {
        let temp = nums[idx2];
        nums[idx2] = nums[idx1];
        nums[idx1] = temp;
    };

    // Handle boundary conditions
    if (length === 0 || length === 1) {
        return;
    }

    // Iteration
    let i = length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) i --;

    if (i >= 0) {
        let j = i + 1;
        while (j < length) {
            if (nums[j] <= nums[i]) break;
            j ++;
        }

        swap(i, j - 1);
        reverse(i + 1);
    } else {
        reverse(0);
    }

    return;
};