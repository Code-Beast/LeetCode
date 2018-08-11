// Author: Code-Beast  

// MY SOLUTION 3 (Recursion with an 2D array)
var isMatch = function(s, pattern) {
    const strLength = s.length;
    const patternLength = pattern.length;
    const memo = Array(s.length + 1).fill(null).map(() => {
        return Array(pattern.length + 1).fill(undefined);
    });

    let ans = false;

    let isMatchHelper = function(sStart, patternStart) {
        // Handle existing record
        if (memo[sStart][patternStart] != undefined) {
            return memo[sStart][patternStart];
        }

        // Handle empty string
        else if (patternLength === patternStart) {
            ans = (strLength === sStart);
        }

        // Handle successful matching
        else if (strLength - sStart >= 1 && (s[sStart] === pattern[patternStart] || pattern[patternStart] === '.')) {
            if (patternLength - patternStart >= 2 && pattern[patternStart + 1] == '*') {
                ans = isMatchHelper(sStart, patternStart + 2) || isMatchHelper(sStart + 1, patternStart);
            } else {
                ans = isMatchHelper(sStart + 1, patternStart + 1);
            }
        }

        // Handle repeating
        else if (patternLength - patternStart >= 2 && pattern[patternStart + 1] === '*') {
            ans = isMatchHelper(sStart, patternStart + 2);
        }

        // Handle matching failures
        else {
            ans = false;
        }

        memo[sStart][patternStart] = ans;
        return ans;
    }

    return isMatchHelper(0, 0);
};



// /** This solution is cited from:
//  *  https://leetcode.com/problems/regular-expression-matching/discuss/142237/JavaScript-dynamic-programming-solution
//  */

// const ZERO_OR_MORE_CHARS = '*';
// const ANY_CHAR = '.';

// var isMatch = function(string, pattern) {
//   /*
//    * Let's initiate dynamic programming matrix for this string and pattern.
//    * We will have pattern characters on top (as columns) and string characters
//    * will be placed to the left of the table (as rows).
//    *
//    * Example:
//    *
//    *     a * b . b
//    *   - - - - - -
//    * a - - - - - -
//    * a - - - - - -
//    * b - - - - - -
//    * y - - - - - -
//    * b - - - - - -
//    */
//   const matchMatrix = Array(string.length + 1).fill(null).map(() => {
//     return Array(pattern.length + 1).fill(null);
//   });

//   // Let's fill the top-left cell with true. This would mean that empty
//   // string '' matches to empty pattern ''.
//   matchMatrix[0][0] = true;

//   // Let's fill the first row of the matrix with false. That would mean that
//   // empty string can't match any non-empty pattern.
//   //
//   // Example:
//   // string: ''
//   // pattern: 'a.z'
//   //
//   // The one exception here is patterns like a*b* that matches the empty string.
//   for (let columnIndex = 1; columnIndex <= pattern.length; columnIndex += 1) {
//     const patternIndex = columnIndex - 1;

//     if (pattern[patternIndex] === ZERO_OR_MORE_CHARS) {
//       matchMatrix[0][columnIndex] = matchMatrix[0][columnIndex - 2];
//     } else {
//       matchMatrix[0][columnIndex] = false;
//     }
//   }

//   // Let's fill the first column with false. That would mean that empty pattern
//   // can't match any non-empty string.
//   //
//   // Example:
//   // string: 'ab'
//   // pattern: ''
//   for (let rowIndex = 1; rowIndex <= string.length; rowIndex += 1) {
//     matchMatrix[rowIndex][0] = false;
//   }

//   // Not let's go through every letter of the pattern and every letter of
//   // the string and compare them one by one.
//   for (let rowIndex = 1; rowIndex <= string.length; rowIndex += 1) {
//     for (let columnIndex = 1; columnIndex <= pattern.length; columnIndex += 1) {
//       // Take into account that fact that matrix contain one extra column and row.
//       const stringIndex = rowIndex - 1;
//       const patternIndex = columnIndex - 1;

//       if (pattern[patternIndex] === ZERO_OR_MORE_CHARS) {
        
//          * In case if current pattern character is special '*' character we have
//          * two options:
//          *
//          * 1. Since * char allows it previous char to not be presented in a string we
//          * need to check if string matches the pattern without '*' char and without the
//          * char that goes before '*'. That would mean to go two positions left on the
//          * same row.
//          *
//          * 2. Since * char allows it previous char to be presented in a string many times we
//          * need to check if char before * is the same as current string char. If they are the
//          * same that would mean that current string matches the current pattern in case if
//          * the string WITHOUT current char matches the same pattern. This would mean to go
//          * one position up in the same row.
         
