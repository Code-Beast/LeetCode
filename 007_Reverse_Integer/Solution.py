#!python3
# Author: Code-Beast

# MY SOLUTION 3 (no need to store the sign)
# The Best Solution Is Solution 2, Becasue math.floor() and math.ceil() are time-consuming
import math

class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int

        >>> Solution().reverse(123)
        321
        >>> Solution().reverse(-123)
        -321
        >>> Solution().reverse(120)
        21
        """

        # Reverse the absolute value
        res = 0
        while x:
        	newX = math.floor(x / 10) if x > 0 else math.ceil(x / 10)
        	res = res * 10 + x - newX * 10
        	x = newX

        # Handle overflows
        if res < -pow(2, 31) or res >= pow(2, 31):
        	return 0

        return res

def main():
	sol = Solution()
	assert(sol.reverse(-321) == -123)

if __name__ == "__main__":
	main()


# # MY SOLUTION 2
# class Solution:
#     def reverse(self, x):
#         """
#         :type x: int
#         :rtype: int

#         >>> Solution().reverse(123)
#         321
#         >>> Solution().reverse(-123)
#         -321
#         >>> Solution().reverse(120)
#         21
#         """
#         # Handle negative numbers
#         if x < 0:
#         	sign = -1  
#         	x = abs(x)
#         else:
#         	sign = 1

#         # Reverse the absolute value
#         res = 0
#         while x > 0:
#         	res = res * 10 + x % 10
#         	x //= 10

#         # Recover the sign
#         res *= sign

#         # Handle overflows
#         if res < -pow(2, 31) or res >= pow(2, 31):
#         	return 0

#         return res



# MY SOLUTION 1
# class Solution:
#     def reverse(self, x):
#         """
#         :type x: int
#         :rtype: int

#         >>> Solution().reverse(123)
#         321
#         >>> Solution().reverse(-123)
#         -321
#         >>> Solution().reverse(120)
#         21
#         """
#         # Handle negative numbers
#         if x < 0:
#         	sign = -1  
#         	x = abs(x)
#         else:
#         	sign = 1

#         # Cast int to string and do reverse()
#         x = str(x)[:: -1]

#         # Cast back to int
#         x = int(x)

#         # Recover its sign
#         x *= sign

#         # Handle overflows
#         if x < -pow(2, 31) or x >= pow(2, 31):
#         	return 0

#         return x