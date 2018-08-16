#!python3
# Author: Code-Beast

# MY SOLUTION 4 (defaultdict and two pointers)
# Runtime: 68ms
class Solution:
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]

        >>> findSubstring = Solution().findSubstring 
        >>> findSubstring("barfoothefoobarman", ["foo", "bar"])
        [0, 9]
        >>> findSubstring("barfoothefoobarman", ["foo", "bar", "the"])
        [0, 6]
        >>> findSubstring("", ["foo", "bar", "the"])
        []
        >>> findSubstring("barfoothefoobarman", ["this", "that"])
        []
        >>> findSubstring("wordgoodgoodgoodbestword", ["word", "good", "best", "good"])
        [8]
        >>> findSubstring("aaa", ["a", "a"])
        [0, 1]
        """
        if s == "" or words == []:
            return []

        # Initialize and define import values
        from collections import defaultdict
        wordLength = len(words[0])
        wordListLength = len(words)
        subStrLength = wordListLength * wordLength
        strLength = len(s)

        # Handle a 100% failure
        if strLength < subStrLength:
            return []

        # Construct the word map
        # And find the substring value to find
        wordCountMap = defaultdict(int)
        for word in words:
            wordCountMap[word] += 1


        # Iteration for to find substrings which contains the exactly same number of every word in wordCountMap
        res = []
        newWordCountMap = defaultdict(int)
        for i in range(wordLength):
            left = right = i
            newWordCountMap.clear()
            while right < strLength - wordLength + 1:
                currWord = s[right : right + wordLength]
                if currWord not in wordCountMap:
                    newWordCountMap.clear()
                    right += wordLength
                    left = right
                else:
                    newWordCountMap[currWord] += 1
                    right += wordLength
                    if newWordCountMap[currWord] > wordCountMap[currWord]:
                        while left < right:
                            newWordCountMap[s[left : left + wordLength]] -= 1
                            left += wordLength
                            if s[left - wordLength : left] == currWord:
                                break
                    
                    if right - left == subStrLength:
                        res.append(left)
                        newWordCountMap[s[left : left + wordLength]] -= 1
                        left += wordLength
        return res



# # MY SOLUTION 3 (Two defaultdicts)
# # Runtime: 370ms
# class Solution:
#     def findSubstring(self, s, words):
#         """
#         :type s: str
#         :type words: List[str]
#         :rtype: List[int]

#         >>> findSubstring = Solution().findSubstring 
#         >>> findSubstring("barfoothefoobarman", ["foo", "bar"])
#         [0, 9]
#         >>> findSubstring("barfoothefoobarman", ["foo", "bar", "the"])
#         [0, 6]
#         >>> findSubstring("", ["foo", "bar", "the"])
#         []
#         >>> findSubstring("barfoothefoobarman", ["this", "that"])
#         []
#         >>> findSubstring("wordgoodgoodgoodbestword", ["word", "good", "best", "good"])
#         [8]
#         """
#         # Handle boundary conditions
#         if s == "" or words == []:
#           return []

#         # Initialize and define import values
#         from collections import defaultdict
#         wordLength = len(words[0])
#         wordListLength = len(words)
#         subStrLength = wordListLength * wordLength
#         strLength = len(s)

#         # Construct the word map
#           # And find the substring value to find
#         wordCountMap = defaultdict(int)
#         for word in words:
#           wordCountMap[word] += 1


#         # Iteration for to find substrings which contains the exactly same number of every word in wordCountMap
#         res = []
#         newWordCountMap = defaultdict(int)
#         for i in range(strLength - subStrLength + 1):
#           # Skip impossible starting index
#           word = s[i : i + wordLength]
#           if word in wordCountMap:
#               j = 0
#               newWordCountMap.clear()
#               while j < wordListLength:
#                   currWord = s[i + j * wordLength : i + (j + 1) * wordLength]
#                   newWordCountMap[currWord] += 1
#                   if newWordCountMap[currWord] > wordCountMap[currWord]:
#                       break
#                   j += 1
#               if j == wordListLength:
#                   res.append(i)

#         return res



