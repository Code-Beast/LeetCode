// Author: Code-Beast

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

// MY SOLUTION 1 (Recursion)
// Runtime: 72ms
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
    if (head === null || k === 1) {
        return head;
    }

    let curr = head,
        count = 0;
    while (curr != null && count < k) {
        count ++;
        curr = curr.next;
    }

    if (count === k) {
        let rest = curr != null ? reverseKGroup(curr, k) : null;
        curr = head;
        let lastNode;
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
};