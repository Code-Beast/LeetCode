// Solution 1: De-duplicate + Two Pointers
// Runtime: 0ms
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long l = (long)lower;
        long u = (long)upper;
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            if (l != u) {
                res.add(l + "->" + u);
            } else {
                res.add(l + "");
            }
            return res;
        }
        
        int size = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != nums[i - 1]) {
                nums[size] = nums[i];
                size ++;
            }
        }
        
        int ptr = 0;
        while (l <= u && ptr < size) {
            if (nums[ptr] != l) {
                if (l + 1 <= u && nums[ptr] == l + 1) {
                    res.add(String.valueOf(l));
                    l += 2;
                    ptr ++;
                } else {
                    res.add(l + "->" + (nums[ptr] - 1));
                    l = (long)nums[ptr] + 1;
                    ptr += 1;
                }
            } else {
                l ++;
                ptr ++;
            }
        }
        
        if (l < u) {
            res.add(l + "->" + u);
        }
        
        if (l == u) {
            res.add(upper + "");
        }
        
        return res;
    }
}