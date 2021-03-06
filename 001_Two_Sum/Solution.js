/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var hash = {};

    for(let i = 0; i < nums.length; i ++) {
        if(hash[target - nums[i]] !== undefined) {
            return [hash[target - nums[i]], i]
        }
        hash[nums[i]] = i
    }
};

// SOLUTION 1
// var twoSum = function(nums, target) {
//     var hash = {};
    
//     for(var i = 0; i < nums.length; i++) {
//         var num = nums[i];
//         if(hash[num] !== undefined) {
//             return [hash[num], i]
//         } else {
//             hash[target - num] = i;
//         }
//     }
    
//     return [];
// };
