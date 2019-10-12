// Solution 1: Floyd Warshall Algorithm
// Runtime: 4ms
class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      Map<String, Map<String, Double>> resMap = new HashMap<>();
      
      for (int i = 0; i < equations.size(); i ++) {
          List<String> equation = equations.get(i);
          Map<String, Double> numeratorMap = resMap.getOrDefault(equation.get(0), new HashMap<String, Double>());
          Map<String, Double> denominatorMap = resMap.getOrDefault(equation.get(1), new HashMap<String, Double>());
                                                                   
          numeratorMap.put(equation.get(1), values[i]);
          denominatorMap.put(equation.get(0), 1 / values[i]);
          
          resMap.put(equation.get(0), numeratorMap);
          resMap.put(equation.get(1), denominatorMap);
      }
      
      for (String k : resMap.keySet()) {
          for (String i : resMap.keySet()) {
              for (String j : resMap.keySet()) {
                  if (k.equals(i) || i.equals(j) || j.equals(k)) continue;
                  if (resMap.get(i).containsKey(k) && resMap.get(k).containsKey(j)) {
                      resMap.get(i).put(j, Math.min(resMap.get(i).getOrDefault(j, Double.MAX_VALUE), resMap.get(i).get(k) * resMap.get(k).get(j)));
                  }                   
              }
          }
      }
      
      double[] res = new double[queries.size()];
      Arrays.fill(res, Double.MAX_VALUE);
                                        
      for (int i = 0; i < res.length; i ++) {
          List<String> query = queries.get(i);
          String numerator = query.get(0);
          String denominator = query.get(1);
          
          if (!resMap.containsKey(numerator) || !resMap.containsKey(denominator)) {
              res[i] = -1.0;
          } else if (numerator.equals(denominator)) {
              res[i] = 1.0;
          } else if (!resMap.containsKey(numerator) || !resMap.get(numerator).containsKey(denominator)) {
              res[i] = -1.0;
          } else {
              res[i] = resMap.get(numerator).get(denominator);
          }
      }
                                        
      return res;
  }
}



// Solution 2: Union Find
// Runtime: 1ms
class Solution {
    private class DSU {
        public Map<String, String> parentMap;
        public Map<String, Integer> sizeMap;
        public Map<String, Double> relationMap;
        
        public DSU(List<List<String>> equations) {
            parentMap = new HashMap<>();
            sizeMap = new HashMap<>();
            relationMap = new HashMap<>();
            
            for (List<String> equation : equations) {
                String numerator = equation.get(0);
                String denominator = equation.get(1);
                
                parentMap.putIfAbsent(numerator, numerator);
                parentMap.putIfAbsent(denominator, denominator);
                
                sizeMap.putIfAbsent(numerator, 1);
                sizeMap.putIfAbsent(denominator, 1);
                
                relationMap.putIfAbsent(numerator, 1.0);
                relationMap.putIfAbsent(denominator, 1.0);
            } 
        }
        
        public String find(String x) {
            if (!parentMap.containsKey(x)) {
                return null;
            }
                
            String parent = parentMap.get(x);
            
            if (!parent.equals(x)) {
                parentMap.put(x, find(parent));
                relationMap.put(x, relationMap.get(x) * relationMap.get(parent));
            }
            
            return parentMap.get(x);
        }
        
        public void union(String x, String y, double relation) {
            String parentX = find(x);
            String parentY = find(y);
            
            if (!parentX.equals(parentY)) {
                if(sizeMap.get(parentX) >= sizeMap.get(parentY)) {
                    parentMap.put(y, parentX);
                    sizeMap.put(parentX, sizeMap.get(parentX) + 1);
                    relationMap.put(parentY, relationMap.get(x) * relation / relationMap.get(y));
                } else {
                    parentMap.put(x, parentY);
                    sizeMap.put(parentY, sizeMap.get(parentY) + 1);
                    relationMap.put(parentX, relationMap.get(y) / (relation * relationMap.get(x)));
                }
            }
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        DSU dsu = new DSU(equations);
        
        for (int i = 0; i < equations.size(); i ++) {
            List<String> equation = equations.get(i);
            
            dsu.union(equation.get(0), equation.get(1), values[i]);
        }
        
        double[] res = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i ++) {
            List<String> query = queries.get(i);
            
            String numerator = query.get(0);
            String denominator = query.get(1);
            
            String parent1 = dsu.find(numerator);
            String parent2 = dsu.find(denominator);
            
            if (parent1 == null || parent2 == null) {
                res[i] = -1.0;
            } else if (numerator.equals(denominator)) {
                res[i] = 1.0;
            } else if (parent1.equals(parent2)) {
                res[i] = dsu.relationMap.get(denominator) / dsu.relationMap.get(numerator);
            } else {
                res[i] = -1.0;
            }
        }
        
        return res;
    }
}
