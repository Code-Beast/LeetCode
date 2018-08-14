#!python3 
# Author: Code-Beast

# MY SOLUTION 1 (Iteration: Beat 100%)
class Solution:
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        >>> generateParenthesis = Solution().generateParenthesis
        >>> generateParenthesis(3)
        ['((()))', '(()())', '(())()', '()(())', '()()()']
        """
        def addParenthesis(prev, numToOpen, numToClose):
            if numToOpen == 0:
                for i in range(numToClose):
                    prev += ')'
                return [prev]
            elif numToClose == 0 or numToOpen > numToClose:
                return []
            else:
                return addParenthesis(prev + '(', numToOpen - 1, numToClose) + addParenthesis(prev + ')', numToOpen, numToClose - 1)

        if n == 0:
            return []
        return addParenthesis("", n, n)


# # MY SOLUTION 1 (Recursion: Bad Solution)
# class Solution:
#     def generateParenthesis(self, n):
#         """
#         :type n: int
#         :rtype: List[str]
#         >>> generateParenthesis = Solution().generateParenthesis
#         >>> generateParenthesis(3)
#         ['((()))', '(()())', '(())()', '()(())', '()()()']
#         """
#         if n == 0:
#           return []

#         if n == 1:
#           return ["()"]

#         res = []

#         for i in range(1, n // 2 + 1):
#           for part1 in self.generateParenthesis(i):
#               for part2 in self.generateParenthesis(n - i):
#                   combs = [part1 + part2, part2 + part1]
#                   if i == 1:
#                       combs.append("(" + part2 + ")")

#                   for comb in combs:
#                       if comb not in res:
#                           res.append(comb)

#           return res