// Author: Code-Beast

class Solution {
    public String intToRoman(int num) {
    
    	return intToRomanHelper(num, 0);
    }

    private String intToRomanHelper(int num, int level) {
     	String[][] romanMap = new String[2][];
     	romanMap[0] = new String[] {"I", "X", "C", "M"};
     	romanMap[1] = new String[] {"V", "L", "D"};
    	String res = "";

        if (num == 9) {
            return romanMap[0][level] + romanMap[0][level + 1];
        } else if (num < 9 && num >= 5) {
            res = romanMap[1][level];
            for (int i = 0; i < num - 5; i ++) {
                res += romanMap[0][level];
            }
            return res;
        } else if (num == 4) {
            return romanMap[0][level] + romanMap[1][level];
        } else if (num < 4) {
            res = "";
            for (int i = 0; i < num; i ++) {
                res += romanMap[0][level];
            }
            return res;
        } else {
            return intToRomanHelper(num / 10, level + 1) + intToRomanHelper(num % 10, level);
        }
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.intToRoman(1994));
    }
}