// Author: Code-Beast

// MY SOLUTION 1 (Iteraiton)
// Runtime: 11ms
class Solution {
    public void nextPermutation(int[] nums) {
        
        int length = nums.length;

        // Handle boundary conditions
        if (length == 0 || length == 1) {
            return;
        }

        // Iteration
        int i = length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i --;

        if (i >= 0) {
            int j = i + 1;
            while (j < length) {
                if (nums[j] <= nums[i]) break;
                j ++;
            }

            swap(nums, i, j - 1);
        } 
        
        reverse(nums, i + 1);
        
        return;
    }
    
    // Define reverse function
    private void reverse (int[] nums, int start) {
        for (int i = 0; i <  (nums.length - (start)) / 2; i ++) {
            swap(nums, start + i, nums.length - 1 - i);
        }
    }

    // Define swap function
    private void swap (int[] nums, int idx1, int idx2) {
        int temp = nums[idx2];
        nums[idx2] = nums[idx1];
        nums[idx1] = temp;
    }
}