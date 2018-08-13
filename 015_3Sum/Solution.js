// Author: Code-Beast

/**
 * @param {number[]} nums
 * @return {number[][]}
 */

var threeSum = function(nums) {
    let res = []
    nums.sort(function(a,b){return a-b})

    for (let i = 0; i < nums.length; i ++) {
        // Aovid repeat
        if (nums[i] > 0) {
            break;
        }

        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }

        // Find these trios
        let left = i + 1;
        let right = nums.length - 1;
        while (left < right) {
            let sumThree = nums[left] + nums[right] + nums[i];
            if (sumThree > 0) {
                while (left < right && nums[right] === nums[right - 1]) {
                    right --;
                }
                right --;
            } else if (sumThree < 0) {
                while (left < right && nums[left] === nums[left + 1]) {
                    left ++;
                }
                left ++;
            } else {
                res.push([nums[i], nums[left], nums[right]]);
                while (left < right && nums[left] === nums[left + 1]) {
                    left ++;
                }
                while (left < right && nums[right] === nums[right - 1]) {
                    right --;
                }
                left ++;
                right --;
            }
        }
    }

    return res;
};

console.log(threeSum([1,2,3,-1, 0, 2, -1]));