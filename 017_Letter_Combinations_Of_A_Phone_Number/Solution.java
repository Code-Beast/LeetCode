// Author: Code-Beast

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }

        String[] digitLetterMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> combs = new ArrayList<String>(),
                    res = new ArrayList<String>();
        combs.add("");

        for (int i = 0; i < digits.length(); i ++) {
            for (int j = 0; j < combs.size(); j ++) {
                for (int k = 0; k < digitLetterMap[digits.charAt(i) - '2'].length(); k ++) {
                    res.add(combs.get(j) + digitLetterMap[digits.charAt(i) - '2'].charAt(k));
                }
            }
            combs = res;
            res = new ArrayList<String>();
        }

        return combs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}