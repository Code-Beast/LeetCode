#!python3
# Author: Code-Beast

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# MY SOLUTION 3 (Recursion: The best solution)
# Runtime: 60ms
class Solution:
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if head == None or k == 1:
            return head

        curr = head
        count = 0
        while curr != None and count < k:
            count += 1
            curr = curr.next
            
        if count == k:
            rest = self.reverseKGroup(curr, k) if curr != None else None
            curr = head
            while count > 0:
                lastNode = curr.next
                curr.next = rest
                rest = curr
                curr = lastNode
                count -= 1
            head = rest
        return head



# # MY SOLUTION 2 (Using List And Recursion)
# # Runtime: 60ms
# class Solution:
#     def reverseKGroup(self, head, k):
#         """
#         :type head: ListNode
#         :type k: int
#         :rtype: ListNode
#         """
#         if k == 1:
#             return head

#         toReverse = []
#         ptr1 = ptr2 = head
#         count = 0
#         while ptr1 != None:
#             count += 1
#             toReverse.append(ptr1)
#             if count == k:
#                 nextReverse = ptr1.next
#                 for i in range(len(toReverse)):
#                     if i > 0:
#                         toReverse[i].next = toReverse[i - 1]
#                 toReverse[0].next = self.reverseKGroup(nextReverse, k) if ptr1.next != None else None
#                 head = ptr1
#                 break

#             ptr1 = ptr1.next

#         return head



# # MY SOLUTION 1 (Using swap() and Recursion)
# # Rumtime: 300ms
# class Solution:
#     def reverseKGroup(self, head, k):
#         """
#         :type head: ListNode
#         :type k: int
#         :rtype: ListNode
#         """
#         if k == 1:
#             return head

#         ptr1 = ptr2 = head
#         count = 0
#         while ptr1 != None:
#             count += 1
#             if count == k:
#                 nextReverse = self.reverseKGroup(ptr1.next, k)
#                 for i in range(k // 2):
#                     self.swap(ptr2, k - i * 2)
#                     ptr2 = ptr2.next

#             break

#             ptr1 = ptr1.next

#         return head

#     def __swap(self, head, k):
#         """
#         :type head: ListNode
#         :type k: int
#         :rtype: ListNode
#         """
#         if k == 1:
#             return head

#         ptr = head
#         ptrPrev = head
#         count = 0
#         while ptr != None:
#             count += 1
#             if count == k:
#                 rest = ptr.next
#                 ptr.next = head if k == 2 else head.next
#                 ptrPrev.next = head.next if k == 2 else head
#                 head.next = rest
#                 head = ptr
#                 break
#             ptr = ptr.next
#             if count > 1:
#                 ptrPrev = ptrPrev.next

#         return head



# # WRONG SOLUTION (Due TO Misunderstanding Of The Problem)
# class Solution:
#     def reverseKGroup(self, head, k):
#         """
#         :type head: ListNode
#         :type k: int
#         :rtype: ListNode
#         """
#         if k == 1:
#             return head

#         ptr = head
#         ptrPrev = head
#         count = 0
#         while ptr != None:
#             count += 1
#             if count == k:
#                 nextSwap = ptr.next
#                 ptr.next = head if k == 2 else head.next
#                 ptrPrev.next = head.next if k == 2 else head
#                 head.next = self.reverseKGroup(nextSwap, k) if nextSwap != None else None
#                 head = ptr
#                 break
#             ptr = ptr.next
#             if count > 1:
#                 ptrPrev = ptrPrev.next

#         return head