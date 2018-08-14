#!python3
# Author: Code_Beast

# MY SOLUTION 2 (list as Stack)
class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool

        >>> isValid = Solution().isValid
        >>> isValid("()")
        True
        >>> isValid("()[]{}")
        True
        >>> isValid("(]")
        False
        >>> isValid("([)]")
        False
        >>> isValid("{[]}")
        True
        """
        closeMap = {
        	'(': ')',
        	'[': ']',
        	'{': '}'
        }

        closeStack = []

        for char in s:
        	if not closeStack == [] and closeStack[-1] in closeMap and closeMap[closeStack[-1]] == char:
        		closeStack.pop()
        	else:
        		closeStack.append(char)

        return closeStack == []



# # MY SOLUTION 1 (user-defined Stack)
# # Stack definition
# class Stack:
#     # Initialize the stack
#     def __init__(self):
#         self.items = []

#     # Determine whether the stack is empty
#     def isEmpty(self):
#         return self.items == []

#     # Return the top element of the stack
#     def peek(self):
#         return self.items[-1]

#     # Return the size of the stack
#     def size(self):
#         return len(self.items)

#     # Put a new element on the top of the stack
#     def push(self, item):
#         self.items.append(item)

#     # Pop the top element out of the stack
#     def pop(self):
#         return self.items.pop()

# class Solution:
#     def isValid(self, s):
#         """
#         :type s: str
#         :rtype: bool

#         >>> isValid = Solution().isValid
#         >>> isValid("()")
#         True
#         >>> isValid("()[]{}")
#         True
#         >>> isValid("(]")
#         False
#         >>> isValid("([)]")
#         False
#         >>> isValid("{[]}")
#         True
#         """
#         closeMap = {
#         	'(': ')',
#         	'[': ']',
#         	'{': '}'
#         }

#         closeStack = Stack()

#         for char in s:
#         	if not closeStack.isEmpty() and closeStack.peek() in closeMap and closeMap[closeStack.peek()] == char:
#         		closeStack.pop()
#         	else:
#         		closeStack.push(char)

#         return closeStack.isEmpty()




