#!python3
# Author: Code-Beast

class Solution:

    # convert function
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str

        >>> Solution().convert("PAYPALISHIRING", 3)
        'PAHNAPLSIIGYIR'
        >>> Solution().convert("PAYPALISHIRING", 4)
        'PINALSIGYAHRPI'
        >>> Solution().convert("A", 1)
        'A'
        """
        # Initialize counters
        row = -1
        direction = 1

        # If numRows = 1
        if numRows == 1: return s

        # Create a list of strings to store zigzag information
        zigzagList = ["" for i in range(numRows)]
       
        for char in s:
            # Get the current row and update the direction
            row += direction
            if row == (numRows - 1) and direction == 1: direction = -1
            if row == 0 and direction == -1: direction = 1
         
            zigzagList[row] += char

        # Get the corresponding string
        res = ''.join(zigzagList)

        return res


# MY SOLUTION 3
# class Solution:

#     # convert function
#     def convert(self, s, numRows):
#         """
#         :type s: str
#         :type numRows: int
#         :rtype: str

#         >>> Solution().convert("PAYPALISHIRING", 3)
#         'PAHNAPLSIIGYIR'
#         >>> Solution().convert("PAYPALISHIRING", 4)
#         'PINALSIGYAHRPI'
#         >>> Solution().convert("A", 1)
#         'A'
#         """
#         # Initialize counters
#         row = 0
#         isAscending = True

#         # If numRows = 1
#         if numRows == 1:
#             return s

#         # Create a list of strings to store zigzag information
#         zigzagList = ["" for i in range(numRows)]

#         for char in s:
#             if row == 0:
#                 row = 1
#                 isAscending = True
#                 zigzagList[0] += char
#             elif row == numRows - 1:
#                 row = numRows - 2
#                 isAscending = False
#                 zigzagList[numRows - 1] += char
#             elif isAscending == True:
#                 row += 1
#                 zigzagList[row - 1] += char
#             else:
#                 row -= 1
#                 zigzagList[row + 1] += char

#         # Get the corresponding string
#         res = ''.join(zigzagList)

#         return res



# MY SOLUTION 2
# class Solution:

#     # convert function
#     def convert(self, s, numRows):
#         """
#         :type s: str
#         :type numRows: int
#         :rtype: str

#         >>> Solution().convert("PAYPALISHIRING", 3)
#         'PAHNAPLSIIGYIR'
#         >>> Solution().convert("PAYPALISHIRING", 4)
#         'PINALSIGYAHRPI'
#         >>> Solution().convert("A", 1)
#         'A'
#         """
#         # Initialize counters
#         self.counterInit(numRows)

#         # Create a 2-D list to store zigzag information
#         zigzagList = [[] for i in range(numRows)]
#         for char in s:
#             zigzagList[self.getRow()].append(char)

#         # Get the corresponding string
#         res = ''.join(''.join(arr) for arr in zigzagList)

#         return res

#     # Initialize row counter
#     def counterInit(self, numRows):
#         self.row = 0
#         self.isAscending = True
#         self.numRows = numRows

#     # getRow function
#     def getRow(self):
#         # if numRows = 1
#         if self.numRows == 1:
#             return 0

#         # if numRows != 1
#         if self.row == 0:
#             self.row = 1
#             self.isAscending = True
#             return 0
#         elif self.row == self.numRows - 1:
#             self.row = self.numRows - 2
#             self.isAscending = False
#             return self.numRows - 1
#         elif self.isAscending:
#             self.row += 1
#             return self.row - 1
#         else:
#             self.row -= 1
#             return self.row + 1



# MY SOLUTION 1
# class Solution:

#     # convert function
#     def convert(self, s, numRows):
#         """
#         :type s: str
#         :type numRows: int
#         :rtype: str

#         >>> Solution().convert("PAYPALISHIRING", 3)
#         'PAHNAPLSIIGYIR'
#         >>> Solution().convert("PAYPALISHIRING", 4)
#         'PINALSIGYAHRPI'
#         >>> Solution().convert("A", 1)
#         'A'
#         """
#         # Initialize counters
#         self.counterInit(numRows)

#         # Create an array to store zigzag information
#         zigzagArray = [];
#         for char in s:
#             zigzagArray.append([(self.getRow(), self.getCol()), char]);

#         # Sort the array for output
#         zigzagArray.sort(key = lambda x: x[0][1]);
#         zigzagArray.sort(key = lambda x: x[0][0]);


#         # Get the corresponding string
#         res ="";
#         for element in zigzagArray:
#             res += element[1];

#         return res

#     # Initialize row counter and column counter
#     def counterInit(self, numRows):
#         self.row = 0
#         self.col = 0
#         self.isAscending = True
#         self.countRepetition = 0
#         self.numRows = numRows

#     # getRow function
#     def getRow(self):
#         # if numRows = 1
#         if self.numRows == 1:
#             return 0

#         # if numRows != 1
#         if self.row == 0:
#             self.row = 1
#             self.isAscending = True
#             return 0
#         elif self.row == self.numRows - 1:
#             self.row = self.numRows - 2
#             self.isAscending = False
#             return self.numRows - 1
#         elif self.isAscending:
#             self.row += 1
#             return self.row - 1
#         else:
#             self.row -= 1
#             return self.row + 1
    
#     # getCol function
#     def getCol(self):
#         # if numRows = 1
#         if self.numRows == 1:
#             self.col += 1
#             return self.col - 1

#         # if numRows != 1
#         if self.col % (self.numRows - 1) == 0 and self.countRepetition != self.numRows:
#             self.countRepetition += 1
#         else:
#             self.countRepetition = 0
#             self.col += 1
#             if self.col % (self.numRows - 1) == 0:
#                 self.countRepetition = 1
#         return self.col

# # Test getRow() and getCol()
# def main():
#     converter = Solution()
#     converter.counterInit(4)

#     # Test getRow()
#     print("Test getRow() 20 times:")
#     for i in range(20):
#         print(str(i) + ": " + str(converter.getRow()))

#     # Test getCol()
#     print("Test getCol() 20 times:")
#     for i in range(20):
#         print(str(i) + ": " + str(converter.getCol()))
    
# if __name__ == "__main__":
#     main()

