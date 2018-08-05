#!python3

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0
        l3 = ListNode(0);
        res = l3;
        
        while l1 or l2 or carry:

            l3.next = ListNode(0)
            l3 = l3.next
            
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            sum = val1 + val2 + carry
            carry = sum // 10
            l3.val = sum % 10

            if l1: 
                l1 = l1.next
            if l2:
                l2 = l2.next

        return res.next

def main():
    l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next.next = ListNode(3)
    l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next.next = ListNode(4)
    res = Solution().addTwoNumbers(l1,l2)
    print(res.val, res.next.val, res.next.next.val)
    assert(res.val == 7)
    assert(res.next.val == 0)
    assert(res.next.next.val == 8)

if __name__ == '__main__':
    main()