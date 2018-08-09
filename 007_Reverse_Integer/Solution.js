// Author: Code-Beast

/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
        // Store the sign
        let sign;
        if (x < 0) {
        	sign = -1; 
        	x = Math.abs(x);
        } else {
        	sign = 1;
        }
    
        // Reverse the absolute value
        let res = 0;
        while (x > 0) {
        	res = res * 10 + x % 10;
        	x = Math.floor(x / 10);
        }

        // Recover the sign
        res *= sign;

        // Handle overflows
        if (res < -Math.pow(2, 31) || res >= Math.pow(2, 31)) {
        	return 0;
        }
        	
        return res;
};