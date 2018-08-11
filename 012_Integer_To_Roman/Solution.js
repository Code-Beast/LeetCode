// Author: Code-Beast

/**
 * @param {number} num
 * @return {string}
 */

//MY SOLUTION 2 (Recursion)
var intToRoman = function(num) {
    let romanMap = [['I', 'X', 'C', 'M'], ['V', 'L', 'D']];

    let intToRomanHelper = function(num, level) {
    	let res;

        if (num == 9) {
            return romanMap[0][level] + romanMap[0][level + 1];
        } else if (num < 9 && num >= 5) {
            res = romanMap[1][level];
            for (let i = 0; i < num - 5; i ++) {
                res += romanMap[0][level];
            }
            return res;
        } else if (num == 4) {
            return romanMap[0][level] + romanMap[1][level];
        } else if (num < 4) {
            res = '';
            for (let i = 0; i < num; i ++) {
                res += romanMap[0][level];
            }
            return res;
        } else {
            return intToRomanHelper(Math.floor(num / 10), level + 1) + intToRomanHelper(num % 10, level);
        }
    };

    return intToRomanHelper(num, 0);
};



// // MY SOLUTION 1 (Iteration)
// var intToRoman = function(num) {
//     let romanMap = [['I', 'X', 'C', 'M'], ['V', 'L', 'D']],
//     	level = 0,
//     	roman = '';

//     while (num > 0) {
//         remainder = num % 10;
//         num = Math.floor(num / 10);
//         if (remainder == 9) {
//             roman += romanMap[0][level + 1] + romanMap[0][level];
//         } else if (remainder < 9 && remainder >= 5) {
//             for (let i = 0; i < remainder - 5; i ++) {
//                 roman += romanMap[0][level];
//             }
//             roman += romanMap[1][level];
//         } else if (remainder == 4) {
//             roman += romanMap[1][level] + romanMap[0][level];
//         } else if (remainder < 4) {
//         	for (let i = 0; i < remainder; i ++) {
//                 roman += romanMap[0][level];
//         	}
//         }

//         level ++;
//     }

//     return roman.split("").reverse().join("");
// };