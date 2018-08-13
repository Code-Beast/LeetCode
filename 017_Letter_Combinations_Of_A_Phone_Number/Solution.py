#!python3
# Author: Code-Beast

# MY SOLUTION 3 (Iteration: Fatest)
class Solution:
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]

        >>> Solution().letterCombinations("23")
        ['ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce', 'cf']
        >>> Solution().letterCombinations("234")
        """
        if len(digits) == 0:
            return []

        digitLetterMap = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        combs = ['']
        res = []

        for digit in digits:
            for combPrev in combs:
                for letter in digitLetterMap[digit]:
                    res.append(combPrev + letter)
            combs = res
            res = []

        return combs



# # MY SOLUTION 2 (Recursion)
# class Solution:
#     def letterCombinations(self, digits):
#         """
#         :type digits: str
#         :rtype: List[str]

#         >>> Solution().letterCombinations("23")
#         ['ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce', 'cf']
#         """
#         if len(digits) == 0:
#         	return []

#         digitLetterMap = {
#         	"2": ['a', 'b', 'c'],
#         	"3": ['d', 'e',	'f'],
#         	"4": ['g', 'h', 'i'],
#         	"5": ['j', 'k', 'l'],
#         	"6": ['m', 'n', 'o'],
#         	"7": ['p', 'q', 'r', 's'],
#         	"8": ['t', 'u', 'v'],
#         	"9": ['w', 'x', 'y', 'z']
#         }

#         def digitToLetterCombinations(currentIdx):
#         	if currentIdx == len(digits) - 1:
#         		return digitLetterMap[digits[-1]]

#         	combinations = []

#         	for letter in digitLetterMap[digits[currentIdx]]:
#         		for rest in digitToLetterCombinations(currentIdx + 1):
#         			combinations.append(letter + rest)

#         	return combinations

#         return digitToLetterCombinations(0)
        


# # MY SOLUTION 1 (reduce() from functools: Worst Solution)
# from functools import reduce

# class Solution:
#     def letterCombinations(self, digits):
#         """
#         :type digits: str
#         :rtype: List[str]

#         >>> Solution().letterCombinations("23")
#         ['ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce', 'cf']
#         >>> Solution().letterCombinations("234")
#         """
#         if len(digits) == 0:
#         	return []

#         digitLetterMap = {
#             '2': 'abc',
#             '3': 'def',
#             '4': 'ghi',
#             '5': 'jkl',
#             '6': 'mno',
#             '7': 'pqrs',
#             '8': 'tuv',
#             '9': 'wxyz'
#         }

#         return reduce(lambda combPrev, digit: [comb + letter for comb in combPrev for letter in digitLetterMap[digit]], digits, [''])
