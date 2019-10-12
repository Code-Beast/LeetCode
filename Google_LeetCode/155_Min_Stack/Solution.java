// Solution 0: Linked List
// Runtime: 46ms
class MinStack {
  private class Node{
      int value;
      int min;
      Node next;
      
      Node(int x, int min) {
          this.value=x;
          this.min=min;
          next = null;
      }
  }
  private Node head;
  
  public void push(int x) {
      if (head == null) {
          head = new Node(x, x);
      } else {
          Node n = new Node(x, Math.min(x, head.min));
          n.next = head;
          head = n;
      }
  }

  public void pop() {
      if(head!=null)
          head =head.next;
  }

  public int top() {
      if(head != null)
          return head.value;
      return -1;
  }

  public int getMin() {
      if(head != null)
          return head.min;
      return -1;
  }
}



// Solution 1: Deque
// Runtime: 47ms
class MinStack {
  private Deque<Integer> stack;

  /** initialize your data structure here. */
  public MinStack() {
      stack = new ArrayDeque<>();
  }
  
  public void push(int x) {
      int prevMin = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
      int curMin = Math.min(prevMin, x);
      
      stack.push(x);
      stack.push(curMin);
  }
  
  public void pop() {
      stack.pop();
      stack.pop();
  }
  
  public int top() {
      int curMin = stack.pop();
      int top = stack.peek();
      
      stack.push(curMin);
      
      return top;
  }
  
  public int getMin() {
      return stack.peek();
  }
}



// Solution 2: Deque + Field Min
// Runtime: 47ms
class MinStack {
  private Deque<Integer> stack;
  private int min;

  /** initialize your data structure here. */
  public MinStack() {
      stack = new ArrayDeque<>();
      min = Integer.MAX_VALUE;
  }
  
  public void push(int x) {
      int curMin = Math.min(min, x);
      
      min = curMin;
      stack.push(x);
      stack.push(curMin);
  }
  
  public void pop() {
      stack.pop();
      stack.pop();
      
      min = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
  }
  
  public int top() {
      int curMin = stack.pop();
      int top = stack.peek();
      
      stack.push(curMin);
      
      return top;
  }
  
  public int getMin() {
      return min;
  }
}



// Solution 3: Deque + Field Min
// Runtime: 47ms
class MinStack {
  private Deque<Integer> stack;
  private int min;

  /** initialize your data structure here. */
  public MinStack() {
      stack = new ArrayDeque<>();
      min = Integer.MAX_VALUE;
  }
  
  public void push(int x) {
      int curMin = Math.min(min, x);
      
      if (curMin <= x) {
          stack.push(x);
          stack.push(curMin);
          
          min = curMin;
      } else {
          stack.push(x);
      }
  }
  
  public void pop() {
      if (stack.pop() == min) {
          stack.pop();
          
          min = stack.isEmpty() ? Integer.MAX_VALUE : (stack.peek() > min ? stack.peek() : min);
      };
  }
  
  public int top() {
      if (stack.peek() != min) {
          return stack.peek();
      }
      
      stack.pop();
      int top = stack.peek();
      stack.push(min);
      
      return top;
  }
  
  public int getMin() {
      return min;
  }
}