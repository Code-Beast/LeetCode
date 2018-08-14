#!python3
# Author: Code-Beast

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# MY SOLUTION 1 (Iteration)
class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # Set up dummy head nodes
        dummyHead = ListNode(0)
        dummyHead.next = l1

        ptr1, ptr2 = l1, l2
        ptr1Prev = dummyHead


        # Loop through l1 and l2 and merge
        while ptr1 != None and ptr2 != None:
            if ptr1.val <= ptr2.val:
                ptr1Prev = ptr1Prev.next
                ptr1 = ptr1.next
            else:
                temp = ptr2
                ptr2 = ptr2.next
                temp.next = ptr1
                ptr1Prev.next =temp
                ptr1Prev = ptr1Prev.next

        if ptr1 == None:
            ptr1Prev.next = ptr2

        return dummyHead.next



# # MY SOLUTION 2 (Recursion)
# class Solution:
#     def mergeTwoLists(self, l1, l2):
#         """
#         :type l1: ListNode
#         :type l2: ListNode
#         :rtype: ListNode
#         """
#         if l1 == None:
#             return l2
        
#         if l2 == None:
#             return l1

#         if l1.val <= l2.val:
#             head = l1
#             head.next = self.mergeTwoLists(l1.next, l2)
#         else:
#             head = l2
#             head.next = self.mergeTwoLists(l1, l2.next)

#         return head