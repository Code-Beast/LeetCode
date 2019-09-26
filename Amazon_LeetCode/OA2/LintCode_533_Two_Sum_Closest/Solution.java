import java.lang.Math;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().twoSumClosest(new double[]{7.33, 8.13, 10.3, 103.7371, 11.24, 23.79, 18.3501}, 43.3));
	}

	public double twoSumClosest(double[] nums, double target) {
		Arrays.sort(nums);
		int left = 0, right = nums.length - 1;
		double minDiff = Integer.MAX_VALUE;

		while (left < right) {
			double sum = nums[left] + nums[right];
			if (sum == target) {
				return 0;
			} else if (sum < target) {
				minDiff = Math.min(minDiff, target - sum);
				left ++;
			} else {
				minDiff = Math.min(minDiff, sum - target);
				right --;
			}
		}

		return minDiff;
	}
}