#!python3
# Author: Code-Beast

# MY SOLUTION 4 (Another better recursion)
class Solution:
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]

        >>> Solution().fourSum([1, 0, -1, 2, -1, 4, -2, 0, -2, 2], 0)
        [[-2, -2, 0, 4], [-2, -2, 2, 2], [-2, -1, -1, 4], [-2, -1, 1, 2], [-2, 0, 0, 2], [-1, -1, 0, 2], [-1, 0, 0, 1]]
        >>> Solution().fourSum([0, 0, 0, 0], 0)
        [[0, 0, 0, 0]]
        >>> Solution().fourSum([0, 0, 0, 0], 1)
        []
        """
        def NSum(nums, target, N, lastNums, res):
            if len(nums) < N or N < 2 or target < nums[0] * N or target > nums[-1] * N:
                return

            if N == 2:
                left, right = 0, len(nums) - 1
                while left < right:
                    sumTwo = nums[left] + nums[right]
                    if sumTwo > target:
                        # while left < right and nums[right] == nums[right - 1]:
                        #     right -= 1
                        right -= 1
                    elif sumTwo < target:
                        # while left < right and nums[left] == nums[left + 1]:
                        #     left += 1
                        left += 1
                    else:
                        res.append(lastNums + [nums[left], nums[right]])
                        while left < right and nums[left] == nums[left + 1]:
                            left += 1
                        left += 1
                        while left < right and nums[right] == nums[right - 1]:
                            right -= 1
                        right -= 1
                return

            for idx, num in enumerate(nums):
                if (idx == 0 or idx > 0 and num != nums[idx - 1]) and idx <= len(nums) - N:
                    NSum(nums[idx + 1 :], target - num, N - 1, lastNums + [num], res)
            return

        res = []
        NSum(sorted(nums), target, 4, [], res)
        return res



# # MY SOLUTION 3 (Recursion: Best Solution)
# class Solution:
#     def fourSum(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[List[int]]

#         >>> Solution().fourSum([1, 0, -1, 2, -1, 4, -2, 0, -2, 2], 0)
#         >>> Solution().fourSum([0, 0, 0, 0], 0)
#         [[0, 0, 0, 0]]
#         >>> Solution().fourSum([0, 0, 0, 0], 1)
#         []
#         """
#         nums.sort()

#         def NSum(nums, target, N):
#             if len(nums) < N or N < 2:
#                 return []

#             if N == 2:
#                 res = []
#                 left, right = 0, len(nums) - 1
#                 while left < right:
#                     sumTwo = nums[left] + nums[right]
#                     if sumTwo > target:
#                         while left < right and nums[right] == nums[right - 1]:
#                             right -= 1
#                         right -= 1
#                     elif sumTwo < target:
#                         while left < right and nums[left] == nums[left + 1]:
#                             left += 1
#                         left += 1
#                     else:
#                         res.append([nums[left], nums[right]])
#                         while left < right and nums[left] == nums[left + 1]:
#                             left += 1
#                         left += 1
#                         while left < right and nums[right] == nums[right - 1]:
#                             right -= 1
#                         right -= 1
#                 return res

#             res = []
#             for idx, num in enumerate(nums):
#                 if idx == 0 or idx > 0 and num != nums[idx - 1]:
#                     for rightPart in NSum(nums[idx + 1 :], target - num, N - 1):
#                         res.append([num] + rightPart)
#             return res

#         return NSum(nums, target, 4)



# # MY SOLUTION 2 (Not applicable to other languages)
# class Solution:
#     def fourSum(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[List[int]]

#         >>> Solution().fourSum([1, 0, -1, 0, -2, 2], 0)
#         [[-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2]]
#         >>> Solution().fourSum([0, 0, 0, 0], 0)
#         [[0, 0, 0, 0]]
#         >>> Solution().fourSum([0, 0, 0, 0], 1)
#         []
#         """
#         if len(nums) < 4:
#             return []

#         nums.sort()
#         pairSumMap = {}

#         for i in range(len(nums)):
#             for j in range(i + 1, len(nums)):
#                 sumOfPair = nums[i] + nums[j]
#                 if sumOfPair in pairSumMap:
#                     pairSumMap[sumOfPair].append((i, j))
#                 else:
#                     pairSumMap[sumOfPair] = [(i, j)]

#         res = set()

#         for pair in pairSumMap:
#             if target - pair in pairSumMap:
#                 for (i, j) in pairSumMap[target - pair]:
#                     for (k, l) in pairSumMap[pair]:
#                         if i != k and j != k and i != l and j != l:
#                             four = [nums[i], nums[j], nums[k], nums[l]]
#                             four.sort()
#                             res.add(tuple(four))

#         return list(map(list, res))



# # MY SOLUTION 1 (threeSum())
# class Solution:
#     def fourSum(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[List[int]]

#         >>> Solution().fourSum([1, 0, -1, 0, -2, 2], 0)
#         [[-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2]]
#         >>> Solution().fourSum([0, 0, 0, 0], 0)
#         [[0, 0, 0, 0]]
#         >>> Solution().fourSum([0, 0, 0, 0], 1)
#         []
#         """
#         nums.sort()

#         if len(nums) < 4:
#             return []

#         def threeSum(nums, target):
#             res = []

#             for i in range(len(nums)):
#                 # Aovid repeat
#                 if i > 0 and nums[i] == nums[i - 1]:
#                     continue

#                 # Find these trios
#                 left = i + 1
#                 right = len(nums) - 1
#                 while left < right:
#                     sumThree = nums[left] + nums[right] + nums[i]
#                     if sumThree > target:
#                         while left < right and nums[right] == nums[right - 1]:
#                             right -= 1
#                         right -= 1
#                     elif sumThree < target:
#                         while left < right and nums[left] == nums[left + 1]:
#                             left += 1
#                         left += 1
#                     else:
#                         res.append([nums[left], nums[right], nums[i]])
#                         while left < right and nums[left] == nums[left + 1]:
#                             left += 1
#                         while left < right and nums[right] == nums[right - 1]:
#                             right -= 1
#                         left, right = left + 1, right - 1

#             return res

#         res = []
#         for i in range(len(nums) - 3):
#             if i > 0 and nums[i] == nums[i - 1]:
#                 continue

#             trios = threeSum(nums[i + 1 :], target - nums[i])
#             for trio in trios:
#                 trio.append(nums[i])
#                 res.append(trio)
#         return res

        