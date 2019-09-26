class Solution {
  private Map<String, List<Integer>> resultMap = new HashMap<>();
  
  public List<Integer> diffWaysToCompute(String input) {
    if (resultMap.containsKey(input)) {
      return resultMap.get(input);
    }
    
    List<Integer> ans = new ArrayList<>();
    
    for (int i = 0; i < input.length(); i ++) {
      char op = input.charAt(i);
      
      if (op == '+' || op == '-' || op == '*') {
        String left = input.substring(0, i);
        String right = input.substring(i + 1);
        
        List<Integer> l = diffWaysToCompute(left);
        List<Integer> r = diffWaysToCompute(right);
        
        switch (op) {
          case '+': {
            for (int a : l) {
              for (int b : r) {
                ans.add(a + b);
              }
            }
            
            break;
          }
            
          case '-': {
            for (int a : l) {
              for (int b : r) {
                ans.add(a - b);
              }
            }
            
            break;
          }
            
          case '*': {
            for (int a : l) {
              for (int b : r) {
                ans.add(a * b);
              }
            }
            
            break;
          }
        }
      }
    }
    
    if (ans.size() == 0) {
      ans.add(Integer.valueOf(input));
    }
    
    resultMap.put(input, ans);
    return ans;
  }
}