class Solution {
    public int[] twoSum(int[] nums, int target) {
        // corner case: no
        // time: no - O(n)
        // space: no - O(n)
        
        // traverse the array, build up a map along the way
        // key is target - number, value is index
        
        Map<Integer, Integer> memo = new HashMap<>();
        int i = 0, curNum = -1;
        
        for (; i < nums.length; i ++) {
            curNum = nums[i];
            
            if (memo.containsKey(curNum)) {
                break;
            } else {
                memo.put(target - curNum, i);
            }
        }
        
        return new int[]{memo.get(curNum), i};
    }
}
