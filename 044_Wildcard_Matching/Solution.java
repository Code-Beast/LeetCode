// Author: Code-Beast

// // MY SOLUTION 1 (Dynamic Programming 2D Table)
// // Runtime: 40ms
// // Note: boolean array elements default to false
// class Solution {
//     public boolean isMatch(String string, String pattern) {
//         boolean[][] dpMatrix = new boolean[string.length() + 1][pattern.length() + 1];

//         dpMatrix[0][0] = true;

//         // Empty pattern
//         // for (int i = 1; i < string.length() + 1; i ++) {
//         // 	dpMatrix[i][0] = false;
//         // }

//         // Empty string
//         // for (int j = 1; j < pattern.length() + 1; j ++) {
//         // 	dpMatrix[0][j] = (dpMatrix[0][j - 1] == true && pattern.charAt(j) == '*') ? true : false;
//         // }
//         for (int j = 1; j < pattern.length() + 1; j ++) {
//         	if (!(dpMatrix[0][j - 1] == true && pattern.charAt(j - 1) == '*')) {
//         		break;
//         	}

//         	dpMatrix[0][j] = true;
//         }

//         // Dynamic programming
//         for (int i = 1; i < string.length() + 1; i ++) {
//         	for (int j = 1; j < pattern.length() + 1; j ++) {
//         		if (string.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
//         			dpMatrix[i][j] = dpMatrix[i - 1][j - 1];
//         		} else if (pattern.charAt(j - 1) == '*') {
//         			dpMatrix[i][j] = dpMatrix[i][j - 1] || dpMatrix[i - 1][j];
//         		}
//         		// else {
//         		// 	dpMatrix[i][j] = false;
//         		// }
//         	}
//         }

//         return dpMatrix[string.length()][pattern.length()];
//     }
// }



// // MY SOLUTION 2 (Recursion)
// // Runtime: Time Limit Exceeded
// class Solution {
//     public boolean isMatch(String string, String pattern) {
//     	// if (string.length() == 0) {
//     	// 	int j = 0;
//     	// 	while (j < pattern.length()) {
//     	// 		if (!(pattern.charAt(j) == '*')) {
//     	// 			return false;
//     	// 		}
//     	// 	}
//     	// 	return true;
//     	// }

//     	// if (pattern.length() == 0) {
//     	// 	return string.length == 0;
//     	// }

//         return isMatchHelper(string, pattern, string.length() - 1, pattern.length() - 1);
//     }

//     private boolean isMatchHelper(String string, String pattern, int strIdx, int ptnIdx) {
//     	if (strIdx < 0) {
//     		while (ptnIdx >= 0) {
//     			if (pattern.charAt(ptnIdx) != '*') {
//     				return false;
//     			}
//                 ptnIdx --;
//     		}
//     		return true;
//     	}

//     	if (ptnIdx < 0) {
//     		return false;
//     	}

//     	if (string.charAt(strIdx) == pattern.charAt(ptnIdx) || pattern.charAt(ptnIdx) == '?') {
//     		return isMatchHelper(string, pattern, strIdx - 1, ptnIdx - 1);
//     	} else if (pattern.charAt(ptnIdx) == '*') {
//     		return isMatchHelper(string, pattern, strIdx - 1, ptnIdx) || isMatchHelper(string, pattern, strIdx, ptnIdx - 1);
//     	} else {
//     		return false;
//     	}
//     }
// }



// // MY SOLUTION 4 (Recursion Promoted By Skipping Some Unnecessary Recursive Calls)
// // Runtime: Time Limit Exceeded
// class Solution {
//     public boolean isMatch(String string, String pattern) {
    	
//         return isMatchHelper(string, pattern, string.length() - 1, pattern.length() - 1);
//     }

//     private boolean isMatchHelper(String string, String pattern, int strIdx, int ptnIdx) {
//     	if (strIdx < 0) {
//     		while (ptnIdx >= 0) {
//     			if (pattern.charAt(ptnIdx) != '*') {
//     				return false;
//     			}
//                 ptnIdx --;
//     		}
//     		return true;
//     	}

//     	if (ptnIdx < 0) {
//     		return false;
//     	}

//     	if (string.charAt(strIdx) == pattern.charAt(ptnIdx) || pattern.charAt(ptnIdx) == '?') {
//     		return isMatchHelper(string, pattern, strIdx - 1, ptnIdx - 1);
//     	} else if (pattern.charAt(ptnIdx) == '*') {
//     		// Skip extra * because consecutive * is tantamount to one *
//     		while (ptnIdx - 1 >= 0) {
//     			if (pattern.charAt(ptnIdx - 1) != '*') {
//     				break;
//     			}
//     			ptnIdx --;
//     		}

//     		// If we skip all * and get to the 0 position to find out pattern[0] is also star, match succeeds
//     		if (ptnIdx == 0) {
//     			return true;
//     		}

//     		// Skip unnecessary recursive calls
//     		while (strIdx >= 0) {
// 	    		while (strIdx >= 0 && string.charAt(strIdx) != pattern.charAt(ptnIdx - 1) && pattern.charAt(ptnIdx - 1) != '?') {
// 	    			strIdx --;
// 	    		}

// 	    		// If we reach the point that no character before the current one can match pattern[ptnIdx - 1]
// 	    		// which is a non-star character, match fails
// 	    		if (strIdx < 0) {
// 	    			return false;
// 	    		}

// 	    		if (isMatchHelper(string, pattern, strIdx, ptnIdx - 1)) {
// 	    			return true;
// 	    		}

// 	    		// Skip the current string character because of the match failure
// 	    		strIdx --;
// 	    	}
// 	    	return false;
//     	} else {
//     		return false;
//     	}
//     }
// }



// MY SOLUTION 5
// 32ms
class Solution {
    public boolean isMatch(String str, String pattern) {
		// patternPos: the position of the character matched in p
		// strPos: the position of the character matched in s
    	// starPos: the position of the last star matched in p
    	// starMatchedPos: the end of the substring matched with the last star
    	int patternPos = 0;
    	int strPos = 0;
    	int starPos = -1;
    	int starMatchedPos = -1;

    	while (strPos < str.length()) {
			if (patternPos < pattern.length() && (str.charAt(strPos) == pattern.charAt(patternPos) || pattern.charAt(patternPos) == '?')) {
				patternPos ++;
				strPos ++;
			} else if (patternPos < pattern.length() && pattern.charAt(patternPos) == '*') {
				starPos = patternPos;
				starMatchedPos = strPos;
				patternPos ++;
			} else if (starPos != -1) {
				patternPos = starPos + 1;
				starMatchedPos ++;
				strPos = starMatchedPos;
			} else {
				return false;
			}
    	}

    	while (patternPos < pattern.length() && pattern.charAt(patternPos) == '*') {
    		patternPos ++;
    	}

    	return patternPos == pattern.length();
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().isMatch("aa", "*"));
    	System.out.println(new Solution().isMatch("acdcab", "a*c?b"));	
    }
}
