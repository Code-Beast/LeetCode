// Author: Code-Beast

// // MY SOLUTION 1
// // Runtime: 3ms
// // Time Complexity: O(n!)
// // Space Complexity: O(n)
// import java.util.List; 
// import java.util.ArrayList;
// import java.util.Arrays;

// class Solution {
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();

//         if (nums == null || nums.length == 0) {
//         	return res;
//         }

//         Arrays.sort(nums);
//         helper(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
//         return res;
//     }

//     private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
//     	if (nums.length == list.size()) {
//     		res.add(new ArrayList<>(list));
//     		return;
//     	}

//     	for (int i = 0; i < nums.length; i ++) {
//     		if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
//     			continue;
//     		}

//     		used[i] = true;
//     		list.add(nums[i]);
//     		helper(res, list, nums, used);
//     		used[i] = false;
//     		list.remove(list.size() - 1);
//     	}

//     	return;
//     }

//     public static void main(String[] args) {
//     	System.out.println(new Solution().permuteUnique(new int[]{1, 1, 2, 3}));
//     }
// }



// MY SOLUTION 2
// Runtime: 4ms
// Time Complexity: O(n!)
// Space Complexity: O(n)
import java.util.List; 
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        helper(res, 0, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, int start, int[] nums) {
    	if (start == nums.length - 1) {
    		List<Integer> list = new ArrayList<>();
    		for (int i = 0; i < nums.length; i ++) {
    			list.add(nums[i]);
    		}
    		res.add(list);

    		return;
    	}

    	for (int i = start; i < nums.length; i ++) {
    		if (isUsed(nums, start, i)) continue;

    		swap(nums, start, i);
    		helper(res, start + 1, nums);
    		swap(nums, start, i);
    	}

    	return;
    }

    private void swap(int[] nums, int pos1, int pos2) {
    	int temp = nums[pos1];
    	nums[pos1] = nums[pos2];
    	nums[pos2] = temp;
    }

    private boolean isUsed(int[] nums, int pos1, int pos2) {
    	for (int i = pos1; i < pos2; i ++) {
    		if (nums[i] == nums[pos2]) {
    			return true;
    		}
    	}
    	return false;
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().permuteUnique(new int[]{1, 1, 2, 3}));
    }
}