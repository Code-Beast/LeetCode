#!python3
# Author: Code-Beast

class Solution:
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int

        >>> Solution().threeSumClosest([-1, 2, 1, -4], 1)
       	2
       	>>> Solution().threeSumClosest([1, 1, 1, 0], 100)
       	3
        """
        nums.sort()
        closest = nums[0] + nums[1] + nums[2]

        for i in range(len(nums)):
            # Aovid repeat
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            # Find these trios
            left = i + 1
            right = len(nums) - 1
            while left < right:
                sumThree = nums[left] + nums[right] + nums[i]
                if sumThree > target:
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    right -= 1
                elif sumThree < target:
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    left += 1
                else:
                    return target
                closest = sumThree if abs(sumThree - target) < abs(closest - target) else closest
        return closest