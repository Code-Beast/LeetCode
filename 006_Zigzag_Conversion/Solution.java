// Author: Code-Beast

// MY SOLUTION 3 (Using StringBuilder)
class Solution {
    public String convert(String s, int numRows) {
        // If numRows = 1
        if (numRows == 1) 
            return s;

        // Initialize counters
        int row = -1,
            direction = 1;

        // Create an array of StringBuilders to store zigzag information
        StringBuilder[] zigzagArray = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i ++) {
            zigzagArray[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i ++) {
            row += direction;
            if (row == (numRows - 1) && direction == 1) 
                direction = -1;
            if (row == 0 && direction == -1) 
                direction = 1;
            zigzagArray[row].append(s.charAt(i));
        }

        // Get the corresponding string
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : zigzagArray) {
            res.append(sb);
        }

        return res.toString();
    }
}



// MY SOLUTION 2 (Using StringBuffer)
// class Solution {
//     public String convert(String s, int numRows) {
//         // If numRows = 1
//         if (numRows == 1) 
//             return s;

//         // Initialize counters
//         int row = -1,
//             direction = 1;

//         // Create an array of StringBuilders to store zigzag information
//         StringBuffer[] zigzagArray = new StringBuffer[numRows];
//         for (int i = 0; i < numRows; i ++) {
//             zigzagArray[i] = new StringBuffer();
//         }

//         for (int i = 0; i < s.length(); i ++) {
//             row += direction;
//             if (row == (numRows - 1) && direction == 1) 
//                 direction = -1;
//             if (row == 0 && direction == -1) 
//                 direction = 1;
//             zigzagArray[row].append(s.charAt(i));
//         }

//         // Get the corresponding string
//         StringBuffer res = new StringBuffer();
//         for (StringBuffer sb : zigzagArray) {
//             res.append(sb);
//         }

//         return res.toString();
//     }
// }



// MY SOLUTION 1
// class Solution {
//     public String convert(String s, int numRows) {
//         // If numRows = 1
//         if (numRows == 1) 
//             return s;

//         // Initialize counters
//         int row = -1,
//             direction = 1;

//         // Create an array of strings to store zigzag information
//         String[] zigzagArray = new String[numRows];
//         for (int i = 0; i < numRows; i ++) {
//             zigzagArray[i] = "";
//         }

//         for (int i = 0; i < s.length(); i ++) {
//             row += direction;
//             if (row == (numRows - 1) && direction == 1) 
//                 direction = -1;
//             if (row == 0 && direction == -1) 
//                 direction = 1;
//             zigzagArray[row] += s.charAt(i);
//         }

//         // Get the corresponding string
//         String res = "";
//         for (int i = 0; i < numRows; i ++) {
//             res += zigzagArray[i];
//         }

//         return res;
//     }
// }