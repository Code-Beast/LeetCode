// Author: Code-Beast

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
    let NSum = function(nums, target, N, lastNums, res) {
        if (nums.length < N || N < 2 || target < nums[0] * N || target > nums[-1] * N) {
            return;
        }

        if (N === 2) {
            let left = 0,
                right = nums.length - 1;
            while (left < right) {
                let sumTwo = nums[left] + nums[right]
                if (sumTwo > target) {
                    // while left < right and nums[right] == nums[right - 1]:
                    //     right -= 1
                    right --;
                } else if (sumTwo < target) {
                    // while left < right and nums[left] == nums[left + 1]:
                    //     left += 1
                    left ++;
                } else {
                    newLastNums = Array.from(lastNums);
                    newLastNums.push(nums[left], nums[right]);
                    res.push(newLastNums);

                    while (left < right && nums[left] === nums[left + 1]) {
                        left ++;
                    }
                    left ++;

                    while (left < right && nums[right] === nums[right - 1]) {
                        right --;
                    }
                    right --;
                }
            }
            return;
        }

        for (let idx = 0; idx <= nums.length - N; idx ++) {
            if (idx === 0 || idx > 0 && nums[idx] != nums[idx - 1]) {
                newLastNums = Array.from(lastNums);
                newLastNums.push(nums[idx]);
                NSum(nums.slice(idx + 1), target - nums[idx], N - 1, newLastNums, res);
            }
        }

        return;
    };

    let res = [];
    NSum(nums.sort(function(a, b) {return a - b;}), target, 4, [], res);
    return res;
};

console.log(fourSum([1, 0, -1, 2, -1, 4, -2, 0, -2, 2], 0))