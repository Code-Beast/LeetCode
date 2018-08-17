// Author: Code-Beast

// MY SOLUTION 3 (Two pass without extra space)
// Runtime: 60ms
/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    let maxLength = 0,
        countOpen = 0,
        countClose = 0,
        i = 0;
    
    while (i < s.length) {
        if (s[i] === '(') {
            countOpen ++;
        } else {
            countClose ++;
        }
        
        if (countOpen == countClose) {
            let length = countOpen + countClose;
            maxLength = length > maxLength ? length : maxLength;
        } else if (countOpen < countClose) {
            countOpen = 0;
            countClose = 0;
        }
            
        i ++;
    }

    countOpen = 0;
    countClose = 0;
    i = s.length - 1;
        
    while (i >= 0) {
        if (s[i] === ')') {
            countOpen ++;
        } else {
            countClose ++;
        }
        
        if (countOpen == countClose) {
            let length = countOpen + countClose;
            maxLength = length > maxLength ? length : maxLength;
        } else if (countOpen < countClose) {
            countOpen = 0;
            countClose = 0;
        }
            
        i --;
    }

    return maxLength;
};



// // MY SOLUTION 2 (Stack)
// // Runtime: 60ms
// /**
//  * @param {string} s
//  * @return {number}
//  */
// var longestValidParentheses = function(s) {
//     let stack = [-1],
//         length = 0,
//         maxLength = 0;
//     for (let i = 0; i < s.length; i ++) {
//         if (s[i] === '(') {
//             stack.push(i);
//         } else {
//             stack.pop();
//             if (stack.length === 0) {
//                 stack.push(i);
//             }
//             length = i - stack[stack.length - 1];
//             maxLength = maxLength >= length ? maxLength : length;
//         }
//     }
    
//     return maxLength;
// };



// // MY SOLUTION 1 (Dynamic Programming)
// // Runtime: 60ms
// /**
//  * @param {string} s
//  * @return {number}
//  */
// var longestValidParentheses = function(s) {
//     // Using dp[i] to store the length of the longest valid parenthesis substring ending with s[i]
//     let dp = [];

//     // maxLength updates as dp grows
//     let maxLength = 0;

//     // Find the longest valid parenthesis substring vai dynamic programming
//     for (let i = 0; i < s.length; i ++) {
//         if (i >= 1 && s[i] === ')' && s[i - 1] === '(') {
//             dp.push((i >= 2 ? dp[i - 2] : 0) + 2);
//             maxLength = maxLength >= dp[i] ? maxLength : dp[i];
//         } else if (i >= 1 && s[i] === ')' && s[i - 1] === ')' && i - dp[i - 1] - 1 >= 0 && s[i - dp[i - 1] - 1] == '(') {
//             dp.push(dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2);
//             maxLength = maxLength >= dp[i] ? maxLength : dp[i];
//         } else {
//             dp.push(0);
//         }
//     }

//     return maxLength;
// };