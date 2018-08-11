// Author: Code-Beast

// MY SOLUTION 2
class Solution {
    public int maxArea(int[] height) {  
        int leftBar = 0,
            rightBar = height.length - 1,
            maxArea = 0;

        while (leftBar < rightBar) {
         if (height[leftBar] > height[rightBar]) {
                maxArea = maxArea > height[rightBar] * (rightBar - leftBar) ? maxArea : height[rightBar] * (rightBar - leftBar);
                rightBar --;
            } else {
                maxArea = maxArea > height[leftBar] * (rightBar - leftBar) ? maxArea : height[leftBar] * (rightBar - leftBar);
                leftBar ++;
            }
        }
    
        return maxArea;
    }
}



// // MY SOLUTION 1
// class Solution {
//     public int maxArea(int[] height) {  
//         int leftBar = 0,
//             rightBar = height.length - 1,
//             maxArea = 0;

//         while (leftBar < rightBar) {
//         	if (height[leftBar] > height[rightBar]) {
//         		   maxArea = Math.max(maxArea, height[rightBar] * (rightBar - leftBar));
//                 rightBar --;
//             } else {
//         		   maxArea = Math.max(maxArea, height[leftBar] * (rightBar - leftBar));
//                 leftBar ++;
//             }
//         }
    
//         return maxArea;
//     }
// }