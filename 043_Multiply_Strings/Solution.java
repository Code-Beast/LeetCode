// Author: Code-Beast

// // MY SOLUTION 1 (Follow the rules of multiplying)
// // Runtime: 22ms
// class Solution {
// 	public String multiply(String num1, String num2) {
//         int m = num1.length(),
//             n = num2.length();
//         int[] resDigits = new int[m + n];
//         for (int i = m - 1; i >= 0; i --) {
//         	for (int j = n - 1; j >= 0; j --) {
//                 int pos1 = i + j,
//                     pos2 = pos1 + 1;
//         		resDigits[pos2] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
//         		resDigits[pos1] += resDigits[pos2] / 10;
//         		resDigits[pos2] %= 10;
//         	}
//         }

//         StringBuilder sb = new StringBuilder();
//         int i = 0;

//     	while (i < m + n && sb.length() == 0 && resDigits[i] == 0) {
//     		i ++;
//     		continue;
//     	}

//         while (i < m + n) {
//         	sb.append(resDigits[i]);
//         	i ++;
//         }
        
//         return sb.length() == 0 ? "0" : sb.toString();
//     }
// }



// MY SOLUTION 2 (Follow the rules of multiplying)
// Runtime: 15ms
class Solution {
	public String multiply(String num1, String num2) {
        int m = num1.length(),
            n = num2.length();
        int[] resDigits = new int[m + n];
        for (int i = m - 1; i >= 0; i --) {
        	for (int j = n - 1; j >= 0; j --) {
        		resDigits[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        	}
        }

        for (int i = m + n - 1; i >= 1; i --) {
        	resDigits[i - 1] += resDigits[i] / 10;
        	resDigits[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;

    	while (i < resDigits.length && sb.length() == 0 && resDigits[i] == 0) {
    		i ++;
    		continue;
    	}

        while (i < resDigits.length) {
        	sb.append(resDigits[i]);
        	i ++;
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}