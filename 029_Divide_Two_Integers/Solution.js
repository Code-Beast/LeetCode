// Author: Code-Beast

// MY SOLUTION 2 (Double by left shifting)
// Runtime: Time Limit Exceeded
// Explanation:
//  Bitwise operators work with integers. JavaScript doesn't have integers. 
//  It only has double precision floating-point numbers. So, the bitwise operators
//  convert their number operands into integers, do their business, and then 
//  convert them back. In most languages, these operators are very close to the 
//  hardware and very fast. In JavaScript, they are very far from the hardware 
//  and very slow.
/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function(dividend, divisor) {
    if (divisor === 0) {
        return 2147483647;
    }

    if (dividend === 0) {
        return 0;
    }

    let quotient = 0;
    let isPositive = (dividend > 0) == (divisor > 0);
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
    while (dividend - divisor >= 0) {
        let multiple = 1;
        let multiDivisor = divisor;
        while (dividend - multiDivisor >= 0) {
            dividend -= multiDivisor;
            quotient += multiple;
            multiDivisor <<= 1;
            multiple <<= 1;
        }
    }

    quotient = isPositive ? quotient : -quotient;

    return Math.max(Math.min(quotient, 2147483647), -2147483648);
};



// // MY SOLUTION 1 (Double by plus)
// // Runtime: 68ms
// /**
//  * @param {number} dividend
//  * @param {number} divisor
//  * @return {number}
//  */
// var divide = function(dividend, divisor) {
//     if (divisor === 0) {
//         return 2147483647;
//     }

//     if (dividend === 0) {
//         return 0;
//     }

//     let quotient = 0;
//     let isPositive = (dividend > 0) == (divisor > 0);
//     dividend = Math.abs(dividend);
//     divisor = Math.abs(divisor);
//     while (dividend - divisor >= 0) {
//         let multiple = 1;
//         let multiDivisor = divisor;
//         while (dividend - multiDivisor >= 0) {
//             dividend -= multiDivisor;
//             quotient += multiple;
//             multiDivisor += multiDivisor;
//             multiple += multiple;
//         }
//     }

//     quotient = isPositive ? quotient : -quotient;

//     return Math.max(Math.min(quotient, 2147483647), -2147483648);
// };