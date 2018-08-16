#!python3
# Author: Code-Beast

# MY SOLUTINO 2 (Iteration)
# Runtime: 48ms
class Solution:
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.

        >>> nextPermutation = Solution().nextPermutation
        >>> nextPermutation([1, 2, 3])
        [1, 3, 2]
        >>> nextPermutation([3, 2, 1])
        [1, 2, 3]
        >>> nextPermutation([1, 1, 5])
        [1, 5, 1]
        >>> nextPermutation([3, 4, 2, 1])
        [4, 1, 2, 3]
        >>> nextPermutation([2, 4, 3, 1])
        [3, 1, 2, 4]
        >>> nextPermutation([1, 3, 2])
        [2, 1, 3]
        """
        length = len(nums)

        # Handle boundary conditions
        if length == 0 or length == 1:
            return

        # Define reverse function
        def reverse(start):
            for i in range((length - (start)) // 2):
                nums[start + i], nums[length - 1 - i] = nums[length - 1 - i], nums[start + i]

        # Define swap function
        def swap(idx1, idx2):
            nums[idx1], nums[idx2] = nums[idx2], nums[idx1]

        # Iteration
        i = length - 2
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1

        if i >= 0:
            j = i + 1
            while j < length:
                if nums[j] <= nums[i]:
                    break
                j += 1

            swap(i, j - 1)
            reverse(i + 1)
        else:
            reverse(0)

        print(nums)
        return



# # MY SOLUTION 1 (Recursion)
# # Runtime: 56ms
# class Solution:
#     def nextPermutation(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: void Do not return anything, modify nums in-place instead.

#         >>> nextPermutation = Solution().nextPermutation
#         >>> nextPermutation([1, 2, 3])
#         [1, 3, 2]
#         >>> nextPermutation([3, 2, 1])
#         [1, 2, 3]
#         >>> nextPermutation([1, 1, 5])
#         [1, 5, 1]
#         >>> nextPermutation([3, 4, 2, 1])
#         [4, 1, 2, 3]
#         >>> nextPermutation([2, 4, 3, 1])
#         [3, 1, 2, 4]
#         >>> nextPermutation([1, 3, 2])
#         [2, 1, 3]
#         """
#         length = len(nums)

#         # Handle boundary conditions
#         if length == 0 or length == 1:
#           return

#         # Define reverse function
#         def reverse(start):
#           for i in range((length - (start)) // 2):
#               nums[start + i], nums[length - 1 - i] = nums[length - 1 - i], nums[start + i]

#         # Define the recursion helper
#         def nextPermutationHelper(rest):
#           # Recurse base: if two nums are left, try to rearrange them to find the next permutation\
#           if rest == length - 2:
#               if nums[-1] > nums[-2]:
#                   nums[-1], nums[-2] = nums[-2], nums[-1]
#                   return True
#               else:
#                   return False

#           # If no next permutation can be found in the rest numbers
#           if nextPermutationHelper(rest + 1) == False:
#               # Find the last number bigger than nums[rest] in the nums[rest + 1 :] numbers from the left to the right
#               i = rest + 1
#               while i < length:
#                   if nums[i] <= nums[rest]:
#                       break
#                   i += 1

#               # If the search for that number in nums[rest + 1 :] fails, return False (no next permutation)
#               if i == rest + 1:
#                   return False
#               # Else, swap it with nums[rest + 1] and reverse nums[rest + 1 :]
#               else:
#                   nums[rest], nums[i - 1] = nums[i - 1], nums[rest]
#                   reverse(rest + 1)
                    
#           return True

#         # Try finding the next permutation for nums
#         # If no next permutation is found
#         # Reverse nums
#         if nextPermutationHelper(0) == False:
#           reverse(0)

#         print(nums)





