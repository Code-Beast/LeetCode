// O(n) SOLUTION
class Solution {
    public String longestPalindrome(String s) {
        // If s is null or an empty array, return itself
        if (s == null || s.length() == 0) {
            return s;
        }
        
        // Otherwise, insert "#" in between characters including the front and the end
        String newStr = transformString(s);
        
        // Create an array to document the length of Palindrome centered at every character.
        int[] len = new int[newStr.length()];
        
        // Initialize the center and the right edge
        int center = 0, rightEdge = 0;
        
        // Loop through the newStr and implement Manacher's Algorithm
        for (int idx = 0; idx < newStr.length(); idx ++) {
            // If idx is larger than rightEdge, set the initial length to 0
            if (idx >= rightEdge) {
                len[idx] = 0;
            } 
            // Otherwise, set the initial length to the samller one between 
            // the length of the character at the mirrored idx by center and
            // rightEdge - idx
            else {
                int idxMirrored = 2 * center - idx;
                len[idx] = Math.min(len[idxMirrored], rightEdge - idx);
            }
        
            // Based on the initial length, expand to find the correct length
            while (idx - len[idx] - 1 >= 0 && idx + len[idx] + 1 < newStr.length() && newStr.charAt(idx - len[idx] - 1) == newStr.charAt(idx + len[idx] + 1)) {
                len[idx] ++;
            }
            
            // Update center and rightEdge
            if (idx + len[idx] > rightEdge) {
                center = idx;
                rightEdge = idx + len[idx];
            }
        }
        
        // Find the index of the longest palindrome
        int longestIdx = 0;
        for (int i = 0; i < len.length; i ++) {
            if (len[i] >= len[longestIdx]) {
                longestIdx = i;
            }
        }
        
        // Return the longest palindrome, remember to transfrom the index of newStr to the index of s
        int start = (longestIdx - len[longestIdx]) / 2,
            end = (longestIdx + len[longestIdx]) / 2;
        return s.substring(start, end);
    }
    
    /** 
     * This function is used to warp characters with "#"
     */
    private String transformString(String str) {
        String newStr = "";
        
        for (int i = 0; i < str.length(); i ++) {
            newStr = newStr + "#" + str.charAt(i);
        }
        newStr += "#";
        
        return newStr;
    }
}

// MY SOLUTION
// class Solution {
//     public String longestPalindrome(String s) {
//         String longestPal = "";
//         if (s.length() == 1) {
//             return s;
//         }

//         for (int i = 0; i < s.length(); i ++) {
//             if (i > 0) {
//                 String res = findLongestPalindrome(s, 1, i - 1, i + 1);
//                 if (longestPal.length() <= res.length()) {
//                     longestPal = res;
//                 }
//             }

//             if (i >= 0) {
//                 String res = findLongestPalindrome(s, 0, i, i + 1);
//                 if (longestPal.length() <= res.length()) {
//                     longestPal = res;
//                 }
//             }
//         }

//         return longestPal;
//     }

//     private String findLongestPalindrome(String s, int length, int idxLeft, int idxRight) {
//         while (idxLeft >= 0 && idxRight < s.length()) {
//             if (s.charAt(idxLeft) != s.charAt(idxRight)) {
//                 break;
//             }
//             length += 2;
//             idxLeft --;
//             idxRight ++;
//         }
//         return s.substring(idxLeft + 1, idxRight);
//     }
// }

// METHOD 1
// class Solution {
//     public String longestPalindrome(String s) {
//         if (s.length() == 0 || s == null) {
//             return s;
//         }
        
//         int len1, len2;
//         String longestPal = "";
        
//         for (int i = 0; i < s.length(); i ++) {
//             len1 = expandAroundCenter(s, i, i);
//             len2 = expandAroundCenter(s, i, i + 1);
            
//             if (len1 >= longestPal.length()) {
//                 longestPal = s.substring(i - len1 / 2, i + len1 / 2 + 1);
//             }
            
//             if (len2 >= longestPal.length()) {
//                 longestPal = s.substring(i - len2 / 2 + 1, i + len2 / 2 + 1);
//             }
//         }
        
//         return longestPal;
//     }
    
//     private int expandAroundCenter(String s, int left, int right) {
//         while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//             left --;
//             right ++;
//         }
        
//         return right - left - 1;
//     }
// }

// METHOD 2
