// Author: Code-Beast

/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    let addParenthesis = function(prev, numToOpen, numToClose) {
        if (numToOpen === 0) {
            for (let i = 0; i < numToClose; i ++) {
                prev += ')';
            }
            return [prev];
        } else if (numToClose === 0 || numToOpen > numToClose) {
            return [];
        } else {
            let comb1 = addParenthesis(prev + '(', numToOpen - 1, numToClose),
                comb2 = addParenthesis(prev + ')', numToOpen, numToClose - 1);
            return comb1.concat(comb2);
        }
    }
    
    if (n === 0) return [];
    
    return addParenthesis("", n, n);
};