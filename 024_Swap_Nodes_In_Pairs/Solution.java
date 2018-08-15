// Author: Code-Beast

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// MY SOLUTION 1 (Recursion)
// Runtime: 2 ms
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextPair = head.next.next,
                 newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(nextPair);

        return newHead;
    }
}