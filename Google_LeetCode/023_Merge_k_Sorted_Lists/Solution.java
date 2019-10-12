// Solution 1： Brute Force
// Runtime: 241ms
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
          return null;
      }
      
      if (lists.length == 1) {
          return lists[0];
      }
      
      ListNode dummyHead = new ListNode(0);
      ListNode ptr = dummyHead;
      int n = lists.length;
      int countNull = 0;
      
      while (true) {
          int minIdx = -1;
          int minVal = Integer.MAX_VALUE;
              
          for (int i = 0; i < n; i ++) {
              ListNode head = lists[i];
              
              if (head == null) {
                  continue;
              }
              
              if (head.val < minVal) {
                  minIdx = i;
                  minVal = head.val;
              }
          }
          
          if (minIdx == -1) {
              break;
          }
          
          ptr.next = lists[minIdx];
          ptr = ptr.next;
          
          lists[minIdx] = lists[minIdx].next;
      }
      
      return dummyHead.next;
  }
}



// Solution 2: PriorityQueue;
// Runtime: 5ms
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
          return null;
      }
      
      if (lists.length == 1) {
          return lists[0];
      }
      
      int n = lists.length;
      PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
         public int compare(ListNode a, ListNode b) {
             return a.val - b.val;
         } 
      });
      
      for (ListNode list : lists) {
          if (list != null) {
              pq.add(list);
          }
      }
      
      ListNode dummyHead = new ListNode(0);
      ListNode ptr = dummyHead;
      while (!pq.isEmpty()) {
          ptr.next = pq.poll();
          ptr = ptr.next;
          
          if (ptr.next != null) {
              pq.add(ptr.next);
          }
      }
      
      return dummyHead.next;
  }
}