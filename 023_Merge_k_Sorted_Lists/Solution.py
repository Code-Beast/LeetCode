#!python3
# Author: Code-Beast

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# MY SOLUTION 4 (Divide And Conquer And mergeTwoLists())
# Runtime: 180ms
class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        # Handle boundary condiotion
        if not lists:
            return None

        # Divide and Conquer
        length = len(lists)
        interval = 1
        while interval < length:
            for i in range(0, length - interval, interval * 2):
                lists[i] = self.__mergeTwoLists(lists[i], lists[i + interval])
            interval *= 2

        return lists[0]

    def __mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None:
            return l2
        
        if l2 == None:
            return l1

        if l1.val <= l2.val:
            l1.next = self.__mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.__mergeTwoLists(l1, l2.next)
            return l2



# # MY SOLUTION 3 (Using Heapq and Deafaultdict)
# # Runtime: 80ms
# class Solution:
#     def mergeKLists(self, lists):
#         """
#         :type lists: List[ListNode]
#         :rtype: ListNode
#         """
#         # Using heapq to implement priority queue
#         from heapq import heappop, heappush, heapreplace, heapify

#         # Because push an item with an existant key into a heapq would cause an error
#         # We use a 2D key composed of ListNode.val and count which is documented by a defaultdict called countDict
#         from collections import defaultdict

#         # Set up the dummy head
#         ptr = dummyHead = ListNode(0)

#         # Initilize coutdict
#         countDict = defaultdict(int)

#         # Initialize the heap
#         heap = []
#         for li in lists:
#             if li:
#                 heappush(heap, (li.val, countDict[li.val], li))
#                 countDict[li.val] += 1

#         # Handle boundary condition
#         if not heap:
#             return None

#         # Merge K lists using a priority queue
#         while heap:
#             val, count, item = heap[0]
#             ptr.next = item
#             ptr = item

#             if not ptr.next:
#                 heappop(heap)
#             else:
#                 heapreplace(heap, (ptr.next.val, countDict[ptr.next.val], ptr.next))
#                 countDict[ptr.next.val] += 1

#         return dummyHead.next



# # MY SOLUTION 2 (Using mergeTwoLists())
# # Runtime: 140ms
# class Solution:
#     def mergeKLists(self, lists):
#         """
#         :type lists: List[ListNode]
#         :rtype: ListNode
#         """
#         length = len(lists)

#         if length == 0:
#             return None

#         if length == 1:
#             return lists[0]

#         elif length == 2:
#             return self.__mergeTwoLists(lists[0], lists[1])

#         else:
#             return self.__mergeTwoLists(self.mergeKLists(lists[: length // 2]), self.mergeKLists(lists[length // 2:]))

#     def __mergeTwoLists(self, l1, l2):
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
#             l1.next = self.__mergeTwoLists(l1.next, l2)
#             return l1
#         else:
#             l2.next = self.__mergeTwoLists(l1, l2.next)
#             return l2



# # MY SOLUTION 1 (Time Limit Exceeded, Actually, There Is No Need To Use Recursion: Look At Solution 3)
# # Runtime: Time Limit Exceeded
# class Solution:
#     def mergeKLists(self, lists):
#         """
#         :type lists: List[ListNode]
#         :rtype: ListNode
#         """
#         lists = [li for li in lists if li != None]

#         if lists == []:
#             return None

#         lists.sort(key = self.__value)
#         minNode = lists[0]
#         lists[0] = lists[0].next
#         minNode.next = self.mergeKLists(lists)
#         return minNode


#     def __value(self, li):
#         return li.val



def main():
    # Test 1
    list1 = ListNode(1);
    list1.next = ListNode(4);
    list1.next.next = ListNode(5);

    list2 = ListNode(1);
    list2.next = ListNode(3);
    list2.next.next = ListNode(4);

    list3 = ListNode(2);
    list3.next = ListNode(6);

    lists = [list1, list2, list3]
    mergedList = Solution().mergeKLists(lists)

    print("Test One")
    while mergedList != None:
        print(mergedList.val)
        mergedList = mergedList.next

    # Test 2
    mergedList = Solution().mergeKLists([None, None])

    print("Test Two")

if __name__ == '__main__':
    main()