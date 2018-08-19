// Author: Code-Beast

// // MY SOLUTION 1 (Backtracking)
// // Runtime: 17ms
// class Solution {
//     public void solveSudoku(char[][] board) {
//     	solveSudokuHelper(board, 0, 0);
// 	}

//     private boolean solveSudokuHelper(char[][] board, int rowStart, int colStart) {
//         for (int row = 0; row < 9; row ++) {
//         	for (int col = 0; col < 9; col ++) {
//         		if (row >= rowStart && col >= colStart && board[row][col] == '.') {
// 	        		for (int num = 0; num < 9; num ++) {
// 	        			// Check the validity
// 	        			if (isValid(board, row, col, num)) {
// 	        				board[row][col] = (char)((int)'0' + num);
// 	        				if (solveSudokuHelper(board, row, col + 1)) {
// 	        					return true;
// 	        				} else {
// 	        					board[row][col] = '.';
// 	        				}
// 	        			}
// 	        		}
//         		}
//         	}
//         }

//         return false;
//     }

//     private boolean isValid(char[][] board, int row, int col, int num) {
//     	// Using 32-bit int and bit operations as Set
// 		int[] rowSet = new int[9];
// 		int[] colSet = new int[9];
// 		int[] cubeSet = new int[9];

// 		int i = 0;
// 		int j = 0;

// 		while(i <= row) {
//     		while(j < 9) {
//     			if (i == row && j == col){
//     				break;
//     			}

//     			if (board[i][j] != '.') {
//     				int currNum = 1 << (board[i][j] - '0');
// 	                rowSet[i] |= currNum;
// 	                colSet[j] |= currNum;
// 	                cubeSet[3 * (i / 3) + j / 3] |= currNum;
// 	            }

//                 j ++;
//     		}

//     		i ++;
//     	}

//         int currNum = 1 << num;
// 		if ((rowSet[i] & currNum) != 0
//                 || (colSet[j] & currNum) != 0
//                 || (cubeSet[3 * (i / 3) + j / 3] & currNum) != 0) {
// 			return false;
// 		} else {
// 			return true;
// 		}
//     }
// }



// THE BEST JAVA SOLUTION FROM:
// Original author: Hsien Loong Lee (http://bit.ly/1zfIGMc)
// Runtime: 2ms
class Solution {
    static final int ALL_ZEROS = 0;
    static final int ALL_ONES = 0x3fe;
    
    // row_bitmap/ col_bitmap/ cube_bitmap: for each row/ col/ cube, use 1 int to store the information of used characters and non-used ones (not cells)
    //      for example, if row_bitmap[i] == 0000 0011 1111 1110 (0x3fe), all cells of ith row are empty
    //      another example, if row_bitmap[i] == 0000 0011 1001 1110, '5' and '6' have been filled into cells of ith row
    //      Note: row/ col/ cube index starts with 0, cell index starts with 1
    //
    // entry: the valbit representation of all cells
    //      for example, if the ith cell in the board is '7', then entry[i] = 1 << ('7' - '0')
    // 
    // sequence: the sequence of trying, non-empty cells' square indices are put in the front
    int[] row_bitmap, col_bitmap, cube_bitmap, entry, sequence;

    // Always points to the first empty cell's SQUARE index, which is stored in SEQUENCE
    int seq_start;

    // Utility arrays to store mapping from SQUARE index to ROW/COLs/CUBES: e.g. 37 -> cube[1, 0], whose 1D index is 3;
    int[] square_to_row, square_to_col, square_to_cube;
    
