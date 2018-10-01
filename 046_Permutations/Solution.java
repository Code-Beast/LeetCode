// Author: Code-Beast

// // MY SOLUTION 1 (Back-tracking)
// // Runtime: 4ms
// // Time Complexity: 0(n! * n)
// // Space Complexity: O(n)
// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();

//         if (nums == null || nums.length == 0) {
//         	return res;
//         }

//         helper(res, new ArrayList<Integer>(), nums);

//         return res;
//     }

//     private void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
//     	if (list.size() == nums.length) {
//     		res.add(new ArrayList<>(list));
//     		return;
//     	}

//     	for (int i = 0; i < nums.length; i ++) {
//     		if (list.contains(nums[i])) {
//     			continue;
//     		}

//     		list.add(nums[i]);
//     		helper(res, list, nums);
//     		list.remove(list.size() - 1);
//     	}

//     	return;
//     }

//     public static void main(String[] args) {
//     	System.out.println(new Solution().permute(new int[]{1, 2, 3}));
//     }
// }



// MY SOLUTION 2
// Runtime: 2ms
// Time Complexity: 0(n!)
// Space Complexity: O(n)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
        	return res;
        }

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
    		swap(nums, start, i);
    		helper(res, start + 1, nums);
    		swap(nums, i, start);
    	}

    	return;
    }

    private void swap(int[] nums, int pos1, int pos2) {
    	int temp = nums[pos1];
    	nums[pos1] = nums[pos2];
    	nums[pos2] = temp;
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}