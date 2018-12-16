class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0);
    }
    
    private List<List<Integer>> helper(int[] nums, int start) {
        if (start == nums.length - 1) {
            List<List<Integer>> subsets = new ArrayList<>();
            List<Integer> empty = new ArrayList<>();
            List<Integer> single = new ArrayList<>();
            single.add(nums[start]);
            subsets.add(empty);
            subsets.add(single);
            return subsets;
        }
        
        List<List<Integer>> subsetsWithoutFirst = helper(nums, start + 1);
        List<List<Integer>> subsetsWithFirst = new ArrayList<>();
        
	for (List<Integer> subsetWithoutFirst: subsetsWithoutFirst) {           
            subsetsWithFirst.add(new ArrayList<Integer>(subsetWithoutFirst));
            List<Integer> subsetWithFirst = new ArrayList<>(subsetWithoutFirst);
            subsetWithFirst.add(nums[start]);
            subsetsWithFirst.add(subsetWithFirst);
        } 
        return subsetsWithFirst;
    }
}

// Runtime: 1ms
// Time: O(2^n)
// Space: O(n^2)



class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> empty = new ArrayList<>();
            List<Integer> single = new ArrayList<>();
            single.add(nums[start]);
            res.add(empty);
            res.add(single);
            return;
        }
        
        helper(res, nums, start + 1);
        
        int length = res.size();
        for (int i = 0; i < length; i ++) {
            List<Integer> subsetWithFirst = new ArrayList<>(res.get(i));
            subsetWithFirst.add(nums[start]);
            res.add(subsetWithFirst);
        }
    }
}

// Runtime: 1ms
// Time: O(2^n)
// Space: O(n)
