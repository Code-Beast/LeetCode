class Solution {
    public int findDuplicate(int[] nums) {
        /**
         * Idea:
         *  - not allowed to change nums
         *  - Space = O(1)
         *  - Time < O(n^2)
         * [1, 3, 2, 3, 4] nums1[n] = nums[n - 1]
         * nums1[1] = 1
         * nums1[2] = 3
         * nums1[3] = 2
         * nums1[4] = 3 
         * nums1[5] = 4
         */
        
        int idx1 = 0;
        int idx2 = 0;
        
        while (nums[idx1] != nums[nums[idx2]]) {
            idx1 = nums[idx1];
            idx2 = nums[nums[idx2]];
        }
                        
        idx1 = 0;
        idx2 = nums[nums[idx2]];
        
        while (idx1 != idx2) {
            idx1 = nums[idx1];
            idx2 = nums[idx2];
        }
        
        return idx1;
    }
}
