// Complexity: O(1)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> prevSumMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            int diff = sum - k;
            
            if (sum == k) {
                count ++;
            }
            
            if (prevSumMap.containsKey(diff)) {
                count += prevSumMap.get(diff);
            }
            
            prevSumMap.put(sum, prevSumMap.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}