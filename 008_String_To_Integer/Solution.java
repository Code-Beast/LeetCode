// Author: Code-Beast

class Solution {
    public int myAtoi(String str) {
    	// Handle empty string
    	if (str.length() == 0) {
    		return 0;
    	}
    	
    	// The first character of the original string
    	char firstChar = str.charAt(0);

    	// Delete Spaces
		int count = 0;
		if (firstChar == ' ') {
			for (int i = 0; i < str.length(); i ++) {
				if (str.charAt(i) == ' ') {
					count ++;
				} else {
					break;
				}
			}
		}
		str = str.substring(count, str.length());

		// The first character of the string without starting spaces
    	if (str.length() == 0) {
    		return 0;
    	}
		firstChar = str.charAt(0);

		// If string starts with "+" or "-", read the sign
		int sign = 1;
		if (firstChar == '+') {
			str = str.substring(1, str.length());
		} else if (firstChar == '-') {
			sign = -1;
			str = str.substring(1, str.length());
		}

    	// The first character of the string without starting spaces and starting sign
    	if (str.length() == 0) {
    		return 0;
    	}
    	firstChar = str.charAt(0);

    	// Read the number or return 0
    	int num = 0;
    	if (firstChar <= 57 && firstChar >= 48)	{
    		for (int i = 0; i < str.length(); i ++) {
    			char ch = str.charAt(i);
    			if (ch <= 57 && ch >= 48) {
    				int newNum = num * 10 + (ch - '0');

    				// Handle overflows
    				if (num < 0 && newNum > 0 || num > 0 && newNum < 0 || (newNum - (ch - '0')) / 10 != num) {
    					return sign == 1 ? 2147483647 : -2147483648;
    				}

    				num = newNum;
    			} else {
    				break;
    			}
    		}
    		return num * sign;
    	} else {
    		// If no number detected, return 0
    		return 0;
    	}

    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.myAtoi("  0000000000012345678") == 12345678);
    	System.out.println(sol.myAtoi("  00000000000000000000042") == 42);
    	System.out.println(sol.myAtoi("   -42") == -42);
    	System.out.println(sol.myAtoi("4193 with words") == 4193);
    	System.out.println(sol.myAtoi("words and 987") == 0);
		System.out.println(sol.myAtoi("-91283472332") == -2147483648);
		System.out.println(sol.myAtoi("2147483648") == 2147483647);
    }
}