// Author: Code-Beast


// MY SOLUTION 1
// Runtime: 5ms
class Solution {
    public int strStr(String haystack, String needle) {
        int lenNeedle = needle.length(),
            lenHaystack = haystack.length();

        // Handle searching for an empty string
        if (lenNeedle == 0) {
            return 0;
        }

        // Handle a longer string to search for than the string to search
        if (lenHaystack < lenNeedle) {
            return -1;
        }

        int j = 0;
        for (int i = 0; i < lenHaystack - lenNeedle + 1; i ++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                int test = i;
                while (test < lenHaystack && j < lenNeedle && haystack.charAt(test) == needle.charAt(j)) {
                    test ++;
                    j ++;
                }
                if (j == lenNeedle) return i;
                j = 0;
            }
        }

        return -1;
    }
}