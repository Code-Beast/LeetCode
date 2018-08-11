#!python3
# Author: Code-Beast

# MY SOLUTION 2 (Iteration with dict)
class Solution:
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str

        >>> intToRoman = Solution().intToRoman
        >>> intToRoman(3)
        'III'
        >>> intToRoman(4)
        'IV'
        >>> intToRoman(1994)
        'MCMXCIV'
        """
        romanMap = {1: ['I', 'X', 'C', 'M'], 5: ['V', 'L', 'D']}
        level = 0
        roman = ''

        while num > 0:
            num, remainder = num // 10, num % 10
            if remainder == 9:
                roman += romanMap[1][level + 1] + romanMap[1][level]
            elif remainder < 9 and remainder >= 5:
                for i in range(remainder - 5):
                    roman += romanMap[1][level]
                roman += romanMap[5][level]
            elif remainder == 4:
                roman += romanMap[5][level] + romanMap[1][level]
            elif remainder < 4:
                for i in range(remainder):
                    roman += romanMap[1][level]
            level += 1

        return roman[:: -1]



# # MY SOLUTION 2 (Recursion with 2D list)
# class Solution:
#     def intToRoman(self, num):
#         """
#         :type num: int
#         :rtype: str

#         >>> intToRoman = Solution().intToRoman
#         >>> intToRoman(3)
#         'III'
#         >>> intToRoman(4)
#         'IV'
#         >>> intToRoman(1994)
#         'MCMXCIV'
#         """
        # romanMap = [['I', 'X', 'C', 'M'], ['V', 'L', 'D']]

        # def intToRomanHelper(num, level):
        #     if num == 9:
        #         return romanMap[0][level] + romanMap[0][level + 1]
        #     elif num < 9 and num >= 5:
        #         res = romanMap[1][level]
        #         for i in range(num - 5):
        #             res += romanMap[0][level]
        #         return res
        #     elif num == 4:
        #         return romanMap[0][level] + romanMap[1][level]
        #     elif num < 4:
        #         res = ''
        #         for i in range(num):
        #             res += romanMap[0][level]
        #         return res
        #     else:
        #         return intToRomanHelper(num // 10, level + 1) + intToRomanHelper(num % 10, level)

        # return intToRomanHelper(num, 0)
        


# # MY SOLUTION 1 (Recursion with dict)
# class Solution:
#     def intToRoman(self, num):
#         """
#         :type num: int
#         :rtype: str

#         >>> intToRoman = Solution().intToRoman
#         >>> intToRoman(3)
#         'III'
#         >>> intToRoman(4)
#         'IV'
#         >>> intToRoman(1994)
#         'MCMXCIV'
#         """
#         romanMap = {1: ['I', 'X', 'C', 'M'], 5: ['V', 'L', 'D']}

#         def intToRomanHelper(num, level):
#             if num == 9:
#                 return romanMap[1][level] + romanMap[1][level + 1]
#             elif num < 9 and num >= 5:
#                 res = romanMap[5][level]
#                 for i in range(num - 5):
#                     res += romanMap[1][level]
#                 return res
#             elif num == 4:
#                 return romanMap[1][level] + romanMap[5][level]
#             elif num < 4:
#                 res = ''
#                 for i in range(num):
#                     res += romanMap[1][level]
#                 return res
#             else:
#                 return intToRomanHelper(num // 10, level + 1) + intToRomanHelper(num % 10, level)

#         return intToRomanHelper(num, 0)