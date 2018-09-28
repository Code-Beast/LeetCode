// Author: Code-Beast

// MY SOLUTION 1
class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0;

        for (int num : nums) {
        	if (num == majority) {
        		count ++;
        	} else {
        		if (count == 0) {
        			majority = num;
        			count ++;
        		} else {
        			count --;
        		}
        	}
        }

        return majority;
    }
}