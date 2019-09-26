// Solution 1: Diagnol
// Runtime: 500ms
class Solution {
  public int minAreaRect(int[][] points) {
    Set<String> pointSet = new HashSet<>();
    
    for (int[] point : points) {
      pointSet.add("" + point[0] + point[1]);
    }
    
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < points.length; i ++) {
      for (int j = 0; j < points.length; j ++) {
        if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
          if (pointSet.contains("" + points[i][0] + points[j][1]) && pointSet.contains("" + points[j][0] + points[i][1])) {
            ans = Math.min(ans, Math.abs(points[j][0] - points[i][0]) * Math.abs(points[j][1] - points[i][1]));
          }
        }
      }
    }
    
    return ans < Integer.MAX_VALUE ? ans : 0;
  }
}


// Solution 2: TreeSet + HashMap
// Runtime: 116ms
class Solution {
    public int minAreaRect(int[][] points) {
        if(points.length < 4)
            return 0;
        Map<Integer, TreeSet<Integer>> mapX = new HashMap<>();
        List<Integer> listX = new ArrayList<>();
        for(int[] arr : points){
            TreeSet<Integer> tsY = mapX.getOrDefault(arr[0], new TreeSet<Integer>());
            if(tsY.isEmpty())
                listX.add(arr[0]);
            tsY.add(arr[1]);
            mapX.put(arr[0], tsY);
        }
        
        Collections.sort(listX);
        int result = 0;
        for(int i = 0; i < listX.size() - 1; i++){
            TreeSet<Integer> tsY1 = mapX.get(listX.get(i));
            for(int j = i + 1; j < listX.size(); j++){
                TreeSet<Integer> tsY2 = mapX.get(listX.get(j));
                int minArea = getMinArea(tsY1, tsY2, listX.get(j) - listX.get(i));
                if(minArea > 0)
                    result = result == 0 ? minArea : Math.min(minArea, result);
            }
        }
        return result;
    }
    
    private int getMinArea(TreeSet<Integer> tsY1, TreeSet<Integer> tsY2, int distX){
        int res = -1;
        Integer yCache = null;
        for(int y : tsY1){
            if(tsY2.contains(y)){
                if(yCache != null){
                    int area = distX * (y - yCache);
                    res = res < 0 ? area : Math.min(res, area);
                    yCache = y;
                } else
                    yCache = y;
            }
        }
        return res;
    }
}



// Solution 3: TreeSet + HashMap + Diagnol
// Runtime: 400ms
class Solution {
  public int minAreaRect(int[][] points) {
    Map<Integer, TreeSet<Integer>> ySetMap = new HashMap<>();
    
    for (int[] point : points) {
      TreeSet<Integer> ySet = ySetMap.getOrDefault(point[0], new TreeSet<Integer>());
      ySet.add(point[1]);
      ySetMap.putIfAbsent(point[0], ySet);
    }
    
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < points.length; i ++) {
      for (int j = 0; j < points.length; j ++) {
        if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
          if (ySetMap.get(points[i][0]).contains(points[j][1]) && ySetMap.get(points[j][0]).contains(points[i][1])) {
            ans = Math.min(ans, Math.abs(points[j][0] - points[i][0]) * Math.abs(points[j][1] - points[i][1]));
          }
        }
      }
    }
    
    return ans < Integer.MAX_VALUE ? ans : 0;
  }
}