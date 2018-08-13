#!python3
# Author: Code-Beast

# MY SOLUTION 4
class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]

        >>> Solution().threeSum([-1,0,1,2,-1,-4])
        [[-1, 0, 1], [-1, -1, 2]]
        """
        if len(nums) <= 2:
            return []

        nums.sort()

        res = set()
        for idx1, num1 in enumerate(nums):
            if idx1 > 0 and num1 == nums[idx1 - 1]:
                continue

            memo = set()
            for idx2, num2 in enumerate(nums[idx1 + 1 :]):
                if num2 in memo:
                    res.add((num1, num2, (0 - num1 - num2)))
                else:
                    memo.add(0 - num1 - num2)

        return list(map(list, res))



# # MY SOLUTION 3 
# class Solution:
#     def threeSum(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[List[int]]

#         >>> Solution().threeSum([-1,0,1,2,-1,-4])
#         [[-1, 0, 1], [-1, -1, 2]]
#         """
#         res = []
#         nums.sort()

#         for i in range(len(nums)):
#             # Aovid repeat
#             if nums[i] > 0:
#                 break

#             if i > 0 and nums[i] == nums[i - 1]:
#                 continue

#             # Find these trios
#             left = i + 1
#             right = len(nums) - 1
#             while left < right:
#                 sumThree = nums[left] + nums[right] + nums[i]
#                 if sumThree > 0:
#                     while left < right and nums[right] == nums[right - 1]:
#                         right -= 1
#                     right -= 1
#                 elif sumThree < 0:
#                     while left < right and nums[left] == nums[left + 1]:
#                         left += 1
#                     left += 1
#                 else:
#                     res.append([nums[left], nums[right], nums[i]])
#                     while left < right and nums[left] == nums[left + 1]:
#                         left += 1
#                     while left < right and nums[right] == nums[right - 1]:
#                         right -= 1
#                     left, right = left + 1, right - 1

#         return res




# # MY SOLUTION 2 (Error: Time Limit Exceeded)
# class Solution:
#     def threeSum(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[List[int]]

#         >>> Solution().threeSum([-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6])
#         [[-1, 0, 1], [-1, -1, 2]]
#         """
#         res = []
#         resSet = []

#         # Store numbers in zero, pos and neg respectively
#         zero, pos, neg = [], [], []
#         for num in nums:
#             if num == 0:
#                 zero.append(num)
#             elif num > 0:
#                 pos.append(num)
#             else:
#                 neg.append(num)

#         # Condition 1: 3 zeros
#         if len(zero) >= 3:
#             res.append([0, 0, 0])

#         # Condition 2: 1 zero, 1 pos, 1 neg
#         if len(zero) > 0 and len(pos) > 0 and len(neg) > 0:
#             for posNum in set(pos):
#                 for negNum in set(neg):
#                     if posNum + negNum == 0:
#                         res.append([0, posNum, negNum])

#         # Condition 3: 1 pos, 2 negs
#         if len(pos) > 0 and len(neg) >= 2:
#             for posNum in set(pos):
#                 for i in range(len(neg)):
#                     for j in range(len(neg)):
#                         if ({neg[i], neg[j], posNum} not in resSet) and i != j and neg[i] + neg[j] + posNum == 0:
#                             resSet.append({neg[i], neg[j], posNum})
#                             res.append([neg[i], neg[j], posNum])
#                             break

#         # Condition 4: 1 neg, 2 pos's
#         if len(neg) > 0 and len(pos) >= 2:
#             for negNum in set(neg):
#                 for i in range(len(pos)):
#                     for j in range(len(pos)):
#                         if ({pos[i], pos[j], negNum} not in resSet) and i != j and pos[i] + pos[j] + negNum == 0:
#                             resSet.append({pos[i], pos[j], negNum})
#                             res.append([pos[i], pos[j], negNum])
#                             break

#         return res



# # MY SOLUTION 1 (Error: Time Limit Exceeded)
# class Solution:
#     def threeSum(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[List[int]]

#         >>> Solution().threeSum([-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6])
#         [[-1, 0, 1], [-1, -1, 2]]
#         """
#         res = []

#         # Store numbers in zero, pos and neg respectively
#         zero, pos, neg = [], [], []
#         for num in nums:
#             if num == 0:
#                 zero.append(num)
#             elif num > 0:
#                 pos.append(num)
#             else:
#                 neg.append(num)

#         # Condition 1: 3 zeros
#         if len(zero) >= 3:
#             res.append([0, 0, 0])

#         # Condition 2: 1 zero, 1 pos, 1 neg
#         if len(zero) > 0 and len(pos) > 0 and len(neg) > 0:
#             for posNum in set(pos):
#                 for negNum in set(neg):
#                     if posNum + negNum == 0:
#                         res.append([0, posNum, negNum])

#         # Condition 3: 1 pos, 2 negs
#         usedNegTrios = []
#         if len(pos) > 0 and len(neg) >= 2:
#             for posNum in set(pos):
#                 for i in range(len(neg)):
#                     for j in range(len(neg)):
#                         if ({neg[i], neg[j], posNum} not in usedNegTrios) and i != j and neg[i] + neg[j] + posNum == 0:
#                             res.append([neg[i], neg[j], posNum])
#                             usedNegTrios.append(set([neg[i], neg[j], posNum]))
#                             break

#         # Condition 4: 1 neg, 2 pos's
#         usedPosTrios = []
#         if len(neg) > 0 and len(pos) >= 2:
#             for negNum in set(neg):
#                 for i in range(len(pos)):
#                     for j in range(len(pos)):
#                         if ({pos[i], pos[j], negNum} not in usedPosTrios) and i != j and pos[i] + pos[j] + negNum == 0:
#                             res.append([pos[i], pos[j], negNum])
#                             usedPosTrios.append(set([pos[i], pos[j], negNum]))
#                             break

#         return res