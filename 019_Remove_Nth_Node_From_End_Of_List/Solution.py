#!python3
# Author: Code-Beast

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# MY SOLUTION 2 (Double Pointers: Not As Stable As Solution 1)
class Solution:
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        count = 0
        dummyHead = ListNode(0)
        dummyHead.next = head
        ptr1 = ptr2 = dummyHead
        

        while ptr1 != None:
            count += 1
            ptr1 = ptr1.next

            if count > n + 1:
                ptr2 = ptr2.next
        
        ptr2.next = ptr2.next.next

        return dummyHead.next



# # MY SOLUTION 1
# class Solution:
#     def removeNthFromEnd(self, head, n):
#         """
#         :type head: ListNode
#         :type n: int
#         :rtype: ListNode
#         """
#         if n == 0:
#             return head

#         nodes = []
#         ptr = head

#         while ptr != None:
#             nodes.append(ptr)
#             ptr = ptr.next
#         nodes.append(None)

#         if n == len(nodes) - 1:
#             return nodes[0].next
#         nodes[-n - 2].next = nodes[-n]

#         return head


