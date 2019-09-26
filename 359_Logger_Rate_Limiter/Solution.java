// Solution 1
// Rumtime: 72ms
class Logger {
    private Map<String, Integer> messageMap;
    
    /** Initialize your data structure here. */
    public Logger() {
        messageMap = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messageMap.containsKey(message) && timestamp - messageMap.get(message) < 10) {
            return true;
        }
        
        messageMap.put(message, timestamp);
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */



// Solution 2: getOrDefault
// Runtime: 70ms
class Logger {
    private Map<String, Integer> messageMap;
    
    /** Initialize your data structure here. */
    public Logger() {
        messageMap = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp - messageMap.getOrDefault(message, -10) < 10) {
            return false;
        }
        
        messageMap.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */