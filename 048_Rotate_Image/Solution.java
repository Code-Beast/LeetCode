// Author: Code-Beast

// MY SOLUTION 1 
// Runtime: 2ms
// Time Complexity: O(n * m)
// Space Complexity: O(1)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i ++) {
        	for (int j = i + 1; j < matrix[0].length; j ++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }

        for (int i = 0; i < matrix.length; i ++) {
        	for (int j = 0; j < matrix[0].length / 2; j ++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[i][matrix[0].length - j - 1];
        		matrix[i][matrix[0].length - j - 1] = temp;
        	}
        }

        return;
    }

    public static void main(String[] args) {
    	int[][] matrix = new int[][]{
    		{1, 2, 3},
    		{4, 5, 6}, 
    		{7, 8, 9}
    	};
    	new Solution().rotate(matrix);
    	System.out.println(matrix[0][1]);
    	System.out.println(matrix[1][1]);
    	System.out.println(matrix[2][1]);

    	// 7 4 1
    	// 8 5 2
    	// 9 6 3
    }
}