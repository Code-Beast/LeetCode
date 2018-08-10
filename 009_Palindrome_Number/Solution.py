#!python3
# Author: Code-Beast

# MY SOLUTION 4 (Int half algorithm)
class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool

        >>> sol = Solution().isPalindrome;
        >>> sol(121)
        True
        >>> sol(-121)
        False
        >>> sol(10)
        False
        >>> sol(123454321)
        True
        """
        # Handle negative numbers
        if x < 0:
          return False

        # Get the number of digits of x
        xCopy = x
        numOfDigits = 0
        while xCopy != 0:
            numOfDigits += 1
            xCopy //= 10

        # Get the reversed half part of the number
        reversedHalf = 0
        for i in range(numOfDigits // 2):
            reversedHalf = reversedHalf * 10 + x % 10
            x = x // 10

        # Get the other half part
        if numOfDigits % 2 != 0:
            x = x // 10

        return x == reversedHalf 


# MY SOLUTION 3 (String)
# class Solution:
#     def isPalindrome(self, x):
#         """
#         :type x: int
#         :rtype: bool

#         >>> sol = Solution().isPalindrome;
#         >>> sol(121)
#         True
#         >>> sol(-121)
#         False
#         >>> sol(10)
#         False
#         >>> sol(123454321)
#         True
#         """
#         # Cast x to string
#         xString = str(x)

#         if len(xString) % 2 == 0:
#             return xString[len(xString) // 2 :][:: -1] == xString[0 : len(xString) // 2]
#         else:
#             return xString[len(xString) // 2 + 1 :][:: -1] == xString[0 : len(xString) // 2]



# MY SOLUTION 2 (Iteration)
# class Solution:
#     def isPalindrome(self, x):
#         """
#         :type x: int
#         :rtype: bool

#         >>> sol = Solution().isPalindrome;
#         >>> sol(121)
#         True
#         >>> sol(-121)
#         False
#         >>> sol(10)
#         False
#         >>> sol(123454321)
#         True
#         """
#         # Handle negative number
#         if x < 0:
#             return False

#         # Handle zero
#         if x == 0:
#             return True

#         # Get the number of digits of x
#         xCopy = x
#         numOfDigits = 0
#         while xCopy != 0:
#             numOfDigits += 1
#             xCopy //= 10
        
#         # Judge Recursively
#         for i in range(numOfDigits // 2):
#             left = x // pow(10, numOfDigits - 1)
#             right = x % 10
#             if left != right:
#                 return False
#             x = (x - left * pow(10, numOfDigits - 1) - right) // 10
#             numOfDigits -= 2

#         return True



# MY SOLUTION 1 (Recursion)
# class Solution:
#     def isPalindrome(self, x):
#         """
#         :type x: int
#         :rtype: bool

#         >>> sol = Solution().isPalindrome;
#         >>> sol(121)
#         True
#         >>> sol(-121)
#         False
#         >>> sol(10)
#         False
#         >>> sol(123454321)
#         True
#         """
#         # Handle negative numbers
#         if x < 0:
#           return False

#         # Handle zero:
#           if x == 0:
#               return True

#         # Get the number of digits of x
#         xCopy = x
#         numOfDigits = 0
#         while xCopy != 0:
#           numOfDigits += 1
#           xCopy //= 10

#         # Judge recursively
#         return self.__isPalindromeHelper(x, numOfDigits)
        
#     def __isPalindromeHelper(self, x, numOfDigits):
#         if numOfDigits == 0 or numOfDigits == 1:
#           return True

#         left = x // pow(10, numOfDigits - 1)
#         right = x % 10
#         if left == right:
#           x = (x - left * pow(10, numOfDigits - 1) - right) // 10
#           return self.__isPalindromeHelper(x, numOfDigits - 2) 

#         return False