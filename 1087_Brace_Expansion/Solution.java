// Solution 1: dfs
// Runtime: 2ms
class Solution {
    public String[] expand(String S) {
        List<String> list = new ArrayList<>();
        int n = S.length();
        
        for (int i = 0; i < n; i ++) {
            if (S.charAt(i) == '{') {
                int j = i + 1;
                StringBuilder sb = new StringBuilder();
                while (j < n && S.charAt(j) != '}') {
                    if (S.charAt(j) == ',') {
                        j ++;
                        continue;
                    }
                    sb.append(S.charAt(j));
                    j ++;
                }
            
                i = j;
                list.add(sb.toString());
            } else {
                list.add(S.charAt(i) + "");
            }
        }
        
        List<String> res = new ArrayList<>();
        dfs(list, res, new StringBuilder(), 0);
        
        int size = res.size();
        int index = 0;
        String[] result = new String[size];
        for (String s : res) {
            result[index ++] = s;
        }
        
        Arrays.sort(result);
        return result;
    }
    
    private void dfs(List<String> list, List<String> res, StringBuilder sb, int pos) {
        if (sb.length() == list.size()) {
            res.add(sb.toString());
            return;
        }
        
        for (char c : list.get(pos).toCharArray()) {
            sb.append(c);
            dfs(list, res, sb, pos + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}