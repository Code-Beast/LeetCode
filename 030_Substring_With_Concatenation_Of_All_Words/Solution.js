// Author: Code-Beast

// MY SOLUTION 2 (objects as maps)
// Runtime: 92ms
/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
var findSubstring = function(s, words) {
    if (s === "" || words.length === 0) return [];

    // Initialize and define import values
    let wordLength = words[0].length,
        wordListLength = words.length,
        subStrLength = wordListLength * wordLength,
        strLength = s.length;

    // Handle a 100% failure
    if (strLength < subStrLength) return [];

    // Construct the word map
    // And find the substring value to find
    let wordCountMap = {};
    for (let word of words)
        wordCountMap[word] = word in wordCountMap ? wordCountMap[word] + 1 : 1;

    // Iteration for to find substrings which contains the exactly same number of every word in wordCountMap
    let res = [];
    for (let i = 0; i < wordLength; i ++) {
        let left = i,
            right = i;
        let newWordCountMap = {};
        while (right < strLength - wordLength + 1) {
            let currWord = s.slice(right, right + wordLength);
            if (!(currWord in wordCountMap)) {
                newWordCountMap = {};
                right += wordLength;
                left = right;
            } else {
                newWordCountMap[currWord] = currWord in newWordCountMap ? newWordCountMap[currWord] + 1 : 1;
                right += wordLength;
                if (newWordCountMap[currWord] > wordCountMap[currWord]) {
                    while (left < right) {
                        newWordCountMap[s.slice(left, left + wordLength)] --;
                        left += wordLength;
                        if (s.slice(left - wordLength, left) === currWord) break;
                    }
                }

                if (right - left === subStrLength) {
                    res.push(left);
                    newWordCountMap[s.slice(left, left + wordLength)] --;
                    left += wordLength;
                }
            }
        }
    }
    
    return res;
};




// // MY SOLUTION 1 (object as map and list)
// // This code won't work for a long word list
// // Because as the word list grows, the biggest key for these words grows exponentially
// // and exceeds the max value that can be stored
// /**
//  * @param {string} s
//  * @param {string[]} words
//  * @return {number[]}
//  */
// var findSubstring = function(s, words) {
//     // Handle boundary conditions
//     if (s === "" || words.length === 0) {
//     	return [];
//     }

//     // Initialize and define import values
//     let wordLength = words[0].length,
//         wordListLength = words.length,
//         subStrLength = wordListLength * wordLength,
//         strLength = s.length;

//     // Construct the word map
//    	// And find the substring value to find
//     let wordMap = {}, 
//         keyPow = 0,
//         targetValue = 0;
//     for (let word of words) {
//     	if (!(word in wordMap)) {
//     		wordMap[word] = Math.pow(2, keyPow);
//     		keyPow ++;
//         }
//     	targetValue += wordMap[word];
//     }

//     // First pass for getting word value for each i before len(s) - len(words[0]) + 1 and document them in a corresponding list
//     let values = [];
//     for (let i = 0; i < strLength - wordLength + 1; i ++) {
//     	word = s.slice(i, i + wordLength);
//     	values.push(word in wordMap ? wordMap[word] : 0);
//     }

//     // Second pass for getting substring value for each i before len(s) - len(words) * len(words[0]) + 1
//     // And document indices which meet the requirement
//     let res = [];
//     for (let i = 0; i < strLength - subStrLength + 1; i ++) {
//     	// Skip impossible starting index
//     	if (values[i] != 0) {
//         	subStrValue = 0;
//         	for (let j = 0; j < subStrLength; j += wordLength) {
//         		subStrValue += values[i + j];
//             }
//         	if (subStrValue == targetValue) {
//         		res.push(i);
//             }
//         }
//     }

//     return res;
// };

console.log(findSubstring("barfoothefoobarman", ["foo", "bar", "the"]));
console.log(findSubstring("a", []))