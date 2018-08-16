// Author: Code-Beast


// MY SOLUTION 1
// Runtime: 56ms
/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    let lenNeedle = needle.length,
        lenHaystack = haystack.length;

    // Handle searching for an empty string
    if (lenNeedle === 0) {
        return 0;
    }

    // Handle a longer string to search for than the string to search
    if (lenHaystack < lenNeedle) {
        return -1;
    }

    let j = 0;
    for (let i = 0; i < lenHaystack - lenNeedle + 1; i ++) {
        if (haystack[i] === needle[j]) {
            let test = i;
            while (test < lenHaystack && j < lenNeedle && haystack[test] === needle[j]) {
                test ++;
                j ++;
            }
            if (j === lenNeedle) return i;
            j = 0;
        }
    }

    return -1;
};