// Author: Code-Beast

/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    // Handle negative numbers
    if (x < 0) return false;

    // Get the number of digits of x
    let xCopy = x;
    let numOfDigits = 0;
    while (xCopy != 0) {
        numOfDigits ++;
        xCopy = Math.floor(xCopy / 10);
    }

    // Get the reversed half part of the number
    let reversedHalf = 0;
    for (let i = 0; i < Math.floor(numOfDigits / 2); i ++) {
        reversedHalf = reversedHalf * 10 + x % 10;
        x = Math.floor(x / 10);
    }

    // Get the other half part
    if (numOfDigits % 2 != 0) x = Math.floor(x / 10);

    return x == reversedHalf;
};