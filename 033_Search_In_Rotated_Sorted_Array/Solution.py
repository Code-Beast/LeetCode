#!python3
# Author: Code-Beast


# # MY SOLUTION 2 (Altered Binary Search)
# # Runtime: 40ms
# class Solution:
#     def search(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: int

#         >>> Solution().search([4,5,6,7,0,1,2], 0)
#         4
#         >>> Solution().search([4,5,6,7,0,1,2], 3)
#         -1
#         """
#         left = 0
#         right = len(nums) - 1

#         while left <= right:
#         	mid = (left + right) // 2
#         	if nums[mid] == target:
#         		return mid
#         	elif nums[right] == target:
#         		return right
#         	elif nums[left] == target:
#         		return left 
#         	elif nums[mid] < target:
#         		if nums[right] > target or nums[right] < nums[mid]:
#         			left = mid + 1
#         			right = right - 1
#         		else: 
#         			left = left + 1
#         			right = mid - 1
#         	else:
#         		if nums[left] < target or nums[left] > nums[mid]:
#         			left = left + 1
#         			right = mid - 1
#         		else:
#         			left = mid + 1
#         			right = right - 1

#         return -1



# # MY SOLUTION 1 (Binary Search)
# # Runtime: 40ms
# class Solution:
#     def search(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: int

#         >>> Solution().search([4,5,6,7,0,1,2], 0)
#         4
#         >>> Solution().search([4,5,6,7,0,1,2], 3)
#         -1
#         """
#         left = 0
#         right = len(nums) - 1

#         while left <= right:
#         	mid = (left + right) // 2
#         	if nums[mid] == target:
#         		return mid
#         	elif nums[mid] < target:
#         		if nums[right] >= target or nums[right] < nums[mid]:
#         			left = mid + 1
#         		else: 
#         			right = mid - 1
#         	else:
#         		if nums[left] <= target or nums[left] > nums[mid]:
#         			right = mid - 1
#         		else:
#         			left = mid + 1

#         return -1
