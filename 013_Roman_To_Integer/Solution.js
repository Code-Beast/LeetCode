// Author: Code-Beast

/**
 * @param {string} s
 * @return {number}
 */

// SOLUTION CITED FROM 
// https://leetcode.com/problems/roman-to-integer/discuss/155586/Dead-simple-JavaScript-solution-runs-at-96
var romanToInt = function(s) {
    const valueMap = {"M": 1000, "D": 500, "C": 100, "L": 50, "X": 10, "V": 5, "I": 1};
    let sum = 0;    
    for(let i = s.length-1; i >= 0; i --) {
        let char = valueMap[s[i]];
        let nextChar = valueMap[s[i-1]];
        if (nextChar < char) {
            sum += (char-nextChar);
            i --;
        } else {
            sum += char;
        }
    }
    return sum;
};



// // MY SOLUTION 2
// var romanToInt = function(s) {
//         let roman = {'M': 1000, 'D': 500 , 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1},
//             z = 0;
//         for (let i = 0; i < s.length - 1; i ++) {
//             if (roman[s[i]] < roman[s[i+1]]) {
//                 z -= roman[s[i]];
//             } else {
//                 z += roman[s[i]];
//             }
//         }
//         return z + roman[s[s.length - 1]];
// };



// // MY SOLUTION 1
// var romanToInt = function(str) {
//     let romanMap = {"I": [1, 1], "V": [5, 5], "X": [10, 1], "L": [50, 5], "C": [100, 1], "D": [500, 5], "M": [1000, 1]};

//     let idx = 0,
//         num = 0;

//     while (idx < str.length) {
//         let char = str[idx];
//         let [value, digit] = romanMap[char];
//         if (digit === 1) {
//             if (idx < str.length - 1 && (romanMap[str[idx + 1]][0] === 5 * value || romanMap[str[idx + 1]][0] === 10 * value)) {
//                 num = num + (romanMap[str[idx + 1]][0] - value);
//                 idx += 2;
//             } else {
//                 while (idx < str.length && str[idx] === char) {
//                     num += value;
//                     idx ++;
//                 }
//             }
//         } else {
//             num = num + value;
//             idx ++;
//         }
//     }
    
//     return num;
// };

console.log(romanToInt("III"));     // 3
console.log(romanToInt("IV"));      // 4
console.log(romanToInt("IX"));      // 9
console.log(romanToInt("LVIII"));   // 58
console.log(romanToInt("MCMXCIV")); // 1994