// Solution 1

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // corner cases: null, less than 2
        // time: no
        // space: no
        
        /**
         * num = target - root.val
         * cases:
         *  1. num < root.val, right -> root, left -> root.left
         *  2. num > root.val, right -> root.right, left -> root
         *  3. num == root.val, explore right and left pointers
         *      a. we have a equivalent number to root.val
         *      b. don't have -> right -> root.right, left -> root.left
         *
         * two pointers
         * sum = *left + *right
         * cases:
         *  1. sum == target => output
         *  2. sum < target => right ++ || left ++
         *  3. sum > target => right -- || left --
         */
       
        if (root == null) 
            return false;

        int num = k - root.val;
        TreeNode left, right;
        
        if (num == root.val) {
            if (root.left != null && root.left.val == num || root.right != null && root.right.val == num) 
                return true;
            left = root.left;
            right = root.right;
        } else if (num < root.val) {
            right = root;
            left = root.left;
        } else {
            left = root;
            right = root.right;
        }
        
        return helper(left, right, k);
    }
    
    private boolean helper(TreeNode left, TreeNode right, int k) {
        if (left == null || right == null) {
            return false;
        } else if (left == right) {
            return helper(left.left, right, k) || helper(left, right.right, k);
        } else {
            int sum = left.val + right.val;
            
            if (sum == k) {
                return true;
            } else if (sum < k) {
                return helper(left.right, right, k) || helper(left, right.right, k);
            } else {
                return helper(left.left, right, k) || helper(left, right.left, k);
            }
        }
    }
}


// Solution 2
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = BST2List(root, k);
        System.out.println(nums);
        int left = 0, right = nums.size() - 1;
        
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left ++;
            } else {
                right --;
            }
        }
        
        return false;
    }
    
    private List<Integer> BST2List(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums);
        return nums;
    }
    
    private void dfs(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        
        dfs(root.left, nums);
        nums.add(root.val);
        dfs(root.right, nums);
    }
}


// Solution 3
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Set<Integer> nodeSet = new HashSet<>();
    
    public boolean findTarget(TreeNode root, int k) {
        // corner case: root == null | number of nodes < 2
        // time: no
        // space: no
        
        /** 
         * (dfs)
         * both on the left side: findTarget(root.left, k) == true
         * both on the right side: findTarget(root.right, k) == true
         * left side + right side
         */
        if (root == null) return false;
        
        if (nodeSet.contains(root.val)) {
            return true;
        }
        nodeSet.add(k - root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
} 
