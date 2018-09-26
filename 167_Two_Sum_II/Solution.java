// Author: Code-Beast

// MY SOLUTION 1 (Using Double Pointers)
// Runtime: 0ms
class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	// Define left pointer and right pointer
        int left = 0, right = numbers.length - 1;

        // Loop until the solution is found
        while (left < right) {
	        // If the sum is less than the target, increase left by 1
	        if (numbers[left] + numbers[right] < target) {
	        	left ++;
	        }
	        // else if the sum is larger than the target, reduce right by 1
	        else if (numbers[left] + numbers[right] > target) {
	        	right --;
	        }
	        // else return left and right
	        else {
	        	return new int[] {left + 1, right + 1};
	        }
        }
        return null;
    }

    public static void main(String[] args) {
    	int[] numbers = new int[] {2, 7, 11, 15};
    	System.out.println(new Solution().twoSum(numbers, 9)[1]);
    }
}