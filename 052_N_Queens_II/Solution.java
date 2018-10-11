// Author: Code-Beast

// // MY SOLUTION 1 (Back-tracking)
// // Runtime: 10ms
// // Time Complexity: O(n^n)
// // Space Complexity: O(n)
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Collections;
// import java.util.Arrays;

// class Solution {
//     public int totalNQueens(int n) {
//         List<char[]> initialBoard = new ArrayList<>(n);
//         char[] initialRow = new char[n];
//         Arrays.fill(initialRow, '.');
//        	for (int i = 0; i < n; i ++) {
//        		initialBoard.add(initialRow.clone());
//        	}
//         return backTracking(initialBoard, 0);
//     }

//     private int backTracking(List<char[]> board, int col) {
//     	if (col == board.size()) {
//     		return 1;
//     	}

//         int numOfSolutions = 0;

//     	for (int i = 0; i < board.size(); i ++) {
//     		if (!isValid(board, i, col)) {
//     			continue;
//     		}

//             board.get(i)[col] = 'Q';
//     		numOfSolutions += backTracking(board, col + 1);
//     		board.get(i)[col] = '.';
//     	}

//         return numOfSolutions;
//     }

// 	private boolean isValid(List<char[]> board, int row, int col) {
// 		for (int i = 0; i < col; i ++) {
// 			if (board.get(row)[i] == 'Q') {
// 				return false;
// 			}
// 		}

// 		int i = row - 1;
// 		int j = col - 1;
// 		while (i >= 0 && j >= 0) {
// 			if (board.get(i)[j] == 'Q') {
// 				return false;
// 			}
// 			i --;
// 			j --;
// 		}

// 		i = row + 1;
// 		j = col - 1;
// 		while (i <= board.size() - 1 && j >= 0) {
// 			if (board.get(i)[j] == 'Q') {
// 				return false;
// 			}
// 			i ++;
// 			j --;
// 		}

// 		return true;
// 	}

//     public static void main(String[] args) {
//     	System.out.println(new Solution().totalNQueens(4));
//     }
// }



// // MY SOLUTION 2 (Another Back-tracking)
// // Runtime: 3ms
// // Time Complexity: O(n^n)
// // Space Complexity: O(n)
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Collections;
// import java.util.Arrays;

// class Solution {
//     public int totalNQueens(int n) {
//         if (n == 0) return 0;

//        	int[] initialBoard = new int[n];
//        	Arrays.fill(initialBoard, -1);
//         return backTracking(initialBoard, 0);
//     }

//     private int backTracking(int[] board, int row) {
//     	if (row == board.length) {
//     		return 1;
//     	}

//         int numOfSolutions = 0;
//     	for (int col = 0; col < board.length; col ++) {
//     		if (!isValid(board, row, col)) {
//     			continue;
//     		}

//     		board[row] = col;
//     		numOfSolutions += backTracking(board, row + 1);
//     		board[row] = -1;
//     	}

//     	return numOfSolutions;
//     }

// 	private boolean isValid(int[] board, int row, int col) {
// 		for (int i = 0; i < row; i ++) {
// 			if (board[i] == col || Math.abs(col - board[i]) == Math.abs(row - i)) {
// 				return false;
// 			}
// 		}

// 		return true;
// 	}

//     public static void main(String[] args) {
//     	System.out.println(new Solution().totalNQueens(4));
//     }
// }



// MY SOLUTION 3 (Another Back-tracking)
// Runtime: 1ms
// Time Complexity: O(n^n)
// Space Complexity: O(n)
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
class Solution {
    private int numOfSolutions = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diagLT2RB = new boolean[2 * n - 1];
        boolean[] diagLB2RT = new boolean[2 * n - 1];

        backTracking(cols, diagLT2RB, diagLB2RT, 0);

        return numOfSolutions;
    }

    private void backTracking(boolean[] cols, boolean[] diagLT2RB, boolean[] diagLB2RT, int row) {
        if (row == cols.length) {
            numOfSolutions ++;
            return;
        }

        for (int col = 0; col < cols.length; col ++) {
            int diagLT2RBPos = col - row + cols.length - 1;
            int diagLB2RTPos = col + row;

            if (cols[col] || diagLB2RT[diagLB2RTPos] || diagLT2RB[diagLT2RBPos]) continue;

            cols[col] = true; diagLB2RT[diagLB2RTPos] = true; diagLT2RB[diagLT2RBPos] = true;
            backTracking(cols, diagLT2RB, diagLB2RT, row + 1);
            cols[col] = false; diagLB2RT[diagLB2RTPos] = false; diagLT2RB[diagLT2RBPos] = false;
        }

        return;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(4));
    }
}