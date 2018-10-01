// Author: Code-Beast

// // MY SOLUTION 1 (Recursion)
// // Runtime: 16ms
// // Time Complexity: O(n * m)
// // Space Complexity: O(1)
// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     public double myPow(double x, int n) {
//         if (n >= 0) {
//         	return pow(x, n);
//         } else {
//         	return 1.0 / pow(x, -n);
//         }
//     }

//     private double pow(double x, int n) {
//     	if (n == 0) {
//     		return 1;
//     	}

//     	double y = pow(x, n / 2);

//     	if (n % 2 == 0) {
//     		return y * y;
//     	} else {
//     		return y * y * x;
//     	}
//     }

//     public static void main(String[] args) {
//     	System.out.println(new Solution().myPow(4, 4));
//     	System.out.println(new Solution().myPow(4, -4));
//     }
// }



// MY SOLUTION 2 (Iteration)
// Runtime: 12ms
// Time Complexity: O(log(n))
// Space Complexity: O(n) / O(1)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public double myPow(double x, int n) {
    	if (n == 0) {
    		return 1.0;
    	}

    	long abs = Math.abs((long)(n));
		double res = 1;
    	
    	while(abs > 0) {
    		if (abs % 2 != 0) {
    			res *= x;
    		}
    		x *= x;
    		abs /= 2;
    	}

    	if (n < 0) {
    		return 1.0 / res;
    	} 
    	return res;
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().myPow(4, 4));
    	System.out.println(new Solution().myPow(4, -4));
    }
}