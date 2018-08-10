// Author: Code-Beast

class Solution {
    public boolean isPalindrome(int x) {
        // Handle negative numbers
        if (x < 0) return false;

        // Get the number of digits of x
        int xCopy = x,
            numOfDigits = 0;
        while (xCopy != 0) {
            numOfDigits ++;
            xCopy /= 10;
        }

        // Get the reversed half part of the number
        int reversedHalf = 0;
        for (int i = 0; i < Math.floor(numOfDigits / 2); i ++) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Get the other half part
        if (numOfDigits % 2 != 0) x /= 10;

        return x == reversedHalf;
    }
}