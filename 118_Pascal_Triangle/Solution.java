// Author: Code-Beast

// MY SOLUTION 1
// Runtime: 0s
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> generate(int numRows) {
    	if (numRows == 0) {
    		return new ArrayList<List<Integer>>();
    	}

        List<List<Integer>> triangle = new ArrayList<>();
       	List<Integer> currentRow = new ArrayList<>();
       	currentRow.add(1);
       	triangle.add(currentRow);
       	List<Integer> lastRow = currentRow;

        for (int i = 1; i < numRows; i ++) {
        	currentRow = new ArrayList<Integer>();
        	currentRow.add(1);

        	for (int j = 0; j < lastRow.size() - 1; j ++) {
        		currentRow.add(lastRow.get(j) + lastRow.get(j + 1));
        	}

        	currentRow.add(1);
        	triangle.add(currentRow);
        	lastRow = currentRow;
        }

        return triangle;
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().generate(5));
    }
}