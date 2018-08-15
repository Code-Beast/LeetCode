// Author: Code-Beast

// MY SOLUTION 1 (Two Pointers)
// Runtime: 7ms
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count ++;
            }
        }
        return count;
    }
}