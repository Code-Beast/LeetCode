// Solution 3
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsH(lists, 0, lists.length-1);
    }

    public ListNode mergeKListsH(ListNode[] lists, int start, int end){
        if (start >end ) {
            return null;
        } else if (start == end) {
            return lists[start];
        } else {
            int mid = (end + start) / 2;
            return mergeLists(mergeKListsH(lists, start, mid), mergeKListsH(lists, mid+1, end));
        }
    }

    public ListNode mergeLists(ListNode n1, ListNode n2){
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        
        while (n1 != null && n2 != null){
            if (n1.val <= n2.val){
                tmp.next = n1;
                n1 = n1.next;
            } else {
                tmp.next = n2;
                n2 = n2.next;
            }
            
            tmp = tmp.next;
        }

        tmp.next = n1 == null ? n2 : n1;

        return head.next;
    }
}



//Solution 2
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        ListNode dummyHead = new ListNode(0);
        ListNode ptr = dummyHead;

        for (ListNode list : lists) {
            if (list != null)
                pq.add(list);
        }

        while (pq.size() > 0) {
            ListNode node = pq.poll();
            ptr.next = node;
            ptr = ptr.next;
            if (node.next != null)
                pq.add(node.next);
        }

        return dummyHead.next;
    }
}



//Solution 1
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        ListNode dummyHead = new ListNode(0);
        ListNode ptr = dummyHead;
        
        for (ListNode list : lists) {
            if (list != null)
                pq.add(list);
        }
        
        while (pq.size() > 0) {
            ListNode node = pq.poll();
            ptr.next = node;
            ptr = ptr.next;
            if (node.next != null)
                pq.add(node.next);
        }
        
        return dummyHead.next;
    }
}
