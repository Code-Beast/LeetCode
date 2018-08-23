// Author: Code-Beast

// // MY SOLUTION 1 (Brute Force)
// // Runtime: 100ms
// class Solution {
//     public int trap(int[] height) {
//      int trapWater = 0;
//         for (int i = 1; i < height.length - 1; i ++) {
//          int maxLeft = height[i],
//              maxRigth = height[i];

//          // Find the highest left bar
//          for (int j = i - 1; j >= 0; j --) {
//              maxLeft = Math.max(maxLeft, height[j]);
//          }

//          // Find the highest right bar
//          for (int j = i + 1; j < height.length; j ++) {
//              maxRigth = Math.max(maxRigth, height[j]);
//          }

//          trapWater += Math.min(maxLeft, maxRigth) - height[i];
//         }

//         return trapWater;
//     }
// }



// // MY SOLUTION 2 (Dynamic Programming: Basically the same idea as the solution 1)
// // Runtime: 16ms
// class Solution {
//     public int trap(int[] height) {
//         // Handle boundary condition
//         if (height.length == 0) {
//             return 0;
//         }
        
//         // Water to be trapped if only considering the left limit
//         // Suppose the rightmost bar is infinitely high
//         int[] trapLeft = new int[height.length];

//         trapLeft[0] = 0;
//         int maxLeft = height[0];
//         int currHeight = 0;
//         for (int i = 1; i < height.length; i ++) {
//             currHeight = height[i];
//             maxLeft = Math.max(maxLeft, currHeight);
//             trapLeft[i] = maxLeft - currHeight;
//         }

//         // Water to be trapped if only considering the right limit
//         // Suppose the leftmost bar is infinitely high
//         // int[] trapRight = new int[height.length];
//         // Because we already known trapLeft[i], we can get the trap water as we loop back from the last bar

//         // Trapped water if we consider both the right and the left limits
//         int trap = 0;

//         // trapRight[height.length - 1] = 0;
//         int maxRight = height[height.length - 1];
//         for (int i = height.length - 2; i >= 0; i --) {
//             currHeight = height[i];
//             maxRight = Math.max(maxRight, currHeight);
//             trap += Math.min(maxRight - currHeight, trapLeft[i]);
//         }

//         return trap;
//     }
// }



// // MY SOLUTION 3 (Stack)

// // Algorithm:
// //   Use stack to store the indices of the bars.
// //   Iterate the array:
// //       While stack is not empty and \text{height}[current]>\text{height}[st.top()]height[current]>height[st.top()]
// //           It means that the stack element can be popped. Pop the top element as \text{top}top.
// //           Find the distance between the current element and the element at top of stack, which is to be filled. \text{distance} = \text{current} - \text{st.top}() - 1distance=current−st.top()−1
// //           Find the bounded height bounded_height=min(height[current],height[st.top()])−height[top]
// //           Add resulting trapped water to answer ans+=distance∗bounded_height
// //       Push current index to top of the stack
// //       Move \text{current}current to the next position

// // Runtime: 22ms

// import java.util.Stack;

// class Solution {
//     public int trap(int[] height) {
//         // Handle boundary condition
//         if (height.length == 0) {
//             return 0;
//         }
        
//         // Initialize the stack
//         Stack<Integer> trapStack = new Stack<>();
//         trapStack.push(0);
//         int trapWater = 0;

//         // Loop to find the trpped water
//         int i = 1;
//         while (i < height.length) {
//             if (!trapStack.empty() && height[i] > height[trapStack.peek()]) {
//                 while (height[i] > height[trapStack.peek()]) {
//                     int middleBar = trapStack.pop();
                    
//                     // If no left bound found, break and push the current index to the stack
//                     if (trapStack.empty()) {
//                         break;
//                     }
                    
//                     int leftBound = trapStack.peek();
//                     trapWater += (Math.min(height[leftBound], height[i]) - height[middleBar]) * (i - leftBound - 1);
//                 }
//             }
            
//             // If the current bar is not a right bound, push the current index to the stack
//             trapStack.push(i);
//             i ++;
//         }

//         return trapWater;
//     }
// }



// // MY SOLUTION 4 (Using Array as Stack)

// // Algorithm:
// //   Use stack to store the indices of the bars.
// //   Iterate the array:
// //       While stack is not empty and \text{height}[current]>\text{height}[st.top()]height[current]>height[st.top()]
// //           It means that the stack element can be popped. Pop the top element as \text{top}top.
// //           Find the distance between the current element and the element at top of stack, which is to be filled. \text{distance} = \text{current} - \text{st.top}() - 1distance=current−st.top()−1
// //           Find the bounded height bounded_height=min(height[current],height[st.top()])−height[top]
// //           Add resulting trapped water to answer ans+=distance∗bounded_height
// //       Push current index to top of the stack
// //       Move \text{current}current to the next position

// // Runtime: 12ms

// import java.util.Stack;

// class Solution {
//     public int trap(int[] height) {
//         // Handle boundary condition
//         if (height.length == 0) {
//             return 0;
//         }
            
//         // Initialize the stack
//         int[] trapStack = new int[height.length];
//         int top = 0;
//         trapStack[top] = 0;
//         int trapWater = 0;

//         // Loop to find the trpped water
//         int i = 1;
//         while (i < height.length) {
//             if (top >= 0 && height[i] > height[trapStack[top]]) {
//                 while (height[i] > height[trapStack[top]]) {
//                     int middleBar = trapStack[top];
//                     top --;
                        
//                     // If no left bound found, break and push the current index to the stack
//                     if (top < 0) {
//                         break;
//                     }
                        
//                     int leftBound = trapStack[top];
//                     trapWater += (Math.min(height[leftBound], height[i]) - height[middleBar]) * (i - leftBound - 1);
//                 }
//             }
                
//             // If the current bar is not a right bound, push the current index to the stack
//             top ++;
//             trapStack[top] = i;
//             i ++;
//         }

//         return trapWater;
//     }
// }



// MY SOLUTION 5 (Two Pointers)

// Principle: We can say that if there is a larger bar at one end (say right), 
//     we are assured that the water trapped would be dependant on height of bar in current direction (from left to right).

// Algorithm:
//     Initialize left pointer to 0 and right pointer to size-1
//         While left < right, do:
//             If height[left] is smaller than height[right]
//             If height[left] >=left_max, update left_max
//                 Else add left_max − height[left] to ans
//                 Add 1 to left.
//             Else
//                 If height[right] >= right_max, update right_max
//                 Else add right_max − height[right] to ans
//                 Subtract 1 from right.

// Runtime: 12ms

class Solution {
    public int trap(int[] height) {
        // Handle boundary condition
        if (height.length == 0) {
            return 0;
        }

        // Initialize needed variables
        int left = 0,
            leftMax = 0,
            leftHeight = height[left],
            rightMax = 0,
            right = height.length - 1,
            rightHeight = height[right],
            trapWater = 0;

        while (left < right) {
            
            // if the current left bar is higher than the right bar
            // update the right index and try to update the trapped water and the highest right bar
            if (leftHeight >= rightHeight) {
                if (rightHeight < rightMax) {
                    trapWater += rightMax - rightHeight;
                } else {
                    rightMax = rightHeight;
                }

                right --;
                rightHeight = height[right];
            }
            // if the current right bar is higher than the left bar
            // update the left index and try to update the trapped water and the highest left bar
            else {
                if (leftHeight < leftMax) {
                    trapWater += leftMax - leftHeight;
                } else {
                    leftMax = leftHeight;
                }

                left ++;
                leftHeight = height[left];
            }
        }

        return trapWater;
    }
}


