// Solution 1: Two Stacks + O(1) push + O(N) pop
// Runtime: 42ms
class MyQueue {
  private Deque<Integer> stack1;
  private Deque<Integer> stack2;

  /** Initialize your data structure here. */
  public MyQueue() {
      stack1 = new ArrayDeque<>();
      stack2 = new ArrayDeque<>();
  }
  
  /** Push element x to the back of queue. */
  public void push(int x) {
      stack1.push(x);
  }
  
  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
      while (stack1.size() > 1) {
          stack2.push(stack1.pop());
      }
      
      int front = stack1.pop();
      
      while(!stack2.isEmpty()) {
          stack1.push(stack2.pop());
      }
      
      return front;
  }
  
  /** Get the front element. */
  public int peek() {
      while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
      }
      
      int front = stack2.peek();
      
      while(!stack2.isEmpty()) {
          stack1.push(stack2.pop());
      }
      
      return front;
  }
  
  /** Returns whether the queue is empty. */
  public boolean empty() {
      return stack1.isEmpty();
  }
}



// Solution 2: Two Stacks + O(N) push + O(1) pop
// Runtime: 43ms
class MyQueue {
  Deque<Integer> stack1;
  Deque<Integer> stack2;

  /** Initialize your data structure here. */
  public MyQueue() {
      stack1 = new ArrayDeque<>();
      stack2 = new ArrayDeque<>();
  }
  
  /** Push element x to the back of queue. */
  public void push(int x) {
      while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
      }
      
      stack1.push(x);
      
      while (!stack2.isEmpty()) {
          stack1.push(stack2.pop());
      }
  }
  
  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
      return stack1.pop();
  }
  
  /** Get the front element. */
  public int peek() {
      return stack1.peek();
  }
  
  /** Returns whether the queue is empty. */
  public boolean empty() {
      return stack1.isEmpty();
  }
}