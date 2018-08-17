#!python3
# Author : Code-Beast

# MY SOLUTION 2 (Two binary searches)
# Runtime: 40ms
class Solution:
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]

        >>> Solution().searchRange([5,7,7,8,8,10], 8)
        [3, 4]
        >>> Solution().searchRange([5,7,7,8,8,10], 6)
        [-1, -1]
        """
        # Binary search start
        left = mid = 0
        right = len(nums) - 1
        start = -1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                start = mid
                right = mid - 1

        # Binary search end
        left = mid = 0
        right = len(nums) - 1
        end = -1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                end = mid
                left = mid + 1

        return [start, end]
        


# # MY SOLUTION 1 (Recursion)
# # Runtime: 50ms
# class Solution:
#     def searchRange(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[int]

#         >>> Solution().searchRange([5,7,7,8,8,10], 8)
#         [3, 4]
#         >>> Solution().searchRange([5,7,7,8,8,10], 6)
#         [-1, -1]
#         """
#         # Handle boundary condition
#         if len(nums) == 0:
#           return [-1, -1]

#         # Define helper function
#         def searchRangeHelper(left, right):
#           # Recursion base
#           if right < left or nums[left] > target or nums[right] < target:
#               return [-1, -1]

#           if left == right:
#               if nums[left] == target:
#                   return [left, right]
#               else:
#                   return [-1, -1]

#           mid = (left + right) // 2
#           if nums[mid] < target:
#               return searchRangeHelper(mid + 1, right)
#           elif nums[mid] > target:
#               return searchRangeHelper(left, mid - 1)
#           else:
#               leftStart = searchRangeHelper(left, mid - 1)[0]
#               rightEnd = searchRangeHelper(mid + 1, right)[1]
#               return [leftStart if leftStart != -1 else mid, rightEnd if rightEnd != -1 else mid]

#         # Find the start and the end
#         return searchRangeHelper(0, len(nums) - 1)

