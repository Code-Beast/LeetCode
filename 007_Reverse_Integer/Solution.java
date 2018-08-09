// Author: Code-Beast

// MY SOLUTION 2 (No need to know the sign)
class Solution {
    public int reverse(int x) {
    
        // Reverse the absolute value
        int res = 0;
        while (x != 0) {
            int newRes = res * 10 + x % 10;
            
            // Handle overflow
            if ((newRes - x % 10) / 10 != res) {
                return 0;
            }
            
            res = newRes; 
            x = x / 10;
        }
            
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-123));
    }
}



// MY SOLUTION 1
// class Solution {
//     public int reverse(int x) {
//         // Store the sign
//         int sign;
//         if (x < 0) {
//         	sign = -1; 
//         	x = Math.abs(x);
//         } else {
//         	sign = 1;
//         }
    
//         // Reverse the absolute value
//         int res = 0;
//         while (x > 0) {
//         	int newRes = res * 10 + x % 10;
            
//             // Handle overflow
//             if ((newRes - x % 10) / 10 != res) {
//                 return 0;
//             }
            
//             res = newRes; 
//         	x = x / 10;
//         }

//         // Recover the sign
//         res *= sign;
        	
//         return res;
//     }
// }