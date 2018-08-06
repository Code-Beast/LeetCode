class Solution:
    def lengthOfLongestSubstring(self, s):
        """
    	:type s: str
        :rtype: int

        >>> Solution().lengthOfLongestSubstring("abccdabcdaecabedab")
        5
        >>> Solution().lengthOfLongestSubstring("abcabcbb")
        3
        >>> Solution().lengthOfLongestSubstring("pwwkew")
        3
        >>> Solution().lengthOfLongestSubstring("bbbbbb")
        1
        """
        maxLength = 0;
        substr = "";

        for char in s:
        	if char in substr:
        		substr = substr[substr.find(char) + 1 : len(substr)]
        	substr += char
        	maxLength = max(maxLength, len(substr))
        return maxLength

# SOLUTION 1
# class Solution:
#     def lengthOfLongestSubstring(self, s):
#         maxLength, start, dic = 0, 0, {}
        
#         for idx, char in enumerate(s):
#             if char in dic and dic[char] >= start:
#                 start = dic[char] + 1
#             else:
#                 maxLength = max(maxLength, idx - start + 1)
#             dic[char] = idx
            
#         return maxLength

# SOLUTION 2
# class Solution:
#     def lengthOfLongestSubstring(self, s):
#         maxLength, start = 0, 0
        
#         for idx, char in enumerate(s):
#             pos = s.find(char, start, idx)
#             if pos != -1:
#                 start = pos + 1
#             else:
#                 maxLength = max(maxLength, idx - start + 1)
            
#         return maxLength