// Solution 1: HashMap
// Runtime: 86 ms
class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
      Map<Integer, List<String>> map = new HashMap<>();
      
      for (int i = 0; i < list1.length; i ++) {
          for (int j = 0; j < list2.length; j ++) {
              if (list1[i].equals(list2[j])) {
                  if (!map.containsKey(i + j)) 
                      map.put(i + j, new ArrayList<String>());
                  map.get(i + j).add(list1[i]);
              }
          }
      }
      
      int minIndexSum = Integer.MAX_VALUE;
      for (int key : map.keySet())
          minIndexSum = Math.min(minIndexSum, key);
      
      String[] res = new String[map.get(minIndexSum).size()];
      return map.get(minIndexSum).toArray(res);
  }
}



// Solution 2: Using A Little Trick
// Runtime: 30ms
class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
      List<String> res = new ArrayList<>();
      
      for (int sum = 0; sum < list1.length + list2.length - 1; sum ++) {
          for (int i = 0; i <= sum; i ++) {
              if (i < list1.length && sum - i < list2.length && list1[i].equals(list2[sum - i]))
                  res.add(list1[i]);
          }
          
          if (res.size() > 0) break;
      }
      
      return res.toArray(new String[res.size()]);
  }
}



// Solution 3: Use Both HashMap and the Little Trick
class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
      Map<String, Integer> map = new HashMap<>();
      List<String> res = new LinkedList<>();
      int minSum = Integer.MAX_VALUE;
      for (int i=0;i<list1.length;i++) map.put(list1[i], i);
      for (int i=0;i<list2.length;i++) {
          Integer j = map.get(list2[i]);
          if (j != null && i + j <= minSum) {
              if (i + j < minSum) { res.clear(); minSum = i+j; }
              res.add(list2[i]);
          }
      }
      return res.toArray(new String[res.size()]);
  }
}