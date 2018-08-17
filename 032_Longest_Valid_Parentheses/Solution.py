#!python3
# Author: Code-Beast

# MY SOLUTION 3 (Two pass without extra space)
# Runtime: 80ms
class Solution:
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        
        >>> longestValidParentheses = Solution().longestValidParentheses
        >>> longestValidParentheses("(()")
        2
        >>> longestValidParentheses(")()())")
        4
        >>> longestValidParentheses("()(())")
        6
        >>> longestValidParentheses("()((()()((()))))")
        16
        >>> longestValidParentheses("(()())")
        6
        >>> longestValidParentheses("(()))())(")
        4
        """
        maxLength = 0

        # From left to right
        countOpen = countClose = 0
        i = 0
        while i < len(s):
            if s[i] == '(':
                countOpen += 1
            else:
                countClose += 1
            if countOpen == countClose:
                length = countOpen + countClose
                maxLength = length if length > maxLength else maxLength
            elif countOpen < countClose:
                countOpen = countClose = 0
            i += 1

        # From right to left
        countOpen = countClose = 0
        i = len(s) - 1
        while i >= 0:
            if s[i] == ')':
                countOpen += 1
            else:
                countClose += 1
            if countOpen == countClose:
                length = countOpen + countClose
                maxLength = length if length > maxLength else maxLength
            elif countOpen < countClose:
                countOpen = countClose = 0
            i -= 1

        return maxLength



# # MY SOLUTION 2 (Stack)
# # Runtime: 52ms
# class Solution:
#     def longestValidParentheses(self, s):
#         """
#         :type s: str
#         :rtype: int
        
#         >>> longestValidParentheses = Solution().longestValidParentheses
#         >>> longestValidParentheses("(()")
#         2
#         >>> longestValidParentheses(")()())")
#         4
#         >>> longestValidParentheses("()(())")
#         6
#         >>> longestValidParentheses("()((()()((()))))")
#         16
#         >>> longestValidParentheses("(()())")
#         6
#         >>> longestValidParentheses("(()))())(")
#         4
#         """

#         # The algorithm:
#         #
#         # We start by pushing -1 onto the stack.
#         #
#         # For every '(' encountered, we push its index onto the stack.
#         #    
#         # For every ')' encountered, 
#         #   we pop the topmost element and subtract the current element's index from the top element of the stack,
#         #   which gives the length of the currently encountered valid string of parentheses. 
#         #   If while popping the element, the stack becomes empty, we push the current element's index onto the stack. 
#         #   In this way, we keep on calculating the lengths of the valid substrings, and return the length of the longest valid string at the end.

#         stack = [-1]
#         length = 0
#         maxLength = 0
#         for i in range(len(s)):
#             if s[i] == '(':
#                 stack.append(i)
#             else:
#                 stack.pop()
#                 if len(stack) == 0:
#                     stack.append(i)
#                 length = i - stack[-1]
#                 maxLength = maxLength if maxLength >= length else length

#         return maxLength



# # MY SOLUTION 1 (Dynamic Programming)
# # Runtime: 64ms
# class Solution:
#     def longestValidParentheses(self, s):
#         """
#         :type s: str
#         :rtype: int
        
#         >>> longestValidParentheses = Solution().longestValidParentheses
#         >>> longestValidParentheses("(()")
#         2
#         >>> longestValidParentheses(")()())")
#         4
#         >>> longestValidParentheses("()(())")
#         6
#         >>> longestValidParentheses("()((()()((()))))")
#         16
#         >>> longestValidParentheses("(()())")
#         6
#         >>> longestValidParentheses("(()))())(")
#         4
#         """
#         # Using dp[i] to store the length of the longest valid parenthesis substring ending with s[i]
#         dp = []

#         # maxLength updates as dp grows
#         maxLength = 0

#         # Find the longest valid parenthesis substring vai dynamic programming
#         for i in range(len(s)):
#             if i >= 1 and s[i] == ')' and s[i - 1] == '(':
#                 dp.append((dp[i - 2] if i >= 2 else 0) + 2)
#                 maxLength = maxLength if maxLength >= dp[i] else dp[i]
#             elif i >= 1 and s[i] == ')' and s[i - 1] == ')' and i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == '(':
#                 dp.append(dp[i - 1] + (dp[i - dp[i - 1] - 2] if i - dp[i - 1] - 2 >= 0 else 0) + 2)
#                 maxLength = maxLength if maxLength >= dp[i] else dp[i]
#             else:
#                 dp.append(0)

#         return maxLength



# # Wrong solution
# class Solution:
#     def longestValidParentheses(self, s):
#         """
#         :type s: str
#         :rtype: int
        
#         >>> longestValidParentheses = Solution().longestValidParentheses
#         >>> longestValidParentheses("(()")
#         2
#         >>> longestValidParentheses(")()())")
#         4
#         >>> longestValidParentheses("()(())")
#         6
#         >>> longestValidParentheses("()((()()((()))))")
#         """
#         # Some notes:
#         # "(" should be more than or equal to ")"

#         symbolStack = []
#         countOpen = 0
#         countClose = 0
#         maxLength = 0
#         length = 0
#         for i in range(len(s)):
#             if len(symbolStack) == 1 and s[i] == ")" and symbolStack[-1] == "(":
#                 symbolStack.pop()
#                 countClose -= 1
#                 length += 2
#             else:
#                 symbolStack.append(s[i])

#                 if s[i] == ")":
#                     countClose += 1
#                 else:
#                     countOpen += 1

#                 if (countOpen < countClose):
#                     countOpen = countClose = 0
#                     maxLength = maxLength if maxLength >= length else length
#                     length = 0
#                     symbolStack.clear()

#         maxLength = maxLength if maxLength >=length else length

#         return maxLength

        