//         if (matchMatrix[rowIndex][columnIndex - 2] === true) {
//           matchMatrix[rowIndex][columnIndex] = true;
//         } else if (
//           (
//             pattern[patternIndex - 1] === string[stringIndex] ||
//             pattern[patternIndex - 1] === ANY_CHAR
//           ) &&
//           matchMatrix[rowIndex - 1][columnIndex] === true
//         ) {
//           matchMatrix[rowIndex][columnIndex] = true;
//         } else {
//           matchMatrix[rowIndex][columnIndex] = false;
//         }
//       } else if (
//         pattern[patternIndex] === string[stringIndex] ||
//         pattern[patternIndex] === ANY_CHAR
//       ) {
//         /*
//          * In case if current pattern char is the same as current string char
//          * or it may be any character (in case if pattern contains '.' char)
//          * we need to check if there was a match for the pattern and for the
//          * string by WITHOUT current char. This would mean that we may copy
//          * left-top diagonal value.
//          *
//          * Example:
//          *
//          *   a b
//          * a 1 -
//          * b - 1
//          */
//         matchMatrix[rowIndex][columnIndex] = matchMatrix[rowIndex - 1][columnIndex - 1];
//       } else {
//         /*
//          * In case if pattern char and string char are different we may
//          * treat this case as "no-match".
//          *
//          * Example:
//          *
//          *   a b
//          * a - -
//          * c - 0
//          */
//         matchMatrix[rowIndex][columnIndex] = false;
//       }
//     }
//   }

//   return matchMatrix[string.length][pattern.length];
// };



// // MY SOLUTION 2 (Recursion)
// var isMatch = function(s, pattern) {
//     const strLength = s.length;
//     const patternLength = pattern.length;

//     let isMatchHelper = function(sStart, patternStart) {
//         // Handle empty string
//         if (patternLength === patternStart) {
//             return strLength === sStart;
//         }

//         // Handle successful matching
//         else if (strLength - sStart >= 1 && (s[sStart] === pattern[patternStart] || pattern[patternStart] === '.')) {
//             if (patternLength - patternStart >= 2 && pattern[patternStart + 1] == '*') {
//                 return isMatchHelper(sStart, patternStart + 2) || isMatchHelper(sStart + 1, patternStart);
//             } else {
//                 return isMatchHelper(sStart + 1, patternStart + 1);
//             }
//         }

//         // Handle repeating
//         else if (patternLength - patternStart >= 2 && pattern[patternStart + 1] === '*') {
//             return isMatchHelper(sStart, patternStart + 2);
//         }

//         // Handle matching failures
//         else {
//             return false;
//         }
//     }

//     return isMatchHelper(0, 0);
// };



// // MY SOLUTION 1 (Dynamic Programming)
// var isMatch = function(s, pattern) {
//     let memo = new Map();
//     let ans = false;
//     const strLength = s.length;
//     const patternLength = pattern.length;

//     let isMatchHelper = function(sStart, patternStart) {
//         // Handling memorized matching result:
//         let attempt = [sStart, patternStart];
//         if (memo.has(attempt)) {
//             return memo[attempt];
//         }

//         // Handle empty string
//         else if (patternLength === patternStart) {
//             ans = (strLength === sStart);
//         }

//         // Handle successful matching
//         else if (strLength - sStart >= 1 && (s[sStart] === pattern[patternStart] || pattern[patternStart] === '.')) {
//             if (patternLength - patternStart >= 2 && pattern[patternStart + 1] == '*') {
//                 ans = isMatchHelper(sStart, patternStart + 2) || isMatchHelper(sStart + 1, patternStart);
//             } else {
//                 ans = isMatchHelper(sStart + 1, patternStart + 1);
//             }
//         }

//         // Handle repeating
//         else if (patternLength - patternStart >= 2 && pattern[patternStart + 1] === '*') {
//             ans = isMatchHelper(sStart, patternStart + 2);
//         }

//         // Handle matching failures
//         else {
//             ans = false;
//         }

//         memo[attempt] = ans;
//         return ans;
//     }

//     return isMatchHelper(0, 0);
// };