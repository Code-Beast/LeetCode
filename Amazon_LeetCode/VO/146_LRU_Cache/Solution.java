// Solution 3
class LRUCache {
    Map<Integer, ListNode> nodeMap; // store the position of nodes
    ListNode head;
    ListNode tail;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            moveToFront(nodeMap.get(key));
            return nodeMap.get(key).getVal();
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            ListNode removedNode = nodeMap.get(key);
            moveToFront(removedNode);
            removedNode.setVal(value);
        } else {
            ListNode newNode = new ListNode(key, value);
            putAtFront(newNode);
            nodeMap.put(key, newNode);
            if (nodeMap.size() > capacity) {
                removeTail();
            }
        }
    }
    
    private void moveToFront(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        putAtFront(node);
    }
    
    private void putAtFront(ListNode node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }
    
    private void removeTail () {
        if (tail.pre != head) {
            nodeMap.remove(tail.pre.getKey());
            tail.pre.pre.next = tail;
            tail.pre = tail.pre.pre;
        }
    }
    
    private static class ListNode {
        private int key;
        private int val;
        public ListNode next;
        public ListNode pre;
        
        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.pre = null;
        }
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.pre = null;
        }
        
        public void setVal(int val) {
            this.val = val;
        }
        
        public int getVal() {
            return val;
        }
        
        public int getKey() {
            return key;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */



// Solution 2
class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity);
    }

    public void move_to_end(int key) {
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }
    
    public void remove_first() {
        cache.remove(cache.entrySet().iterator().next().getKey());
    }
    
    public int get(int key) {
        if (! cache.containsKey(key)) return -1;
        move_to_end(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) move_to_end(key);
        cache.put(key, value);
        if (cache.size() == capacity + 1) remove_first();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */




// Solution 1
class LRUCache {
    /**
     * HashMap(key, value) and LinkedList(Represent the cache queue)
     * The reason we use linked list is that delete and insert operation is easy
     */
    LinkedList<Integer> cacheQueue;
    Map<Integer, Integer> cacheMap;
    int capacity;
    
    public LRUCache(int capacity) {
        cacheQueue = new LinkedList<>();
        cacheMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
        if (cacheMap.containsKey(key)) {
            cacheQueue.remove(new Integer(key));
            cacheQueue.addFirst(key);
            return cacheMap.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
        if (!cacheMap.containsKey(key)) {
            cacheQueue.addFirst(key);
            cacheMap.put(key, value);
            if (cacheMap.size() > capacity) {
                int removedKey = cacheQueue.removeLast();
                cacheMap.remove(removedKey);
            }
        } else {
            cacheQueue.remove(new Integer(key));
            cacheQueue.addFirst(key);
            cacheMap.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
