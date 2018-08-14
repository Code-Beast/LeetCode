// Author: Code-Beast

/**
 * @param {string} s
 * @return {boolean}
 */

// MY SOLUTION 2 (normal for loop)
var isValid = function(s) {
    let closeMap = {
        '(': ')',
        '[': ']',
        '{': '}'
    };

    let closeStack = [];

    for (let i = 0; i < s.length; i ++) {
        let char = s[i];
        if (closeMap[closeStack[closeStack.length - 1]] === char) {
            closeStack.pop();
        } else {
            closeStack.push(char);
        }
    }
    return closeStack.length === 0;
};


// MY SOLUTION 1 (for loop with 'of')
var isValid = function(s) {
    let closeMap = {
        '(': ')',
        '[': ']',
        '{': '}'
    };

    let closeStack = [];

    for (let char of s) {
        if (closeMap[closeStack[closeStack.length - 1]] === char) {
            closeStack.pop();
        } else {
            closeStack.push(char);
        }
    }
    return closeStack.length === 0;
};