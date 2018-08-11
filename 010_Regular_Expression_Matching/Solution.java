// Official Solution cited from:
// https://leetcode.com/problems/regular-expression-matching/solution/
class Solution {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                                       (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}


// // MY SOLUTION 2 (recursion)
// class Solution {
//     private String str;
//     private String pattern;

//     public boolean isMatch(String s, String p) {
//         str = s;
//         pattern = p;

//         return isMatchHelper(0, 0);
//     }

//     private boolean isMatchHelper(int sStart, int patternStart) {
//         int strLength = str.length();
//         int patternLength = pattern.length();
        
//         // Handle empty string
//         if (patternLength == patternStart) {
//             return (strLength == sStart);
//         }

//         // Handle successful matching
//         else if (strLength - sStart >= 1 && (str.charAt(sStart) == pattern.charAt(patternStart) || pattern.charAt(patternStart) == '.')) {
//             if (patternLength - patternStart >= 2 && pattern.charAt(patternStart + 1) == '*') {
//                 return isMatchHelper(sStart, patternStart + 2) | isMatchHelper(sStart + 1, patternStart);
//             } else {
//                 return isMatchHelper(sStart + 1, patternStart + 1);
//             }
//         }

//         // Handle repeating
//         else if (patternLength - patternStart >= 2 && pattern.charAt(patternStart + 1) == '*') {
//             return isMatchHelper(sStart, patternStart + 2);
//         }

//         // Handle matching failures
//         else {
//             return false;
//         }
//     }
// }



// // MY SOLUTION 1 (Recursion with a 2D array)
// class Solution {
//     private String str;
//     private String pattern;
//     private int[][] memo;
    
//     public boolean isMatch(String s, String p) {
//         str = s;
//         pattern = p;
//         memo = new int[str.length() + 1][pattern.length() + 1];
//         for (int[] m : memo) {
//             java.util.Arrays.fill(m, -1);
//         }

//         return isMatchHelper(0, 0) == 1 ? true : false;
//     }

//     private int isMatchHelper(int sStart, int patternStart) {
//         int strLength = str.length();
//         int patternLength = pattern.length();
//         int ans = 0;

//         // Handle existing record
//         if (memo[sStart][patternStart] != -1) {
//             return memo[sStart][patternStart];
//         }

//         // Handle empty string
//         else if (patternLength == patternStart) {
//             ans = (strLength == sStart) ? 1 : 0;
//         }

//         // Handle successful matching
//         else if (strLength - sStart >= 1 && (str.charAt(sStart) == pattern.charAt(patternStart) || pattern.charAt(patternStart) == '.')) {
//             if (patternLength - patternStart >= 2 && pattern.charAt(patternStart + 1) == '*') {
//                 ans = isMatchHelper(sStart, patternStart + 2) | isMatchHelper(sStart + 1, patternStart);
//             } else {
//                 ans = isMatchHelper(sStart + 1, patternStart + 1);
//             }
//         }

//         // Handle repeating
//         else if (patternLength - patternStart >= 2 && pattern.charAt(patternStart + 1) == '*') {
//             ans = isMatchHelper(sStart, patternStart + 2);
//         }

//         // Handle matching failures
//         else {
//             ans = 0;
//         }

//         memo[sStart][patternStart] = ans;
//         return ans;
//     }
// }