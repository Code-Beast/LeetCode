// Author: Code-Beast

// MY SOLUTION 2 (Another Divide And Conquer And mergeTwoLists()) 
// Runtime: 10ms
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /**
         * Definition for singly-linked list.
         * function ListNode(val) {
         *     this.val = val;
         *     this.next = null;
         * }
         */
        /**
         * @param {ListNode[]} lists
         * @return {ListNode}
         */
        // Handle boundary condiotion
        if (lists.length == 0) return null;

        // Divide and Conquer
        int length = lists.length,
            interval = 1;
        while (interval < length) {
            for (int i = 0; i < length - interval; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }
    
    // Definition of mergeTwolists()
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;

        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}


// // MY SOLUTION 1 (Divide And Conquer And mergeTwoLists()) 
// // Runtime: 10ms
// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         /**
//          * Definition for singly-linked list.
//          * function ListNode(val) {
//          *     this.val = val;
//          *     this.next = null;
//          * }
//          */
//         /**
//          * @param {ListNode[]} lists
//          * @return {ListNode}
//          */  
//         int length = lists.length;

//         if (length == 0) {
//             return null;
//         }

//         if (length == 1) {
//             return lists[0];
//         } else if (length == 2) {
//             return mergeTwoLists(lists[0], lists[1]);
//         } else {
//             return mergeTwoLists(mergeKLists(lists.slice(0, length / 2)), mergeKLists(lists.slice(length / 2, length)));
//         }
//     }
    
//     // Definition of mergeTwolists()
//     private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         if (l1 == null) return l2;

//         if (l2 == null) return l1;

//         if (l1.val <= l2.val) {
//             l1.next = mergeTwoLists(l1.next, l2);
//             return l1;
//         } else {
//             l2.next = mergeTwoLists(l1, l2.next);
//             return l2;
//         }
//     }
// }