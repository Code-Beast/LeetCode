// Solution 1: TreeMap
// Runtime: 177ms
class MyCalendarTwo {
  private TreeMap<Integer, Integer> booked;

  public MyCalendarTwo() {
      booked = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    booked.put(start, booked.getOrDefault(start, 0) + 1);
    booked.put(end, booked.getOrDefault(end, 0) - 1);
    
    int activeEvents = 0;
    
    for (int freq : booked.values()) {
      activeEvents += freq;
      if (activeEvents >= 3) {
        booked.put(start, booked.getOrDefault(start, 0) - 1);
        booked.put(end, booked.getOrDefault(end, 0) + 1);
        
        return false;
      }
    }
    
    return true;
  }
}