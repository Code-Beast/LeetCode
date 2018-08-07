#!python3
class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str

        >>> Solution().longestPalindrome("babad")
        'aba'
        >>> Solution().longestPalindrome("cbbd")
        'bb'
        >>> Solution().longestPalindrome("acbaddabacd")
        'baddab'
        >>> Solution().longestPalindrome("bbbabbbabbb")
        'bbbabbbabbb'
        >>> Solution().longestPalindrome("ac")
        'c'
        """
        longestPal = ""
        if len(s) == 1:
            return s

        for i in range(len(s)):
            if i > 0:
                res = self.findLongestPalindrome(s, 1, i - 1, i + 1)
                if len(longestPal) <= res[0]:
                    longestPal = res[1]

            if i >= 0:
                res = self.findLongestPalindrome(s, 0, i, i + 1)
                if len(longestPal) <= res[0]:
                    longestPal = res[1]

        return longestPal
    
    def findLongestPalindrome(self, s, length, idxLeft, idxRight) :
        while idxLeft >= 0 and idxRight < len(s):
            if s[idxLeft] != s[idxRight]:
                break
            length += 2
            idxLeft -= 1
            idxRight += 1
        return length, s[idxLeft + 1: idxRight]