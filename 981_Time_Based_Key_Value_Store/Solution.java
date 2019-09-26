// Soltion 1: TreeMap
// Runtime: 260ms
/*
class TimeMap {
  private Map<String, TreeMap<Integer, String>>map;

  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (map.containsKey(key)) {
      map.get(key).put(timestamp, value);
    } else {
      TreeMap<Integer, String> timestampMap = new TreeMap<>();
      timestampMap.put(timestamp, value);
      map.put(key, timestampMap);
    }
  }

  public String get(String key, int timestamp) {
    TreeMap<Integer, String> timestampMap = map.get(key);
    Integer matchedKey = timestampMap.floorKey(timestamp);
    
    return matchedKey != null ? timestampMap.get(matchedKey) : "";
  }
}
*/



// Solution 2: ArrayList and Pair
// Runtime: 200ms
import javafx.util.Pair;

class TimeMap {
  private Map<String, List<Pair<Integer, String>>>map;

  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (map.containsKey(key)) {
      map.get(key).add(new Pair<Integer, String>(timestamp, value));
    } else {
      List<Pair<Integer, String>> timestampMap = new ArrayList<>();
      timestampMap.add(new Pair<Integer, String>(timestamp, value));
      map.put(key, timestampMap);
    }
  }

  public String get(String key, int timestamp) {
    List<Pair<Integer, String>> timestampMap = map.get(key);
    return binarySearch(timestampMap, timestamp);
  }
  
  private String binarySearch(List<Pair<Integer, String>> timestampMap, int target) {
    int lo = 0;
    int hi = timestampMap.size() - 1;
    
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int timestamp = timestampMap.get(0).getKey();
      
      if (timestamp > target) {
        hi = mid;
      } else if (timestamp <= target) {
        lo = mid + 1;
      }
    }
    
    if (timestampMap.get(lo).getKey() <= target) {
      return timestampMap.get(lo).getValue();
    } else if (lo - 1 >= 0 && timestampMap.get(lo - 1).getKey() <= target) {
      return timestampMap.get(lo - 1).getValue();
    } else {
      return "";
    }
  }
}