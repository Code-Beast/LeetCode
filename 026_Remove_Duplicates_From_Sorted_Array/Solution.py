#!python3
# Author: Code-Beast

# MY SOLUTION 1 (Two Pointers)
# Runtime: 60ms
class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = 0
        for idx, num in enumerate(nums):
            if idx == 0 or idx > 0 and num != nums[idx - 1]:
                nums[count] = num
                count += 1
        
        # # Because it doesn't matter what you leave beyond the returned length, it is not necessary to pop 
        # for i in range(len(nums) - count):
        #     nums.pop()
            
        return count