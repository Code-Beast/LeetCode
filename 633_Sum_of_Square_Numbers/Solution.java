// Author: Code-Beast

// MY SOLUTION 1 (Using Double Pointers)
// Runtime: 8ms
import java.lang.Math;

class Solution {
    public boolean judgeSquareSum(int c) {
    	// (int) cast will truncate the decimal part of the double parameter
        int left = 0, right = (int)Math.sqrt(c);

        while (left <= right) {
        	int sum = sumOfTwoSquareNums(left, right);
        	
        	if (sum < c) {
        		left ++;
        	} else if (sum > c) {
        		right --;
        	} else {
        		return true;
        	}
        }
        return false;
    }

    private int sumOfTwoSquareNums(int a, int b) {
    	return a * a + b * b;
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().judgeSquareSum(16));
    	System.out.println(new Solution().judgeSquareSum(15));
    }
}