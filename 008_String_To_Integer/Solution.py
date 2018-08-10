#!python3
# Author: Code-Beast

class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        # Handle empty string
        if len(str) == 0:
            return 0
        

        # The first character of the original string
        firstChar = str[0]

        # Delete Spaces
        count = 0
        if firstChar == ' ':
            for i in range(len(str)):
                if str[i] == ' ':
                    count += 1
                else:
                    break

        str = str[count :]

        # The first character of the string without starting spaces
        if len(str) == 0:
            return 0
        firstChar = str[0];

        # If string starts with "+" or "-", read the sign
        sign = 1;
        if firstChar == '+':
            str = str[1 :]
        elif firstChar == '-':
            sign = -1
            str = str[1 :]

        # The first character of the string without starting spaces and starting sign
        if len(str) == 0:
            return 0
        firstChar = str[0]

        # Read the number or return 0
        num = 0
        if firstChar <= "9" and firstChar >= "0":
            for i in range(len(str)):
                ch = str[i]
                if ch <= "9" and ch >= "0":
                    num = num * 10 + (int(ch) - 0)
                else:
                    break
            signedNum = num * sign;
            
            # Handle overflows
            if signedNum > 2147483647: return 2147483647
            if signedNum < -2147483648: return -2147483648
            
            return num * sign
        else:
            # If no number detected, return 0
            return 0

if __name__ == "__main__":
    print(Solution().myAtoi("42"))