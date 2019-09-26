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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        
        while (ptr1 != null && ptr2 != null) {
            ptr1 = ptr1.next;
            if (ptr2.next == null) return null;
            ptr2 = ptr2.next.next;
            if (ptr1 == ptr2) break;
        }
        
        if (ptr2 == null) {
            return null;
        }
        
        ptr1 = head;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return ptr1;
    }
}
