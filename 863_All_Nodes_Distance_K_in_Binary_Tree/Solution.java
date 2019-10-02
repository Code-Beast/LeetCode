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
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        /**
         * Find K (O(logn)), mark the path
         * From the target node do 0 + n
         */
        Set<Integer> pathNodes = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        findTarget(root, target, pathNodes);
        System.out.println(pathNodes);
        
        if (root == null) {
            return res;
        }
        
        dfsTarget(root, target, K, res, pathNodes);
        return res;
    }
    
    private boolean findTarget(TreeNode root, TreeNode target, Set<Integer> path) {
        if (root == null) {
            return false;
        } else if (root == target || findTarget(root.left, target, path) || findTarget(root.right, target, path)) {
            path.add(root.val);
            return true;
        } else {
            return false;
        }
    }
    
    private void dfs(TreeNode root, int K, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (K == 0) {
            res.add(root.val);
            return;
        }

        dfs(root.left, K - 1, res);
        dfs(root.right, K - 1, res);
    }
    
    private int dfsTarget(TreeNode root, TreeNode target, int K, List<Integer> res, Set<Integer> path) {
        if (root == null) {
            return -1;
        }

        int curDistance = 0;
        int temp = 0;

        if (target.val == root.val) {
            dfs(root.left, K - 1, res);
            dfs(root.right, K - 1, res);
        } else if (root.left != null && path.contains(root.left.val)) {
            temp = dfsTarget(root.left, target, K, res, path);
            curDistance =  1 + temp;
            if (temp == -1) return -1;
            dfs(root.right, K - curDistance - 1, res);
        } else if (root.right != null && path.contains(root.right.val)) {
            temp = dfsTarget(root.right, target, K, res, path);
            curDistance =  1 + temp;
            if (temp == -1) return -1;
            dfs(root.left, K - curDistance - 1, res);
        }

        if (curDistance == K) {
            res.add(root.val);
        }

        return curDistance;
    }
}


// If it's a binary search tree
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
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        /**
         * Find K (O(logn)), mark the path
         * From the target node do 0 + n
         */
        List<Integer> res = new ArrayList<>();
        dfsTarget(root, target, K, res);
        return res;
    }
    
    private int dfsTarget(TreeNode root, TreeNode target, int K, List<Integer> res) {
        if (root == null) {
            return -1;
        }
        
        int curDistance;
        int temp;
        
        if (target.val == root.val) {
            dfs(root.left, K - 1, res);
            dfs(root.right, K - 1, res);
            temp = 0;
            curDistance = 0;
        } else if (target.val < root.val) {
            temp = dfsTarget(root.left, target, K, res);
            dfs(root.right, K - temp, res);
            curDistance =  1 + temp;
        } else {
            temp = dfsTarget(root.right, target, K, res);
            dfs(root.left, K - temp, res);
            curDistance =  1 + temp;
        }
        
        if (curDistance == K) {
            res.add(root.val);
        }
        
        if (temp == -1) return -1;
        
        return curDistance;
    }
    
    private void dfs(TreeNode root, int K, List<Integer> res) {
        if (root == null) {
            System.out.println(K);
            return;
        }
        
        if (K == 0) {
            res.add(root.val);
            return;
        }
        
        dfs(root.left, K - 1, res);
        dfs(root.right, K - 1, res);
    }
}
