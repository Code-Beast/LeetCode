// Author: Code-Beast

// MY SOLUTION 1
//Runtime: 1ms
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
    	if (rowIndex == 0) return res;


        for (int i = 1; i <= rowIndex; i ++) {
        	for (int j = i - 1; j > 0; j --) {
        		res.set(j, res.get(j) + res.get(j - 1));
        	}
        	res.add(1);
        }

        return res;
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().getRow(5));
    }
}