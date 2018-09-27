// Author: Code-Beast

// MY SOLUTION 1 (Using Double Pointers)
// Runtime: 20ms
import java.util.List;
import java.util.Arrays;

class Solution {
    public String findLongestWord(String s, List<String> d) {
    	String longestWord = "";
    	int maxLength = 0;
        for (String word : d) {
        	int wordLength = word.length();
        	if (wordLength > s.length()) {
        		continue;
        	}

        	if (findWord(s, word)) {
        		if (wordLength > maxLength || (wordLength == maxLength && word.compareTo(longestWord) < 0)) {
        			longestWord = word;
        			maxLength = wordLength;
        		}
        	}
        }

        return longestWord;
    }

    private boolean findWord(String s, String word) {
    	int sLeft = 0, wordLeft = 0;
    	int sRight = s.length() - 1, wordRight = word.length() - 1;

    	while (sLeft <= sRight) {
    		if (s.charAt(sLeft) == word.charAt(wordLeft)) {
    			wordLeft ++;
    		}
    		sLeft ++;

    		if (s.charAt(sRight) == word.charAt(wordRight)) {
    			wordRight --;
    		}
    		sRight --;

    		if (wordLeft > wordRight) {
    			return true;
    		}
    	}

    	return false;
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().findLongestWord("abpcplea", Arrays.asList("ale","apple", "apcle", "monkey","plea")));
    }
}