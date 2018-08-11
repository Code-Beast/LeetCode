// Author: Code-Beast

/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let leftBar = 0,
        rightBar = height.length - 1,
        maxArea = 0;

        while (leftBar < rightBar) {
        	if (height[leftBar] > height[rightBar]) {
        		maxArea = Math.max(maxArea, height[rightBar] * (rightBar - leftBar));
                rightBar --;
            } else {
        		maxArea = Math.max(maxArea, height[leftBar] * (rightBar - leftBar));
                leftBar ++;
            }
        }
    
        return maxArea;
};