    public void solveSudoku(char[][] board) {
        // Define all helping data structures
        seq_start = 0;
        row_bitmap = new int[9];
        col_bitmap = new int[9];
        cube_bitmap = new int[9];
        entry =  new int[81];
        sequence =  new int[81];
        square_to_row =  new int[81];
        square_to_col =  new int[81];
        square_to_cube = new int[81];
        
        // Initialize all helping data structures

        // All digits are initially all available (marked by 1) in all three bitmaps
        for (int i = 0; i < 9; i++) {
            row_bitmap[i] = col_bitmap[i] = cube_bitmap[i] = ALL_ONES;
        }
        
        // Sequence stores all SQUARE indices of all cells, 
        // With 0..start-1 being all filled cells, and the rest all empty
        // (All cells initially all empty)
        // At this time, sequence array is not set yet, it will be in the third for loop from here.
        for (int i = 0; i < 81; i++)
            sequence[i] = i;

        // Initialize square_to_row/ col/ cube MAPPINGs
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Mapping from SQUARE to I/J is also beneficial: 
                // avoid calculating I/J from SQUARE later
                int square = i * 9 + j;
                square_to_row[square] = i;
                square_to_col[square] = j;
                square_to_cube[square] = (i / 3) * 3 + j / 3;
            }
        }
        
        // Fill in the given cells in bitmaps
        // Initialize entry array
        // Set sequence array
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int square = i * 9 + j, val = board[i][j] - '0', valbit = 1 << val;
                    
                    row_bitmap[i] &= ~valbit;
                    col_bitmap[j] &= ~valbit;
                    cube_bitmap[(i / 3) * 3 + j / 3] &= ~valbit;
                    entry[square] = valbit;
                    
                    int seq_iter = seq_start;
                    // Compact non-empty cells to the front, and use SEQ_START to mark the first empty cell's position
                    while (seq_iter < 81 && sequence[seq_iter] != square)
                        seq_iter++;
                    swapSeq (seq_start++, seq_iter);
                }
            }
        }
        
        // Main Solver Process
        // From seq_start, try to solve the sudoku
        boolean success = place(seq_start);
        assert success : "Unsolvable Puzzle!";
        
        // Translate result from ENTRY array to BOARD
        // Note: we actually store the found solution in the ENTRY array, with BOARD untouched,
        //       and every int in the ENTRY array now has the following structure:
        //          1. The last bit is 1 (keep that int positive) 
        //          2. Only one of the 1th to 9th bits is 1 (one char from '1' to '9' is filled to that cell)
        for (int s = 0; s < 81; s++) {
            int i = square_to_row[s], j = square_to_col[s];
            board[i][j] = (char) (Integer.numberOfTrailingZeros(entry[s]) + '0');
        }
    }

    boolean place(int seq_pos){
        // If seq_pos is 81, all empty cells are successfully set
        if (seq_pos >= 81)
            return true;
        
        // Find among empty cells the one with the smallest search space: 
        // least ones on its bitmap, that is the & of all three corresponding bitmaps of that cell,
        // in other words, least characters to try according to those non-empty cells in its row, col and cube
        int seq_next = nextPos(seq_pos);

        // Swap seq_pos and seq_next to make sure that the cell with the least search space is attempted first.
        swapSeq(seq_pos, seq_next);
        
        // Translate from seq_pos to row/ idx/ cube indices
        int square = sequence[seq_pos], row_idx = square_to_row[square], col_idx = square_to_col[square], cube_idx = square_to_cube[square];
        
        // Find the common to-try characters among its row, col and cube
        int cell_bitmap = row_bitmap[row_idx] & col_bitmap[col_idx] & cube_bitmap[cube_idx];
        
        // Every time a unused character attampt fails, the corresponding bit in all three bitmaps are set to 0, which means it is not available anymore
        while (cell_bitmap > 0) {
            // Get each available bit/digit in order
            int next_digit_bit = cell_bitmap & -cell_bitmap;
            cell_bitmap &= ~next_digit_bit;
            entry[square] = next_digit_bit;
            
            // Claim this DIGIT is tried in row/column/cube and failed
            row_bitmap[row_idx] &= ~next_digit_bit;
            col_bitmap[col_idx] &= ~next_digit_bit;
            cube_bitmap[cube_idx] &= ~next_digit_bit;

            if (place (seq_pos + 1))
                return true;

            // undo the attemple in these bitmaps
            row_bitmap[row_idx] |= next_digit_bit;
            col_bitmap[col_idx] |= next_digit_bit;
            cube_bitmap[cube_idx] |= next_digit_bit;
            entry[square] = ALL_ZEROS;
        }
        
        // If no solution found, set seq_pos to its original position and return false
        swapSeq (seq_pos, seq_next);
        return false;
    }

    // Find among empty cells the one with the smallest search space: least bits on its bitmap;
    int nextPos(int pos) {
        int min_idx = pos, min_digit_count = 100;
        
        for (int i = pos; i < 81; i++) {
            int square = sequence[i];
            
            // Number of bits in CELL_BITMAP is the number of digits that this cell can take
            int cell_bitmap = row_bitmap[square_to_row[square]] & col_bitmap[square_to_col[square]] & cube_bitmap[square_to_cube[square]];
            
            // Counts the bits, so you know how many digits this CELL can take: we want the minimum one
            int num_possible_digits = Integer.bitCount(cell_bitmap);
            if (num_possible_digits < min_digit_count) {
                min_idx = i;
                min_digit_count = num_possible_digits;
            }
        }
        
        return min_idx;
    }

    void swapSeq(int i, int j) {
        int tmp = sequence[i];
        sequence[i] = sequence[j];
        sequence[j] = tmp;
    }
}