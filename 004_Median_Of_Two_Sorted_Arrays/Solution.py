class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float

        >>> Solution().findMedianSortedArrays([1, 3], [2])
        2
        >>> Solution().findMedianSortedArrays([1, 2], [3, 4])
        2.5
        >>> Solution().findMedianSortedArrays([], [1, 2, 3])
        2
        >>> Solution().findMedianSortedArrays([1, 2], [-1, 3])
        1.5
        """
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1;

        m, n = len(nums1), len(nums2)
        minIdx, maxIdx = 0, m

        while minIdx <= maxIdx:
            i = (minIdx + maxIdx) // 2
            j = (m + n + 1) // 2 - i
            if i > 0 and nums1[i - 1] > nums2[j]:
                maxIdx = i - 1
            elif i < m and nums1[i] < nums2[j - 1]:
                minIdx = i + 1
            else:
                if i == 0:
                    maxLeft = nums2[j - 1]
                elif j == 0:
                    maxLeft = nums1[i - 1]
                else:
                    maxLeft = max(nums1[i - 1], nums2[j - 1])

                if (m + n) % 2: return maxLeft

                if i == m:
                    minRight = nums2[j]
                elif j == n:
                    minRight = nums1[i]
                else:
                    minRight = min(nums1[i], nums2[j])

                return (maxLeft + minRight) / 2
        

# SOLUTION 1
# class Solution:
#     def findMedianSortedArrays(self, nums1, nums2):
#         nums = []
#         idx1 = idx2 = 0
#         while idx1 < len(nums1) or idx2 < len(nums2):
#             if idx2 == len(nums2):
#                 nums.append(nums1[idx1])
#                 idx1 += 1
#             elif idx1 == len(nums1):
#                 nums.append(nums2[idx2])
#                 idx2 += 1
#             elif nums1[idx1] <= nums2[idx2]:
#                 nums.append(nums1[idx1])
#                 idx1 += 1
#             else:
#                 nums.append(nums2[idx2])
#                 idx2 += 1
#         return self.findMedian(nums)
        
#     def findMedian(self, nums):
#         quotient = len(nums) // 2
#         remainder = len(nums) % 2
#         if remainder:
#             return nums[quotient]
#         else:
#             return (nums[quotient - 1] + nums[quotient]) / 2