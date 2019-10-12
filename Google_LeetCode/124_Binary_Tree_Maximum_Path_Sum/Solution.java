// Solution 1: Double DPS
// Runtime: 184ms
class Solution {
  public int maxPathSum(TreeNode root) {
      if (root == null) {
          return Integer.MIN_VALUE;
      }

      int leftMaxPathSum = maxPathSum(root.left);
      int rightMaxPathSum = maxPathSum(root.right);
      int maxPathSumThroughRoot = Math.max(0, maxPathSumFromRoot(root.left)) + Math.max(0, maxPathSumFromRoot(root.right)) + root.val;
      
      return Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxPathSumThroughRoot));
  }
  
  private int maxPathSumFromRoot(TreeNode root) {
      if (root == null) {
          return 0;
      }
          
      int leftMax = Math.max(0, maxPathSumFromRoot(root.left));
      int rightMax = Math.max(0, maxPathSumFromRoot(root.right));
      
      return root.val + Math.max(leftMax, rightMax);
  }
}



// Solution 2: Double DPS + HashMap
// Runtime: 14ms
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
  private Map<TreeNode, Integer> memo;
  
  public int maxPathSum(TreeNode root) {
      memo = new HashMap<>();
      
      return maxPathSumHelper(root);
  }
  
  private int maxPathSumHelper(TreeNode root) {
      if (root == null) {
          return Integer.MIN_VALUE;
      }

      int leftMaxPathSum = maxPathSum(root.left);
      int rightMaxPathSum = maxPathSum(root.right);
      int maxPathSumThroughRoot = Math.max(0, maxPathSumFromRoot(root.left)) + Math.max(0, maxPathSumFromRoot(root.right)) + root.val;
      
      return Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxPathSumThroughRoot)); 
  }
  
  private int maxPathSumFromRoot(TreeNode root) {
      if (root == null) {
          return 0;
      }
      
      if (memo.containsKey(root)) {
          return memo.get(root);
      }
          
      int leftMax = Math.max(0, maxPathSumFromRoot(root.left));
      int rightMax = Math.max(0, maxPathSumFromRoot(root.right));
      
      int maxPathSumFromRoot = root.val + Math.max(leftMax, rightMax);
      memo.put(root, maxPathSumFromRoot);
      
      return maxPathSumFromRoot;
  }
}



// Solution 3: Single DPS
// Runtime: 1ms
class Solution {
  int maxSum;
  
  public int maxPathSum(TreeNode root) {
      maxSum = Integer.MIN_VALUE;
      
      maxPathSumFromRoot(root);
      
      return maxSum;
  }
  
  private int maxPathSumFromRoot(TreeNode root) {
      if (root == null) {
          return 0;
      }
          
      int leftMax = Math.max(0, maxPathSumFromRoot(root.left));
      int rightMax = Math.max(0, maxPathSumFromRoot(root.right));
      
      int maxPathSumThroughRoot = root.val + leftMax + rightMax;
      if (maxPathSumThroughRoot > maxSum) {
          maxSum = maxPathSumThroughRoot;
      }
      
      return root.val + Math.max(leftMax, rightMax);
  }
}