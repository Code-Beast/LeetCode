// Author: Code-Beast

// SOLUTION (Recursion) CITED FROM
// https://leetcode.com/problems/divide-two-integers/discuss/13417/No-Use-of-Long-Java-Solution
// Runtime: 22ms
public class Solution {
    public int divide(int dividend, int divisor) {
        // Handle special situation
		if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        
        // Four conditions
        if(dividend > 0 && divisor > 0) return divideHelper(-dividend, -divisor);
        else if(dividend > 0) return -divideHelper(-dividend, divisor);
        else if(divisor > 0) return -divideHelper(dividend, -divisor);
        else return divideHelper(dividend, divisor);
    }
    
    private int divideHelper(int dividend, int divisor){
        // Base case
        if(divisor < dividend) return 0;
        // Get highest digit of divisor
        int cur = 0, res = 0;
        while((divisor << cur) >= dividend && (divisor << cur) < 0 && cur < 31) cur ++;
        res = dividend - (divisor << cur - 1);
        if(res > divisor) return 1 << cur - 1;
        return (1 << cur-1)+divide(res, divisor);
    }
}