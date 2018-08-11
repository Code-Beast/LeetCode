#!python3
# Author: Code-Beast

# MY SOLUTION 2
class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int

        >>> maxArea = Solution().maxArea
        >>> maxArea([1,8,6,2,5,4,8,3,7])
        49
        """
        leftBar, rightBar, maxArea = 0, len(height) - 1, 0

        while leftBar < rightBar:
        	if height[leftBar] > height[rightBar]:
        		maxArea, rightBar = max(maxArea, height[rightBar] * (rightBar - leftBar)), rightBar - 1
        	else:
        		maxArea, leftBar = max(maxArea, height[leftBar] * (rightBar - leftBar)), leftBar + 1

        return maxArea



# # MY SOLUTION 1
# class Solution:
#     def maxArea(self, height):
#         """
#         :type height: List[int]
#         :rtype: int

#         >>> maxArea = Solution().maxArea
#         >>> maxArea([1,8,6,2,5,4,8,3,7])
#         49
#         """
#         leftBar, rightBar, maxArea = 0, len(height) - 1, 0

#         while leftBar < rightBar:
#         	maxArea = max(maxArea, min(height[leftBar], height[rightBar]) * (rightBar - leftBar))
#         	if height[leftBar] > height[rightBar]:
#         		rightBar -= 1
#         	else:
#         		leftBar += 1

#         return maxArea