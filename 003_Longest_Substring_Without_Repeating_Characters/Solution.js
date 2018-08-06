/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let maxLength = 0,
        substr = "";
    for (let i = 0; i < s.length; i ++) {
        let char = s.charAt(i),
            pos = substr.indexOf(char);
        if (pos !== -1) {
            substr = substr.slice(pos + 1, substr.length);
        }
        substr += char;
        maxLength = Math.max(maxLength, substr.length);
    }
    return maxLength;
};

// SOLUTION 1
// var lengthOfLongestSubstring = function(s) {
//     let maxLength = 0,
//         start = 0;
//     for (let i = 0; i < s.length; i ++) {
//         let char = s.charAt(i), 
//             pos = s.indexOf(char, start);
//         if (pos !== -1 && pos < i) {
//             start = pos + 1;
//         } else {
//             maxLength = Math.max(maxLength, i - start + 1);
//         }
//     }
//     return maxLength;
// };