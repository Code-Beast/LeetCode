// Author: Code-Beast

// MY SOLUTION 1 (Recursion)
// Runtime: 4ms
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            count ++;
            curr = curr.next;
        }

        if (count == k) {
            ListNode rest = curr != null ? reverseKGroup(curr, k) : null;
            curr = head;
            ListNode lastNode;
            while (count > 0) {
                lastNode = curr.next;
                curr.next = rest;
                rest = curr;
                curr = lastNode;
                count --;
            }
            head = rest;
        }
        return head;
    }
}