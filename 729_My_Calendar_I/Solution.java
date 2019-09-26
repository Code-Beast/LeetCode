// Solution 1: Brute Force
// Runtime: 60ms
class MyCalendar {
  private List<int[]> booked;

  public MyCalendar() {
    booked = new ArrayList<>();
  }

  public boolean book(int start, int end) {
    for (int[] b : booked) {
      if (Math.max(b[0], start) < Math.min(b[1], end)) {
        return false;
      }
    }
    
    booked.add(new int[]{start, end});
    return true;
  }
}



// Solution 2: Binary Search
// Runtime: 76ms
class MyCalendar {
  TreeMap<Integer, Integer> booked;
  
  public MyCalendar() {
    booked = new TreeMap<>();
  }
  
  public boolean book(int start, int end) {
    Integer lb = booked.floorKey(start);
    if (lb != null && booked.get(lb) > start) {
      return false;
    }
    
    Integer ub = booked.ceilingKey(start);
    if (ub != null && ub < end) {
      return false;
    }
    
    booked.put(start, end);
    return true;
  }
}
