class Solution {
    public String longestPalindrome(String s) {
        String longestPal = "";
        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i ++) {
            if (i > 0) {
                String res = findLongestPalindrome(s, 1, i - 1, i + 1);
                if (longestPal.length() <= res.length()) {
                    longestPal = res;
                }
            }

            if (i >= 0) {
                String res = findLongestPalindrome(s, 0, i, i + 1);
                if (longestPal.length() <= res.length()) {
                    longestPal = res;
                }
            }
        }

        return longestPal;
    }

    private String findLongestPalindrome(String s, int length, int idxLeft, int idxRight) {
        while (idxLeft >= 0 && idxRight < s.length()) {
            if (s.charAt(idxLeft) != s.charAt(idxRight)) {
                break;
            }
            length += 2;
            idxLeft --;
            idxRight ++;
        }
        return s.substring(idxLeft + 1, idxRight);
    }
}