// Solution 1: Two Queues + O(N) pop + O(1) push
// Runtime: 43ms
class MyStack {
  private Queue<Integer> q1;
  private Queue<Integer> q2;
  private int top;
  
  /** Initialize your data structure here. */
  public MyStack() {
      q1 = new LinkedList<>();
      q2 = new LinkedList<>();
  }
  
  /** Push element x onto stack. */
  public void push(int x) {
      q1.offer(x);
      top = x;
  }
  
  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
      while (q1.size() > 2) {
          q2.offer(q1.poll());
      }
      
      if (q1.size() == 2) {
          top = q1.poll();
          q2.offer(top);
      }
      
      int res = q1.poll();
      
      Queue<Integer> temp = q1;
      q1 = q2;
      q2 = temp;
      
      return res;
  }
  
  /** Get the top element. */
  public int top() {
      return top;
  }
  
  /** Returns whether the stack is empty. */
  public boolean empty() {
      return q1.isEmpty();
  }
}



// Solution 2: Two Queues + O(N) push + O(1) pop
// Runtime: 43ms
class MyStack {
  private Queue<Integer> q1;
  private Queue<Integer> q2;
  private int top;
  
  /** Initialize your data structure here. */
  public MyStack() {
      q1 = new LinkedList<>();
      q2 = new LinkedList<>();
  }
  
  /** Push element x onto stack. */
  public void push(int x) {
      q2.offer(x);
      
      while (!q1.isEmpty()) {
          q2.offer(q1.poll());
      }
      
      Queue<Integer> temp = q1;
      q1 = q2;
      q2 = temp;
  }
  
  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
      return q1.poll();
  }
  
  /** Get the top element. */
  public int top() {
      return q1.peek();
  }
  
  /** Returns whether the stack is empty. */
  public boolean empty() {
      return q1.isEmpty();
  }
}



// Solution 3: One Queue + O(N) push + O(1) pop
// Runtime: 43ms
class MyStack {
  private Queue<Integer> queue;
  
  /** Initialize your data structure here. */
  public MyStack() {
      queue = new LinkedList<>();
      queue = new LinkedList<>();
  }
  
  /** Push element x onto stack. */
  public void push(int x) {
      queue.offer(x);
      
      int count = 0;
      while (count < queue.size() - 1) {
          queue.offer(queue.poll());
          count ++;
      }
  }
  
  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
      return queue.poll();
  }
  
  /** Get the top element. */
  public int top() {
      return queue.peek();
  }
  
  /** Returns whether the stack is empty. */
  public boolean empty() {
      return queue.isEmpty();
  }
}