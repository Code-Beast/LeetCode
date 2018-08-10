// Author: Code-Beast

/**
 * @param {string} str
 * @return {number}
 */

var myAtoi = function(str) {
    // Handle empty string
    if (!str.length || !str) {
        return 0;
    }

    // The first character of the original string
    let firstChar = str[0];

    // Delete Spaces
    let count = 0;
    if (firstChar === ' ') {
        for (let i = 0; i < str.length; i ++) {
            if (str[i] === ' ') {
                count ++;
            } else {
                break;
            }
        }
    }
    str = str.substring(count, str.length);

    // The first character of the string without starting spaces
    if (str.length === 0) {
        return 0;
    }
    firstChar = str[0];

    // If string starts with "+" or "-", read the sign
    let sign = 1;
    if (firstChar === '+') {
        str = str.substring(1, str.length);
    } else if (firstChar === '-') {
        sign = -1;
        str = str.substring(1, str.length);
    }

    // The first character of the string without starting spaces and starting sign
    if (str.length === 0) {
        return 0;
    }
    firstChar = str[0];

    // Read the number or return 0
    let num = 0;
    if (firstChar <= "9" && firstChar >= "0")	{
        for (let i = 0; i < str.length; i ++) {
            let ch = str[i];
            if (ch <= "9" && ch >= "0") {
                num = num * 10 + (ch - '0');
            } else {
                break;
            }
        }
        let signedNum = num * sign;
        
        // Handle overflows
        if (signedNum > 2147483647) return 2147483647
        if (signedNum < -2147483648) return -2147483648
        
        return num * sign;
    } else {
        // If no number detected, return 0
        return 0;
    }
};

