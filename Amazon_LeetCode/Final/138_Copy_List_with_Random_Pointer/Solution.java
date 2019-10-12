// Solution 1: HashMap and LinkedList
// Runtime: 3ms
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
  public Node copyRandomList(Node head) {
      if (head == null) {
          return null;
      }
      
      if (head.next == null) {
          Node node = new Node();
          
          node.val = head.val;
          node.next = null;
          
          if (head.random == null) {
              node.random = null;
          } else {
              node.random = node;
          }
      
          return node;
      }
      
      List<Integer> orderedValues = new ArrayList<>();
      Node ptr = head;
      Map<Node, Integer> idxMap = new HashMap<>();
      
      while (ptr != null) {
          orderedValues.add(ptr.val);
          idxMap.put(ptr, orderedValues.size() - 1);
          
          ptr = ptr.next;
      }
      
      LinkedList<Node> newNodeList = new LinkedList<>();
      for (int i = orderedValues.size() - 1; i >= 0; i --) {
          Node node = new Node();
          
          node.val = orderedValues.get(i);
          node.next = ptr;
          ptr = node;
          
          newNodeList.addFirst(ptr);
      }
      
      Node res = ptr;
      ptr = head;
      while (ptr != null) {
          int idx = idxMap.get(ptr);
          
          if (ptr.random == null) {
              newNodeList.get(idx).random = null;
              
          } else { 
              int randomIdx = idxMap.get(ptr.random);
              newNodeList.get(idx).random = newNodeList.get(randomIdx);
          }
          
          ptr = ptr.next;
      }
      
      return res;
  }
}



// Solution 2: HashMap
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
  public Node copyRandomList(Node head) {
      Node ptr = head;
      Map<Node, Node> map = new HashMap<>();
      
      while (ptr != null) {
          Node node = new Node();
          
          node.val = ptr.val;
          map.put(ptr, node);
          
          ptr = ptr.next;
      }
      
      ptr = head;
      while (ptr != null) {
          Node node = map.get(ptr);
          
          node.next = map.get(ptr.next);
          node.random = map.get(ptr.random);
          
          ptr = ptr.next;
      }
      
      return map.get(head);
  }
}