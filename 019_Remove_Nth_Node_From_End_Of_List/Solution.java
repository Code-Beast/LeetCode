// Author: Code-Beast

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }

        List<ListNode> nodes = new ArrayList<>();
        ListNode ptr = head;

        while (ptr != null) {
            nodes.add(ptr);
            ptr = ptr.next;
        }
        nodes.add(null);

        if (n == nodes.size() - 1) {
            return nodes.get(0).next;
        }
        nodes.get(nodes.size() - n - 2).next = nodes.get(nodes.size() - n);

        return head;
    }
}



// // Oficial Solution
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         ListNode first = dummy;
//         ListNode second = dummy;
//         // Advances first pointer so that the gap between first and second is n nodes apart
//         for (int i = 1; i <= n + 1; i++) {
//             first = first.next;
//         }
//         // Move first to the end, maintaining the gap
//         while (first != null) {
//             first = first.next;
//             second = second.next;
//         }
//         second.next = second.next.next;
//         return dummy.next;
//     }
// }