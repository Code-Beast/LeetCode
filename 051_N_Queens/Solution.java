// Author: Code-Beast

// MY SOLUTION 1 (Back-tracking)
// Runtime: 4ms
// Time Complexity: O(n^n)
// Space Complexity: O(n)
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();

        if (n == 0) return solutions;

        List<char[]> initialBoard = new ArrayList<>(n);
        char[] initialRow = new char[n];
        Arrays.fill(initialRow, '.');
       	for (int i = 0; i < n; i ++) {
       		initialBoard.add(initialRow.clone());
       	}
        backTracking(solutions, initialBoard, 0);

        return solutions;
    }

    private void backTracking(List<List<String>> solutions, List<char[]> board, int col) {
    	if (col == board.size()) {
    		List<String> solution = new ArrayList<>();
    		for (int i = 0; i < board.size(); i ++) {
    			solution.add(new String(board.get(i)));
    		}
    		solutions.add(solution);
    		return;
    	}

    	for (int i = 0; i < board.size(); i ++) {
    		if (!isValid(board, i, col)) {
    			continue;
    		}

    		board.get(i)[col] = 'Q';
    		backTracking(solutions, board, col + 1);
    		board.get(i)[col] = '.';
    	}

    	return;
    }

	private boolean isValid(List<char[]> board, int row, int col) {
		for (int i = 0; i < col; i ++) {
			if (board.get(row)[i] == 'Q') {
				return false;
			}
		}

		int i = row - 1;
		int j = col - 1;
		while (i >= 0 && j >= 0) {
			if (board.get(i)[j] == 'Q') {
				return false;
			}
			i --;
			j --;
		}

		i = row + 1;
		j = col - 1;
		while (i <= board.size() - 1 && j >= 0) {
			if (board.get(i)[j] == 'Q') {
				return false;
			}
			i ++;
			j --;
		}

		return true;
	}

    public static void main(String[] args) {
    	System.out.println(new Solution().solveNQueens(4));
    }
}



// // MY SOLUTION 2 (Another Back-tracking)
// // Runtime: 5ms
// // Time Complexity: O(n^n)
// // Space Complexity: O(n)
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Collections;
// import java.util.Arrays;

// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> solutions = new ArrayList<>();

//         if (n == 0) return solutions;

//        	int[] initialBoard = new int[n];
//        	Arrays.fill(initialBoard, -1);
//         backTracking(solutions, initialBoard, 0);

//         return solutions;
//     }

//     private void backTracking(List<List<String>> solutions, int[] board, int row) {
//     	if (row == board.length) {
//     		addSolution(solutions, board);
//     		return;
//     	}

//     	for (int col = 0; col < board.length; col ++) {
//     		if (!isValid(board, row, col)) {
//     			continue;
//     		}

//     		board[row] = col;
//     		backTracking(solutions, board, row + 1);
//     		board[row] = -1;
//     	}

//     	return;
//     }

// 	private boolean isValid(int[] board, int row, int col) {
// 		for (int i = 0; i < row; i ++) {
// 			if (board[i] == col || Math.abs(col - board[i]) == Math.abs(row - i)) {
// 				return false;
// 			}
// 		}

// 		return true;
// 	}

// 	private void addSolution(List<List<String>> solutions, int[] board) {
// 		List<String> list = new ArrayList<>();

// 		for (int i = 0; i < board.length; i ++) {
// 			char[] row = new char[board.length];
// 			Arrays.fill(row, '.');
// 			row[board[i]] = 'Q';
// 			list.add(new String(row));
// 		}

// 		solutions.add(list);
// 	}

//     public static void main(String[] args) {
//     	System.out.println(new Solution().solveNQueens(4));
//     }
// }