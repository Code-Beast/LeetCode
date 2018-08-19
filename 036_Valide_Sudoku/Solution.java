// Author: Code-Beast

// // MY SOLUTION 1 (Using three HashSets for every iteration of 9)
// // Runtime: 26ms
// import java.util.HashSet;

// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//     	for (int i = 0; i < 9; i ++) {
//     		// Sets to use
// 			Set<Character> rowSet = new HashSet<>(9);
// 			Set<Character> colSet = new HashSet<>(9);
// 			Set<Character> cubeSet = new HashSet<>(9);

//     		for (int j = 0; j < 9; j ++) {
// 				// Check whether the ith row is valid
// 				if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
// 					return false;
// 				}

// 				// Check whether the ith column is valid
// 				if (board[j][i] != '.' && !colSet.add(board[j][i])) {
// 					return false;
// 				}

// 				// Check whether the (i / 3, i % 3) cube is valid
// 				int relativeRow = j / 3;	// Define the relative row idx of the letter in the cube
// 				int relativeCol = j % 3;	// Define the relative col idx of the letter in the cube
// 				int cubeRow = i / 3; 		// Define the row idx of the cube
// 				int cubeCol = i % 3;		// Define the col idx of the cube
// 				char cubeLetter = board[cubeRow * 3 + relativeRow][cubeCol * 3 + relativeCol];
// 				if  (cubeLetter != '.' && !cubeSet.add(cubeLetter)) {
// 					return false;
// 				}
//     		}
//     	}

//     	return true;
//     }
// }



// // MY SOLUTION 2 (Using only one HashSet)
// // Runtime: 30ms
// import java.util.HashSet;

// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//     	// Sets to use
// 		Set<String> checkSet = new HashSet<>();
//     	for (int i = 0; i < 9; i ++) {
//     		for (int j = 0; j < 9; j ++) {
// 				if (board[i][j] != '.'
// 						&& (!checkSet.add("r" + i + board[i][j]) 
// 							||!checkSet.add("c" + j + board[i][j]) 
// 							||!checkSet.add("cube" + i / 3 + j / 3 + board[i][j]))) {
// 					return false;
// 				}
//     		}
//     	}

//     	return true;
//     }
// }



// // MY SOLUTION 3 (Using 32-bit int and bit operations as Set)
// // Runtime: 17ms
// import java.util.HashSet;

// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//     	// Using 32-bit int and bit operations as Set
// 		int[] rowSet = new int[9];
// 		int[] colSet = new int[9];
// 		int[] cubeSet = new int[9];
        
//     	for (int i = 0; i < 9; i ++) {
//     		for (int j = 0; j < 9; j ++) {
//                 int currNum = 1 << (board[i][j] - '0');
// 				if (board[i][j] != '.'
// 					    && ((rowSet[i] & currNum) != 0
//                             || (colSet[j] & currNum) != 0
//                             || (cubeSet[3 * (i / 3) + j / 3] & currNum) != 0)) {
// 					return false;
// 				}
                    
//                 rowSet[i] |= currNum;
//                 colSet[j] |= currNum;
//                 cubeSet[3 * (i / 3) + j / 3] |= currNum;
//     		}
//     	}

//     	return true;
//     }
// }



// // MY SOLUTION 4 (Just like solution 3, but use only one int array)
// // Runtime: 30ms
// import java.util.HashSet;

// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//     	// Using 32-bit int and bit operations as Set
// 		int[] checkSet = new int[9];
        
//     	for (int i = 0; i < 9; i ++) {
//     		for (int j = 0; j < 9; j ++) {
// 				if (board[i][j] != '.') {
//                     int rowNum = 1 << (board[i][j] - '1');
//                     int colNum = 1 << (board[i][j] - '1' + 9);
//                     int cubeNum = 1 << (board[i][j] - '1' + 18);
                    
//                     if ((checkSet[i] & rowNum) != 0
//                             || (checkSet[j] & colNum) != 0
//                             || (checkSet[3 * (i / 3) + j / 3] & cubeNum) != 0) {
//                         return false;
//                     }
                    
//                     checkSet[i] |= rowNum;
//                     checkSet[j] |= colNum;
//                     checkSet[3 * (i / 3) + j / 3] |= cubeNum;
// 				}
//     		}
//     	}

//     	return true;
//     }
// }
