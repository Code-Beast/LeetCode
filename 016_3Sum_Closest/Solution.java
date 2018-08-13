// Author: Code-Beast

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i ++) {
            // Aovid repeat
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Find these trios
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sumThree = nums[left] + nums[right] + nums[i];
                if (sumThree > target) {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right --;
                    }
                    right --;
                } else if (sumThree < target) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    left ++;
                } else {
                    return target;
                }

                closest = Math.abs(sumThree - target) < Math.abs(closest - target) ? sumThree : closest;
            }
        }

        return closest;
    }
}