// Author: Code-Beast

/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    // If numRows = 1
    if (numRows === 1) 
        return s;
    
    // Initialize counters
    let row = -1,
        direction = 1;

    // Create an array of strings to store zigzag information
    let zigzagList = new Array();
    for (let i = 0; i < numRows; i ++) {
        zigzagList[i] = "";
    }
    
    for (let i = 0; i < s.length; i ++) {
        row += direction;
        if (row === (numRows - 1) && direction === 1) 
            direction = -1;
        if (row === 0 && direction === -1) 
            direction = 1;
        zigzagList[row] += s[i];
    }

    // Get the corresponding string
    let res = "";
    for (let i = 0; i < numRows; i ++) {
        res += zigzagList[i];
    }

    return res;
};