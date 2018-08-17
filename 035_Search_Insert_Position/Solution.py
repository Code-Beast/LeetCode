#!python3
# Author: Code-Beast

# MY SOLUTION 1 (Binary search)
# Runtime: 40ms
class Solution:
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int

        >>> Solution().searchInsert([1,3,5,6], 2)
        1
        """
        if len(nums) == 0 or nums[0] >= target:
        	return 0

        if nums[-1] < target:
        	return len(nums)

        left = 0
        right = len(nums) - 1
        while left < right:
        	mid = (left + right) // 2
        	if nums[mid] < target:
        		left = mid + 1
        	elif nums[mid] > target:
        		right = mid - 1
        	else:
        		return mid
        return left if nums[left] >= target else left + 1
