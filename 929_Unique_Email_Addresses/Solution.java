// Solution 1
// Runtime: 12ms
class Solution {
  public int numUniqueEmails(String[] emails) {
    Set<String> set = new HashSet<>();
  
    for (String email : emails) {
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < email.length(); i ++) {
        char ch = email.charAt(i);
        if (ch == '.') {
          continue;
        } else if (ch == '+') {
          while (email.charAt(i) != '@') {
            i ++;
          }
          
          i --;
        } else if (ch == '@') {
          sb.append(email.substring(i));
          break;
        } else {
          sb.append(ch);
        }
      }
      
      set.add(sb.toString());
    }
    
    System.out.println(set);
    return set.size();
  }
}