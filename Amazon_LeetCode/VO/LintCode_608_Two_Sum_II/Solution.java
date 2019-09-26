public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        // corner case: no 
        // time: no 
        // space: no 
        
        /**
         * left -> 0, right -> length - 1
         * sum = *left + *right
         * cases:
         *  1. sum < target => left ++
         *  2. sum > target => right --
         *  3. sum == target => output (+1 for indices)
         */
         
        int left = 0, right = nums.length - 1;
         
        while (left < right) {
            int sum = nums[left] + nums[right];
             
            if (sum < target) {
                left ++;
            } else if (sum > target) {
                right --;
            } else {
                break;
            }
        }
        
        return new int[]{left + 1, right + 1};
    }
}
