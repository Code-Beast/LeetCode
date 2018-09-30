// Author: Cocde-Beast

// MY SOLUTION 1 (Using Boyer-Moore Voting Algorithm)
// Delete three different numbers each time, the remaining numbers at the end are numbers that appears more than 1/3 times.
// Runtime: 1ms
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> majorities = new ArrayList<>();

    	int majority1 = 0, majority2 = 1, count1 = 0, count2 = 0;

    	for (int num : nums) {
    		if (num == majority1) {
    			count1 ++;
    		} else if (num == majority2) {
    			count2 ++;
    		} else if (count1 == 0) {
    			majority1 = num;
    			count1 = 1;
    		} else if (count2 == 0) {
    			majority2= num;
    			count2 = 1;
    		} else {
    			count1 --;
    			count2 --;
    		}
    	}

    	count1 = 0;
    	count2 = 0;

    	for (int num : nums) {
    		if (num == majority1) count1 ++;
    		if (num == majority2) count2 ++;
    	}

    	if (count1 > nums.length / 3) majorities.add(majority1);
    	if (count2 > nums.length / 3) majorities.add(majority2);

    	return majorities;
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}