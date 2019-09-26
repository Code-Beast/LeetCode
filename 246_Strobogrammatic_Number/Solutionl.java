// Solution 1: Two Pointers
// Runtime: 0ms
class Solution {
    private Map<Character, Character> map;
    
    public boolean isStrobogrammatic(String num) {
        map = new HashMap<>();
        map.put('0', '0');
        map.put('9', '6');
        map.put('6', '9');
        map.put('8', '8');
        map.put('1', '1');
        
        if (num == null || num.length() == 0) {
            return false;
        }
        
        if (num.charAt(0) == '0' && num.length() != 1) {
            return false;
        }
        
        if (num.length() == 1 && (num.charAt(0) != '0' && num.charAt(0) != '1' && num.charAt(0) != '8')) {
            return false;
        }
        
        int l = 0;
        int r = num.length() - 1;
        
        while (l <= r) {
            if (!map.containsKey(num.charAt(l)) || map.get(num.charAt(l)) != num.charAt(r)) {
                return false;
            }
            
            l ++;
            r --;
        }
        
        return true;
    }
}