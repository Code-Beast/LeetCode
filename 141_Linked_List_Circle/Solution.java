// Author: Code-Beast

// MY SOLUTION 1 (Using Double Pointers)
// Runtime: 0ms
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
        	return false;
        }

        ListNode l1 = head, l2 = head;
        while (l1 != null && l2 != null && l2.next != null) {
        	l1 = l1.next;
        	l2 = l2.next.next;
            
        	if (l1 == l2) {
        		return true;
        	}
        }
        
        return false;
    }

    public static void main(String[] args) {

    }
}