// Author: Code-Beast


// Definition for singly-linked list.
function ListNode(val) {
    this.val = val;
    this.next = null;
}

// MY SOLUTION 1 (Recursion)
// Runtime: 52 ms
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
    if (!head || !head.next) {
        return head;
    }

    let nextPair = head.next.next,
        newHead = head.next;
    newHead.next = head;
    head.next = swapPairs(nextPair);

    return newHead;
};