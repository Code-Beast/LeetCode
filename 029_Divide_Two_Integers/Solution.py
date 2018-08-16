#!python3
# Author: Code-Beast

"""
Problem Description:
    Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
    Return the quotient after dividing dividend by divisor.
    The integer division should truncate toward zero.
"""

# MY SOLUTION 2 (Double by bit left shifting)
# Runtime: 52ms
class Solution:
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        if divisor == 0:
            return 2147483647

        if dividend == 0:
            return 0
        
        quotient = 0
        isPositive = (dividend > 0) == (divisor > 0)
        dividend, divisor = abs(dividend), abs(divisor)
        while dividend - divisor >= 0:
            multiple = 1
            multiDivisor = divisor
            while dividend - multiDivisor >= 0:
                dividend -= multiDivisor
                quotient += multiple
                multiDivisor << 1
                multiple << 1
                
        quotient = quotient if isPositive else -quotient

        return max(min(quotient, 2147483647), -2147483648)



# # MY SOLUTION 1 (Double by plus)
# # Runtime: 52ms
# class Solution:
#     def divide(self, dividend, divisor):
#         """
#         :type dividend: int
#         :type divisor: int
#         :rtype: int
#         """
#         if divisor == 0:
#             return 2147483647

#         if dividend == 0:
#             return 0
        
#         quotient = 0
#         isPositive = (dividend > 0) == (divisor > 0)
#         dividend, divisor = abs(dividend), abs(divisor)
#         while dividend - divisor >= 0:
#             multiple = 1
#             multiDivisor = divisor
#             while dividend - multiDivisor >= 0:
#                 dividend -= multiDivisor
#                 quotient += multiple
#                 multiDivisor += multiDivisor
#                 multiple += multiple
                
#         quotient = quotient if isPositive else -quotient

#         return max(min(quotient, 2147483647), -2147483648)

