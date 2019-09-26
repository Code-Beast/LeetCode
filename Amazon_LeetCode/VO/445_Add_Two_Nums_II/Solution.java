// Solution 2
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
        int carry = 0;

        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
//         ListNode ptr1 = l1;
//         ListNode ptr2 = l2;
        
//         while (ptr1 != null) {
//             System.out.println(ptr1.val);
//             ptr1 = ptr1.next;
//         }
        
//         while (ptr2 != null) {
//             System.out.println(ptr2.val);
//             ptr2 = ptr2.next;
//         }
        
        ListNode head = l1;
        ListNode ptr = head;
        ListNode prev = head;
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

            ptr.val = sum;
            if (l1 == null) {
                ptr.next = l2;
            }
            prev = ptr;
            ptr = ptr.next;
        }

        if (carry == 1) {
            prev.next = new ListNode(carry);
        }
        
        
//         ListNode ptrHead = head;
        
//         while (ptrHead != null) {
//             System.out.println(ptrHead.val);
//             ptrHead = ptrHead.next;
//         }

        return reverseList(head);
    }
    
    private ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}



// Solution 1
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
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        int len1 = 0, len2 = 0;
        
        while (ptr1 != null) {
            ptr1 = ptr1.next;
            len1 ++;
        }
        
        while (ptr2 != null) {
            ptr2 = ptr2.next;
            len2 ++;
        }
        
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i ++) {
                ListNode node = new ListNode(0);
                node.next = l2;
                l2 = node;
            }
        } else if (len2 > len1) {
            for (int i = 0; i < len2 - len1; i ++) {
                ListNode node = new ListNode(0);
                node.next = l1;
                l1 = node;
            }
        }
        
        if (addTwoDigits(l1, l2) == 1) {
            ListNode head = new ListNode(1);
            head.next = l1;
            l1 = head;
        }
        
        return l1;
    }
    
    private int addTwoDigits(ListNode l1, ListNode l2) {
        int sum = 0;
        
        if (l1.next == null) {
            sum = l1.val + l2.val;
        } else {
            sum = addTwoDigits(l1.next, l2.next) + l1.val + l2.val;
        }
        
        l1.val = sum % 10;
        return sum >= 10 ? 1 : 0;
    }
}
