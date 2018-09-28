// Author: Code-Beast

// MY SOLUTION 1
// Runtime: 10ms
import java.util.HashMap;
import java.lang.Math;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int maxLength = 0;

        for (int num : nums) {
            if (numMap.containsKey(num)) continue;

            int leftElements = numMap.containsKey(num - 1) ? numMap.get(num - 1) : 0;
            int rightElements = numMap.containsKey(num + 1) ? numMap.get(num + 1) : 0;
            int length = leftElements + rightElements + 1;
            
            numMap.put(num, length);

            maxLength = Math.max(maxLength, length);

            // Only need to update the front and the end keys' values
            // Because all keys in between have been added, their values will never be accessed again
            // for ```if (numMap.containsKey(num)) continue;```
            numMap.put(num - leftElements, length);
            numMap.put(num + rightElements, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}