// Solution 1: DP with Binary Search
// Runtime: 1ms
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}



// Solution 2: DP
// Runtime: 8ms
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;  
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        
        for (int i = n - 2; i >= 0; i --) {
            for (int j = i + 1; j < n; j ++) {
                if (nums[i] < nums[j] && dp[j] + 1 > dp[i]) {
                dp[i] = dp[j] + 1;
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }
        
        return maxLength;
    }
}



// Solution 3: DP
// Runtime: 13ms
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}