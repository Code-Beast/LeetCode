// Author: Code-Beast

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lastNums = new ArrayList<>();
        Arrays.sort(nums);
        NSum(nums, target, 4, lastNums, res);
        return res;
    }
    
    private void NSum(int[] nums, int target, int N, List<Integer> lastNums, List<List<Integer>> res) {
        if (nums.length < N || N < 2 || target < nums[0] * N || target > nums[nums.length - 1] * N) {
            return;
        }

        if (N == 2) {
            int left = 0,
                right = nums.length - 1;
            while (left < right) {
                int sumTwo = nums[left] + nums[right];
                if (sumTwo > target) {
                    // while left < right and nums[right] == nums[right - 1]:
                    //     right -= 1
                    right --;
                } else if (sumTwo < target) {
                    // while left < right and nums[left] == nums[left + 1]:
                    //     left += 1
                    left ++;
                } else {
                    List<Integer> newLastNums = new ArrayList<>();
                    newLastNums.addAll(lastNums);
                    newLastNums.add(nums[left]);
                    newLastNums.add(nums[right]);
                    res.add(newLastNums);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    left ++;

                    while (left < right && nums[right] == nums[right - 1]) {
                        right --;
                    }
                    right --;
                }
            }
            return;
        }

        for (int idx = 0; idx <= nums.length - N; idx ++) {
            if (idx == 0 || idx > 0 && nums[idx] != nums[idx - 1]) {
                List<Integer> newLastNums = new ArrayList<>();
                newLastNums.addAll(lastNums);
                newLastNums.add(nums[idx]);
                NSum(Arrays.copyOfRange(nums, idx + 1, nums.length), target - nums[idx], N - 1, newLastNums, res);
            }
        }

        return;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 2, -1, 4, -2, 0, -2, 2};
        System.out.println(new Solution().fourSum(arr, 0));
    }
}