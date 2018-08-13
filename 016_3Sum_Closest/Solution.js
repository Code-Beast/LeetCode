// Author: Code-Beast

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    nums.sort(function(a, b){return a - b});
    let closest = nums[0] + nums[1] + nums[2];

    for (let i = 0; i < nums.length; i ++) {
        // Aovid repeat
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }

        // Find these trios
        let left = i + 1;
        let right = nums.length - 1;
        
        while (left < right) {
            let sumThree = nums[left] + nums[right] + nums[i];
            if (sumThree > target) {
                while (left < right && nums[right] === nums[right - 1]) {
                    right --;
                }
                right --;
            } else if (sumThree < target) {
                while (left < right && nums[left] === nums[left + 1]) {
                    left ++;
                }
                left ++;
            } else {
                return target;
            }
                
            closest = Math.abs(sumThree - target) < Math.abs(closest - target) ? sumThree : closest;
        }
    }
    
    return closest;
};