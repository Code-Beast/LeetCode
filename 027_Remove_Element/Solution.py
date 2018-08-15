#!python3
# Author: Code-Beast

# MY SOLUTION 2 (Two pointers: when elements to remove are rare)
# Note: the order of elements could be changed
# Runtime: 36ms
class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        i = 0
        length = len(nums)
        while i < length:
        	if nums[i] == val:
        		nums[i] = nums[length - 1]
        		length -= 1
        	else:
        		i += 1
        return length


# # MY SOLUTION 1 (Two pointers)
# # Runtime: 40ms
# class Solution:
#     def removeElement(self, nums, val):
#         """
#         :type nums: List[int]
#         :type val: int
#         :rtype: int
#         """
#         count = 0
#         for num in nums:
#             if num != val:
#                 nums[count] = num
#                 count += 1
#         return count