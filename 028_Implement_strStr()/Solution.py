#!python3
# Author: Code-Beast

# SOLUTION CITED FROM
# https://leetcode.com/problems/implement-strstr/discuss/12814/My-answer-by-Python
# Runtime: 36ms
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        for i in range(len(haystack) - len(needle)+1):
            if haystack[i:i+len(needle)] == needle:
                return i
        return -1



# # MY SOLUTION 1
# # Runtime: 40ms
# class Solution:
#     def strStr(self, haystack, needle):
#         """
#         :type haystack: str
#         :type needle: str
#         :rtype: int
#         """
#         lenNeedle = len(needle)
#         lenHaystack = len(haystack)
        
#         # Handle searching for an empty string
#         if lenNeedle == 0:
#             return 0
        
#         # Handle a longer string to search for than the string to search
#         if lenHaystack < lenNeedle:
#             return -1
        
#         j = 0
#         for i in range(lenHaystack - lenNeedle + 1):
#             if haystack[i] == needle[j]:
#                 test = i
#                 while test < lenHaystack and j < lenNeedle and haystack[test] == needle[j]:
#                     test += 1
#                     j += 1
#                 if j == lenNeedle:
#                     return i
#                 j = 0
            
#         return -1