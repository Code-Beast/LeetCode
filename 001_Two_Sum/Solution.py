#!python3

class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {};
        for idx, num in enumerate(nums):
            if target - num in dict:
                return [dict[target - num], idx]
            dict[num] = idx

        # SOLUTION 1
        # lookup = {}
        # for i in range(len(nums)):
        #     if target - nums[i] in lookup:
        #         return [lookup[target - nums[i]], i]
        #     lookup[nums[i]]=i

        # SOLUTION 2
        # lookup={}
        # for cnt, num in enumerate (nums):
        #     if target-num in lookup:
        #         return lookup[target-num], cnt
        #     lookup[num]=cnt

if __name__ == "__main__":
    nums = [2, 7, 11, 15]
    target = 9
    assert (Solution().twoSum(nums, target) == [0, 1])
    nums = [3, 2, 4]
    target = 6
    assert (Solution().twoSum(nums, target) == [1, 2])