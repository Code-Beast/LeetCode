#!python3
# Author: Code-Beast

# MY SOLUTION 3 (Dynamic Programming, Best Solution)
class Solution:
    def isMatch(self, s, pattern):
        """
        :type s: str
        :type p: str
        :rtype: bool

        >>> sol = Solution().isMatch
        >>> sol("aa", "a")
        False
        >>> sol("aa", "a*")
        True
        >>> sol("ab", ".*")
        True
        >>> sol("aab", "c*a*b")
        True
        >>> sol("mississippi", "mis*is*p*")
        False
        >>> sol("aaaaab", "a*aab")
        True
        >>> sol("aaaaab", "a.*ab")
        True
        >>> sol("abcdabcdabcd", "a.*dab.*d")
        True
        >>> sol("ab", ".*c")
        False
        """
        memo = {}

        def isMatchHelper(sStart, patternStart):
            # Handling memorized matching result:
            if (sStart, patternStart) in memo:
                return memo[(sStart, patternStart)]

            # Handle empty string
            elif len(pattern) == patternStart:
                ans = (len(s) == sStart)

            # Handle successful matching
            elif len(s) - sStart >= 1 and (s[sStart] == pattern[patternStart] or pattern[patternStart] == '.'):
                if len(pattern) - patternStart >= 2 and pattern[patternStart + 1] == '*':
                    ans = isMatchHelper(sStart, patternStart + 2) or isMatchHelper(sStart + 1, patternStart)
                else:
                    ans = isMatchHelper(sStart + 1, patternStart + 1)

            # Handle repeating
            elif len(pattern) - patternStart >= 2 and pattern[patternStart + 1] == '*':
                ans = isMatchHelper(sStart, patternStart + 2)

            # Handle matching failures
            else:
                ans = False

            memo[(sStart, patternStart)] = ans
            return ans

        return isMatchHelper(0, 0)


# # MY SOLUTION 2 (Index Passing)
# class Solution:
#     def isMatch(self, s, pattern):
#         """
#         :type s: str
#         :type p: str
#         :rtype: bool

#         >>> sol = Solution().isMatch
#         >>> sol("aa", "a")
#         False
#         >>> sol("aa", "a*")
#         True
#         >>> sol("ab", ".*")
#         True
#         >>> sol("aab", "c*a*b")
#         True
#         >>> sol("mississippi", "mis*is*p*")
#         False
#         >>> sol("aaaaab", "a*aab")
#         True
#         >>> sol("aaaaab", "a.*ab")
#         True
#         >>> sol("abcdabcdabcd", "a.*dab.*d")
#         True
#         >>> sol("ab", ".*c")
#         False
#         """
#         def isMatchHelper(sStart, patternStart):
#             # Handle empty string
#             if len(pattern) == patternStart: 
#                 return len(s) == sStart

#             # Handle successful matching
#             elif len(s) - sStart >= 1 and (s[sStart] == pattern[patternStart] or pattern[patternStart] == '.'):
#                 if len(pattern) - patternStart >= 2 and pattern[patternStart + 1] == '*':
#                     return isMatchHelper(sStart, patternStart + 2) or isMatchHelper(sStart + 1, patternStart)
#                 else:
#                     return isMatchHelper(sStart + 1, patternStart + 1)

#             # Handle repeating
#             elif len(pattern) - patternStart >= 2 and pattern[patternStart + 1] == '*':
#                 return isMatchHelper(sStart, patternStart + 2)

#             # Handle matching failures
#             else:
#                 return False

#         return isMatchHelper(0, 0)



# # Official Solution
# class Solution(object):
#     def isMatch(self, text, pattern):
#         if not pattern:
#             return not text

#         first_match = bool(text) and pattern[0] in {text[0], '.'}

#         if len(pattern) >= 2 and pattern[1] == '*':
#             return (self.isMatch(text, pattern[2:]) or
#                     first_match and self.isMatch(text[1:], pattern))
#         else:
#             return first_match and self.isMatch(text[1:], pattern[1:])



# # MY SOLUTION 1 (Recursion)
# class Solution:
#     def isMatch(self, s, pattern):
#         """
#         :type s: str
#         :type p: str
#         :rtype: bool

#         >>> sol = Solution().isMatch
#         >>> sol("aa", "a")
#         False
#         >>> sol("aa", "a*")
#         True
#         >>> sol("ab", ".*")
#         True
#         >>> sol("aab", "c*a*b")
#         True
#         >>> sol("mississippi", "mis*is*p*")
#         False
#         >>> sol("aaaaab", "a*aab")
#         True
#         >>> sol("aaaaab", "a.*ab")
#         True
#         >>> sol("abcdabcdabcd", "a.*dab.*d")
#         True
#         >>> sol("ab", ".*c")
#         False
#         """
#         # Handle empty string
#         if len(pattern) == 0: 
#             return len(s) == 0

#         # Handle successful matching
#         elif len(s) >= 1 and (s[0] == pattern[0] or pattern[0] == '.'):
#             if len(pattern) >= 2 and pattern[1] == '*':
#                 return self.isMatch(s, pattern[2 :]) or self.isMatch(s[1 :], pattern)
#             else:
#                 return self.isMatch(s[1 :], pattern[1 :])

#         # Handle repeating
#         elif len(pattern) >= 2 and pattern[1] == '*':
#             return self.isMatch(s, pattern[2 :])

#         # Handle matching failures
#         else:
#             return False

