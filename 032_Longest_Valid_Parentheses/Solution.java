// Author: Code-Beast

// MY SOLUTION 4 (Two pass without extra space)
// Runtime: 14ms
class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0,
            countOpen = 0,
            countClose = 0,
            i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                countOpen ++;
            } else {
                countClose ++;
            }

            if (countOpen == countClose) {
                int length = countOpen + countClose;
                maxLength = length > maxLength ? length : maxLength;
            } else if (countOpen < countClose) {
                countOpen = 0;
                countClose = 0;
            }

            i ++;
        }

        countOpen = 0;
        countClose = 0;
        i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) == ')') {
                countOpen ++;
            } else {
                countClose ++;
            }

            if (countOpen == countClose) {
                int length = countOpen + countClose;
                maxLength = length > maxLength ? length : maxLength;
            } else if (countOpen < countClose) {
                countOpen = 0;
                countClose = 0;
            }

            i --;
        }

        return maxLength;
    }
}



// // MY SOLUTION 2 (Using Built-in Stack)
// // Runtime: 19ms
// class Solution {
//     public int longestValidParentheses(String s) {
//         Stack<Integer> stack = new Stack<>();
//         stack.push(-1);
//         int length = 0,
//             maxLength = 0;
//         for (int i = 0; i < s.length(); i ++) {
//             if (s.charAt(i) == '(') {
//                 stack.push(i);
//             } else {
//                 stack.pop();
//                 if (stack.size() == 0) {
//                     stack.push(i);
//                 }
//                 length = i - stack.get(stack.size() - 1);
//                 maxLength = maxLength >= length ? maxLength : length;
//             }
//         }

//         return maxLength;
//     }
// }



// // MY SOLUTION 2 (Using ArrayList As Stack)
// // Runtime: 19ms
// class Solution {
//     public int longestValidParentheses(String s) {
//         List<Integer> stack = new ArrayList<>();
//         stack.add(-1);
//         int length = 0,
//             maxLength = 0;
//         for (int i = 0; i < s.length(); i ++) {
//             if (s.charAt(i) == '(') {
//                 stack.add(i);
//             } else {
//                 stack.remove(stack.size() - 1);
//                 if (stack.size() == 0) {
//                     stack.add(i);
//                 }
//                 length = i - stack.get(stack.size() - 1);
//                 maxLength = maxLength >= length ? maxLength : length;
//             }
//         }

//         return maxLength;
//     }
// }



// // MY SOLUTION 1 (Dynamic Programming)
// // Runtime: 16ms
// class Solution {
//     public int longestValidParentheses(String s) {
//         // Using dp[i] to store the length of the longest valid parenthesis substring ending with s[i]
//         List<Integer> dp = new ArrayList<>();

//         // maxLength updates as dp grows
//         int maxLength = 0;

//         // Find the longest valid parenthesis substring vai dynamic programming
//         for (int i = 0; i < s.length(); i ++) {
//             if (i >= 1 && s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
//                 dp.add((i >= 2 ? dp.get(i - 2) : 0) + 2);
//                 maxLength = maxLength >= dp.get(i) ? maxLength : dp.get(i);
//             } else if (i >= 1 && s.charAt(i) == ')' && s.charAt(i - 1) == ')' && i - dp.get(i - 1) - 1 >= 0 && s.charAt(i - dp.get(i - 1) - 1) == '(') {
//                 dp.add(dp.get(i - 1) + (i - dp.get(i - 1) - 2 >= 0 ? dp.get(i - dp.get(i - 1) - 2) : 0) + 2);
//                 maxLength = maxLength >= dp.get(i) ? maxLength : dp.get(i);
//             } else {
//                 dp.add(0);
//             }
//         }

//         return maxLength;
//     }
// }