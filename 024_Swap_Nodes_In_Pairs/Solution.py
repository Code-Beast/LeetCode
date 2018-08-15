#!python3
# Author: Code-Beast

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# MY SOLUTION 1 (Recursion)
# Runtime: 32ms
class Solution:
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
        	return head

        nextPair = head.next.next
        newHead = head.next
        newHead.next = head
        head.next = self.swapPairs(nextPair)

        return newHead

