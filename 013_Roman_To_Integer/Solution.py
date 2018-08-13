# Author: Code-Beast

# Another Solution Cited From: https://leetcode.com/problems/roman-to-integer/discuss/6537/My-Straightforward-Python-Solution

class Solution:
    # @param {string} s
    # @return {integer}
    def romanToInt(self, s):
        roman = {'M': 1000,'D': 500 ,'C': 100,'L': 50,'X': 10,'V': 5,'I': 1}
        z = 0
        for i in range(0, len(s) - 1):
            if roman[s[i]] < roman[s[i+1]]:
                z -= roman[s[i]]
            else:
                z += roman[s[i]]
        return z + roman[s[-1]]



# # MY SOLUTION 2
# class Solution:
#     def romanToInt(self, string):
#         """
#         :type s: string
#         :rtype: int

#         >>> romanToInt = Solution().romanToInt
#         >>> romanToInt("III")
#         3
#         >>> romanToInt("IV")
#         4
#         >>> romanToInt("IX")
#         9
#         >>> romanToInt("LVIII")
#         58
#         >>> romanToInt("MCMXCIV")
#         1994
#         """
#         romanMap = {"I": (1, 1), "V": (5, 5), "X": (10, 1), "L": (50, 5), "C": (100, 1), "D": (500, 5), "M": (1000, 1)}

#         idx = num = 0

#         while idx < len(string):
#             char = string[idx]
#             (value, digit) = romanMap[char]
#             if digit == 1:
#                 if idx < len(string) - 1 and (romanMap[string[idx + 1]][0] == 5 * value or romanMap[string[idx + 1]][0] == 10 * value):
#                     num, idx = num + (romanMap[string[idx + 1]][0] - value), idx + 2
#                 else: 
#                     count = 0
#                     while idx < len(string) and string[idx] == char:
#                         count, idx = count + 1, idx + 1
#                     num += count * value
#             else:
#                 num, idx = num + value, idx + 1
#         return num



# # MY SOLUTION 1
# class Solution:
#     def romanToInt(self, string):
#         """
#         :type s: string
#         :rtype: int

#         >>> romanToInt = Solution().romanToInt
#         >>> romanToInt("III")
#         3
#         >>> romanToInt("IV")
#         4
#         >>> romanToInt("IX")
#         9
#         >>> romanToInt("LVIII")
#         58
#         >>> romanToInt("MCMXCIV")
#         1994
#         """
#         digitMap = [["I", "X", "C", "M"], ["V", "L", "D"]]
#         romanMap = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}

#         idx = num = 0

#         while idx < len(string):
#             char = string[idx]
#             if char in digitMap[0]:
#                 if idx < len(string) - 1 and (romanMap[string[idx + 1]] == 5 * romanMap[char] or romanMap[string[idx + 1]] == 10 * romanMap[char]):
#                     num, idx = num + (romanMap[string[idx + 1]] - romanMap[char]), idx + 2
#                 else: 
#                     count = 0
#                     while idx < len(string) and string[idx] == char:
#                         count, idx = count + 1, idx + 1
#                     num += count * romanMap[char]
#             else:
#                 num, idx = num + romanMap[char], idx + 1
#         return num
