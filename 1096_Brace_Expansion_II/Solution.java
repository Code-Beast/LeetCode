// Solution 1: Mutual Call + DPS
// Runtime: 9ms
class Solution {
    public List<String> braceExpansionII(String expression) {
        List<String> lst = new ArrayList<>(prod(expression));
        Collections.sort(lst);
        return lst;
    }

    public Set<String> prod(String exp) {
        int sum = 0;
        List<Set<String>> lst = new ArrayList<>();
        int start = -1;
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '{') {
                if (sum == 0)
                    start = i;
                sum++;
                continue;
            }
            if (c == '}'){
                sum--;
                if (sum == 0)
                    lst.add(union(exp.substring(start + 1, i)));
            }
            if (c >= 'a' && c <= 'z' && sum == 0)
                lst.add(new HashSet<>(Collections.singletonList(String.valueOf(c))));
        }

        Set<String> rst = new HashSet<>();
        dfs(0, "", rst, lst);
        return rst;
    }

    public void dfs(int idx, String curr, Set<String> rst, List<Set<String>> lst) {
        if (idx >= lst.size()) {
            rst.add(curr);
            return;
        }
        Set<String> set = lst.get(idx);
        for (String option: set) {
            String next = curr + option;
            dfs(idx + 1, next, rst, lst);
        }
    }

    public Set<String> union(String exp) {
        int sum = 0;
        int start = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '{') sum++;
            if (c == '}') sum--;
            if (c == ',' && sum == 0) {
                set.addAll(prod(exp.substring(start, i)));
                start = i + 1;
            }
        }
        set.addAll(prod(exp.substring(start)));
        return set;
    }
}