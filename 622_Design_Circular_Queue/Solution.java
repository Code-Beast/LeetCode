class MyCircularQueue {

    private int[] queue;
    private int size;
    private int capacity;
    private int front;
    private int rear;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        size = 0;
        front = 0;
        rear = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size < capacity) {
            queue[rear] = value;
            rear = (rear + 1) % capacity;
            size ++;
            return true;
        }
        
        return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size > 0) {
            size --;
            front = (front + 1) % capacity;
            return true;
        }
        
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (size != 0) {
            return queue[front];   
        }
        
        return -1; // if size is 0
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (size != 0) {
            return queue[(rear + capacity - 1) % capacity];
        }
        
        return -1; // if size is 0
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
