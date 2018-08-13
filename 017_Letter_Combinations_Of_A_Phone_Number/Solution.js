// Author: Code-Beast

/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
        if (digits.length === 0) {
            return [];
        }

        let digitLetterMap = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        };

        let combs = [''],
            res = [];

        for (let i = 0; i < digits.length; i ++) {
            for (let j = 0; j < combs.length; j ++) {
                for (let k = 0; k < digitLetterMap[digits[i]].length; k ++) {
                    res.push(combs[j] + digitLetterMap[digits[i]].charAt(k));
                }
            }
            combs = res;
            res = [];
        }

        return combs;
};