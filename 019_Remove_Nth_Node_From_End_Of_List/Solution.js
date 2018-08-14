// Author: Code-Beast

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */

var removeNthFromEnd = function(head, n) {
    if (n === 0) {
    	return head;
	}

    let nodes = [];
    let ptr = head;

    while (ptr != null) {
        nodes.push(ptr);
        ptr = ptr.next;
    }
    nodes.push(null);
    
    if (n === nodes.length - 1) {
        return nodes[0].next;
    }
    nodes[nodes.length - n - 2].next = nodes[nodes.length - n];

    return head;
};