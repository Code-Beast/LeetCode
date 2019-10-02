// Solution 2
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // len(nums) == 0 or nums = null or len(nums) == 1 => false
        if (nums == null || nums.length < 2) {
            return false;
        }
        
        /** Idea:
         *  1. Sort nums, duplicate nums near each other
         *  2. Traverse and check one num before
         */
        
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        
        return false;
    }
}



// Solution 1
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // len(nums) == 0 or nums = null or len(nums) == 1 => false
        if (nums == null || nums.length < 2)
            return false;
        
        Set<Integer> numSet = new HashSet<>();
        
        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            
            numSet.add(num);
        }
        
        return false;
    }
}
