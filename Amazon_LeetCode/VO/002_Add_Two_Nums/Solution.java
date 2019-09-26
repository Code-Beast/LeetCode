/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // no empty
        // corner cases: no
        int carry = 0;
        
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        ptr.next = l1;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            
            ptr.next.val = sum;
            ptr = ptr.next;
            if (l1 == null) {
                ptr.next = l2;
            }
        }
        
        if (carry == 1) {
            ptr.next = new ListNode(carry);
        }
        
        return head.next;
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // no empty
        // corner cases: no
        int carry = 0;
        
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next; 
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }
        
        if (carry == 1) {
            ptr.next = new ListNode(carry);
        }
        
        return head.next;
    }
}
