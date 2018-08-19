// Author: Code-Beast

// MY SOLUTION 1
// Runtime: 7ms
class Solution {
    public int firstMissingPositive(int[] nums) {
    	int i = 0;
        while (i < nums.length) {
        	if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
        		swap(nums, nums[i] - 1, i);
        	} else {
        		i ++;
        	}
        }

        i = 0;
        while (i < nums.length) {
        	if (nums[i] != i + 1) {
        		break;
        	}
            i ++;
        }

        return i + 1;
    }

    private void swap(int[] nums, int idx1, int idx2) {
    	int temp = nums[idx1];
    	nums[idx1] = nums[idx2];
    	nums[idx2] = temp;
    }
}