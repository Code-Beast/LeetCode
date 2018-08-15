// Author: Code-Beast

// MY SOLUTION 1 (Two pointers: when elements to remove are rare)
// Note: the order of elements could be changed
// Runtime: 6ms
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0,
            length = nums.length;
        while (i < length) {
            if (nums[i] == val) {
                nums[i] = nums[length - 1];
                length --;
            } else {
                i ++;
            }
        }
        return length;
    }
}