# # MY SOLUTION 2 (dict and List)
# # Solution 1 and Solution 2 can only work in Python because if the words has 300 words, 
# #     the key 2^300 exceeds the max value of integer in java and number in js
# # Runtime: 180ms
# class Solution:
#     def findSubstring(self, s, words):
#         """
#         :type s: str
#         :type words: List[str]
#         :rtype: List[int]

#         >>> findSubstring = Solution().findSubstring 
#         >>> findSubstring("barfoothefoobarman", ["foo", "bar"])
#         [0, 9]
#         >>> findSubstring("barfoothefoobarman", ["foo", "bar", "the"])
#         [0, 6]
#         >>> findSubstring("", ["foo", "bar", "the"])
#         []
#         >>> findSubstring("barfoothefoobarman", ["this", "that"])
#         []
#         >>> findSubstring("wordgoodgoodgoodbestword", ["word", "good", "best", "good"])
#         [8]
#         """
#         # Handle boundary conditions
#         if s == "" or words == []:
#           return []

#         # Initialize and define import values
#         wordLength = len(words[0])
#         wordListLength = len(words)
#         subStrLength = wordListLength * wordLength
#         strLength = len(s)

#         # Construct the word map
#           # And find the substring value to find
#         wordMap = {}
#         keyPow = 0
#         targetValue = 0
#         for word in words:
#           if word not in wordMap:
#               wordMap[word] = pow(2, keyPow)
#               keyPow += 1
#           targetValue += wordMap[word]

#         # First pass for getting word value for each i before len(s) - len(words[0]) + 1 and document them in a corresponding list
#         values = []
#         for i in range(strLength - wordLength + 1):
#           word = s[i : i + wordLength]
#           values.append(wordMap[word] if word in wordMap else 0)

#         # Second pass for getting substring value for each i before len(s) - len(words) * len(words[0]) + 1
#         # And document indices which meet the requirement
#         res = []
#         for i in range(strLength - subStrLength + 1):
#           # Skip impossible starting index
#           if values[i] != 0:
#               subStrValue = 0
#               for j in range(0, subStrLength, wordLength):
#                   subStrValue += values[i + j]
#               if subStrValue == targetValue:
#                   res.append(i)

#         return res



# # MY SOLUTION 1 (defaultdict and List)
# # Runtime: 190ms
# class Solution:
#     def findSubstring(self, s, words):
#         """
#         :type s: str
#         :type words: List[str]
#         :rtype: List[int]

#         >>> findSubstring = Solution().findSubstring 
#         >>> findSubstring("barfoothefoobarman", ["foo", "bar"])
#         [0, 9]
#         >>> findSubstring("barfoothefoobarman", ["foo", "bar", "the"])
#         [0, 6]
#         >>> findSubstring("", ["foo", "bar", "the"])
#         []
#         >>> findSubstring("barfoothefoobarman", ["this", "that"])
#         []
#         >>> findSubstring("wordgoodgoodgoodbestword", ["word", "good", "best", "good"])
#         [8]
#         """
#         # Handle boundary conditions
#         if s == "" or words == []:
#           return []

#         # Initialize and define import values
#         from collections import defaultdict
#         wordLength = len(words[0])
#         wordListLength = len(words)
#         subStrLength = wordListLength * wordLength
#         strLength = len(s)

#         # Construct the word map
#           # And find the substring value to find
#         wordMap = defaultdict(int)
#         keyPow = 0
#         targetValue = 0
#         for word in words:
#           if word not in wordMap:
#               wordMap[word] = pow(2, keyPow)
#               keyPow += 1
#           targetValue += wordMap[word]

#         # First pass for getting word value for each i before len(s) - len(words[0]) + 1 and document them in a corresponding list
#         values = []
#         for i in range(strLength - wordLength + 1):
#           values.append(wordMap[s[i : i + wordLength]])

#         # Second pass for getting substring value for each i before len(s) - len(words) * len(words[0]) + 1
#         # And document indices which meet the requirement
#         res = []
#         for i in range(strLength - subStrLength + 1):
#           # Skip impossible starting index
#           if values[i] != 0:
#               subStrValue = 0
#               for j in range(0, subStrLength, wordLength):
#                   subStrValue += values[i + j]
#               if subStrValue == targetValue:
#                   res.append(i)

#         return res