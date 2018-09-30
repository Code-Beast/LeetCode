#!python3

# # MY SOLUTION 6 (Binary Search and Divide And Conquer)
# class Solution:
#     def longestCommonPrefix(self, strs):
#         """
#         :type strs: List[str]
#         :rtype: str

#         >>> longestCommonPrefix = Solution().longestCommonPrefix
#         >>> longestCommonPrefix(["flower","flow","flight"])
#         'fl'
#         >>> longestCommonPrefix(["dog","racecar","car"])
#         ''
#         >>> longestCommonPrefix(["aa", "ab"])
#         'a'
#         """
#         if len(strs) == 0:
#             return ""

#         if len(strs) == 1:
#             return strs[0]

#         if len(strs) == 2:
#             commonPrefix = strs[0]
#             left = 0
#             right = len(commonPrefix)

#             while left < right - 1:
#                 mid = (left + right) // 2
#                 if strs[1].startswith(commonPrefix[: mid]):
#                     left = mid
#                 else:
#                     right = mid - 1
#             return  commonPrefix[: right] if strs[1].startswith(commonPrefix[: right]) else commonPrefix[: left]
#         return self.longestCommonPrefix([self.longestCommonPrefix(strs[: len(strs) // 2]), self.longestCommonPrefix(strs[len(strs) // 2 :])])



# MY SOLUTION 5 (Binary Search)
# class Solution:
#     def longestCommonPrefix(self, strs):
#         """
#         :type strs: List[str]
#         :rtype: str

#         >>> longestCommonPrefix = Solution().longestCommonPrefix
#         >>> longestCommonPrefix(["flower","flow","flight"])
#         'fl'
#         >>> longestCommonPrefix(["dog","racecar","car"])
#         ''
#         >>> longestCommonPrefix(["aa", "ab"])
#         'a'
#         """
#         def isCommonPrefix(strs, length):
#             commonPrefix = strs[0][0: length];
#             for i in range(1, len(strs)):
#                 if not strs[i].startswith(commonPrefix):
#                     return False
#             return True

#         if len(strs) == 0: return ""

#         minLen = len(strs[0])
#         for string in strs:
#             minLen = min(minLen, len(string))
        
#         low, high = 1, minLen

#         while low <= high:
#             middle = (low + high) // 2
#             if isCommonPrefix(strs, middle):
#                 low = middle + 1;
#             else:
#                 high = middle - 1;
        
#         return strs[0][: (low + high) // 2];


# # MY SOLUTION 4 (Divide And Conquer)
# class Solution:
#     def longestCommonPrefix(self, strs):
#         """
#         :type strs: List[str]
#         :rtype: str

#         >>> longestCommonPrefix = Solution().longestCommonPrefix
#         >>> longestCommonPrefix(["flower","flow","flight"])
#         'fl'
#         >>> longestCommonPrefix(["dog","racecar","car"])
#         ''
#         >>> longestCommonPrefix(["aa", "ab"])
#         'a'
#         """
#         if len(strs) == 0:
#             return ""

#         if len(strs) == 1:
#             return strs[0]

#         if len(strs) == 2:
#             commonPrefix = strs[0]
#             while not strs[1].startswith(commonPrefix):
#                 commonPrefix = commonPrefix[: len(commonPrefix) - 1]
#             return commonPrefix
#         return self.longestCommonPrefix([self.longestCommonPrefix(strs[: len(strs) // 2]), self.longestCommonPrefix(strs[len(strs) // 2 :])])



# # MY SOLUTION 3 (Horizontal Scanning with str.find())
# class Solution:
#     def longestCommonPrefix(self, strs):
#         """
#         :type strs: List[str]
#         :rtype: str

#         >>> longestCommonPrefix = Solution().longestCommonPrefix
#         >>> longestCommonPrefix(["flower","flow","flight"])
#         'fl'
#         >>> longestCommonPrefix(["dog","racecar","car"])
#         ''
#         >>> longestCommonPrefix(["aa", "ab"])
#         'a'
#         """
#         if len(strs) == 0:
#           return ""

#         commonPrefix = strs[0]

#         for i in range(1, len(strs)):
#           while strs[i].find(commonPrefix) != 0:
#               commonPrefix = commonPrefix[: len(commonPrefix) - 1]

#         return commonPrefix



# # MY SOLUTION 2 (Horizontal Scanning with str.startswith())
# class Solution:
#     def longestCommonPrefix(self, strs):
#         """
#         :type strs: List[str]
#         :rtype: str

#         >>> longestCommonPrefix = Solution().longestCommonPrefix
#         >>> longestCommonPrefix(["flower","flow","flight"])
#         'fl'
#         >>> longestCommonPrefix(["dog","racecar","car"])
#         ''
#         >>> longestCommonPrefix(["aa", "ab"])
#         'a'
#         """
#         if len(strs) == 0:
#           return ""

#         commonPrefix = strs[0]

#         for i in range(1, len(strs)):
#           while not strs[i].startswith(commonPrefix):
#               commonPrefix = commonPrefix[: len(commonPrefix) - 1]

#         return commonPrefix



# # MY SOLUTION 1 (Vertical Scanning)
# class Solution:
#     def longestCommonPrefix(self, strs):
#         """
#         :type strs: List[str]
#         :rtype: str

#         >>> longestCommonPrefix = Solution().longestCommonPrefix
#         >>> longestCommonPrefix(["flower","flow","flight"])
#         'fl'
#         >>> longestCommonPrefix(["dog","racecar","car"])
#         ''
#         """
#         if len(strs) == 0: return ""

#         commonPrefix = ""
#         for currentIdx, currentChar in enumerate(strs[0]):
#           for i in range(1, len(strs)):
#               if len(strs[i]) == currentIdx or strs[i][currentIdx] != currentChar:
#                   return commonPrefix
#           commonPrefix += currentChar

#         return strs[0]
