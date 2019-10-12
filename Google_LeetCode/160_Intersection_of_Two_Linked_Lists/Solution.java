/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) {
          return null;
      }

      ListNode pa = headA, pb = headB;
      
      while (pa != pb) {
          pa = (pa != null) ? pa.next : headB;
          pb = (pb != null) ? pb.next : headA;
      }
      
      return pa;
  }
}