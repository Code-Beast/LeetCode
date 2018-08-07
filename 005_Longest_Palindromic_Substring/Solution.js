/**
 * @param {string} s
 * @return {string}
 */
let longestPalindrome = function(s) {
    let longestPal = ""
    if (s.length === 1) {
        return s;
    }

    for (let i = 0; i < s.length; i ++) {
        if (i > 0) {
            let res = findLongestPalindrome(s, 1, i - 1, i + 1);
            if (longestPal.length <= res[0]) {
                longestPal = res[1];
            }
        }

        if (i >= 0) {
            let res = findLongestPalindrome(s, 0, i, i + 1);
            if (longestPal.length <= res[0]) {
                longestPal = res[1];
            }
        }
    }

    return longestPal;
}
    
let findLongestPalindrome = function(s, length, idxLeft, idxRight) {
    while (idxLeft >= 0 && idxRight < s.length) {
        if (s[idxLeft] != s[idxRight]) {
            break;
        }
        length += 2;
        idxLeft --;
        idxRight ++;
    }
    return [length, s.slice(idxLeft + 1, idxRight)];
}