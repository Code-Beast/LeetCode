
// Solution 1
// time Complexity: O(n)
// space Complexity: O(n)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // The length of the array won't exceed 10,000.
        
        // Corner Cases: len <= 2
        if (nums == null) {
            return false;
        }

        // [5, 2, 4, 0, 1]
        // [], 5, 5, 1
        // [(5,1)], 7, 1, 2
        // [(5,1), (1,2)], 11, 5, 3 => true
        
        // [5, 2, 0, 4, 1]
        // [], 5, 5, 1
        // [(5,1)], 7, 1, 2
        // [(5,1), (1,2)], 7, 1, 3
        // [(5,1), (1,3)], 11, 5, 4
        
        Map<Integer, Integer> closestModMap = new HashMap<>();
        int sum = 0;
        
        // k == 0 situation
        int count = 0;
        if (k == 0) {
            for (int i = 0; i < nums.length; i ++) {
                sum += nums[i];
                count ++;
                if (sum != 0) {
                    return false;
                } else if (count >= 2) {
                    return true;
                }   
            }
            return false;
        }
        
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            int mod = sum % k;
            
            // if the sum is equal to 0
            if (i >= 1 && mod == 0) {
                return true;
            }
            
            if (closestModMap.containsKey(mod) && i - closestModMap.get(mod) >= 1) {
                return true;
            } else {
                closestModMap.put(mod, i);
            }
        }
        
        return false;
    }
}



// Solution 1
// Time: O(n^2)
// Space: O(1)

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // The length of the array won't exceed 10,000.
        
        // Corner Cases: len <= 2
        if (nums == null) {
            return false;
        }
        
        int length = nums.length;
        int start = 0;
        
        while (length - start >= 2) {
            int sum = 0;
            int count = 0;
            
            for (int i = start ; i < length; i ++) {
                sum += nums[i];
                count ++;
                if (k != 0 && count >= 2 && sum % k == 0
                   || k == 0 && count >= 2 && sum == 0) {
                    return true;
                }
            }
            
            start ++;
        }
        
        return false;
    }
}


