// Author: Code-Beast

// MY SOLUTION 2 (objects as maps)
// Runtime: 20ms

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == "" || words.length == 0) return new ArrayList<Integer>();

        // Initialize and define import values
        int wordLength = words[0].length(),
            wordListLength = words.length,
            subStrLength = wordListLength * wordLength,
            strLength = s.length();

        // Handle a 100% failure
        if (strLength < subStrLength) return new ArrayList<Integer>();

        // Construct the word map
        // And find the substring value to find
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Iteration for to find substrings which contains the exactly same number of every word in wordCountMap
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < wordLength; i ++) {
            int left = i,
                right = i;
            Map<String, Integer> newWordCountMap = new HashMap<>();
            while (right < strLength - wordLength + 1) {
                String currWord = s.substring(right, right + wordLength);
                if (!wordCountMap.containsKey(currWord)) {
                    newWordCountMap.clear();
                    right += wordLength;
                    left = right;
                } else {
                    newWordCountMap.put(currWord, newWordCountMap.getOrDefault(currWord, 0) + 1);
                    right += wordLength;
                    if (newWordCountMap.get(currWord) > wordCountMap.get(currWord)) {
                        while (left < right) {
                            newWordCountMap.replace(s.substring(left, left + wordLength), newWordCountMap.get(s.substring(left, left + wordLength)) - 1);
                            left += wordLength;
                            if (s.substring(left - wordLength, left).equals(currWord)) break;
                        }
                    }

                    if (right - left == subStrLength) {
                        res.add(left);
                        newWordCountMap.replace(s.substring(left, left + wordLength), newWordCountMap.get(s.substring(left, left + wordLength)) - 1);
                        left += wordLength;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = {"bar", "foo", "the"};
        System.out.println(new Solution().findSubstring("barfoofoobarthefoobarman", words));
    }
}