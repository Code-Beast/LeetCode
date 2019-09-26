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
  public int countNodes(TreeNode root) {
    if (root == null) return 0;
    int h = height(root);
    if (height(root.right) == h-1)
      return (1 << h) + countNodes(root.right);
    else
      return (1 << (h-1)) + countNodes(root.left);
  }

  private int height(TreeNode root) {
    if (root == null) return -1;
    int res = 0;
    while (root.left != null) {
      res++;
      root = root.left;
    }
    return res;
  }
}


// Solution 2
// Runtime: 0ms
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
  public int countNodes(TreeNode root) {
    if (root == null) return 0;
    
    int height = getHeight(root);
    
    if (getHeight(root.right) == height - 1) {
      return (1 << (height - 1)) + countNodes(root.right);
    } else {
      return (1 << (height - 2)) + countNodes(root.left);
    }
  }
  
  private int getHeight(TreeNode root) {
    if (root == null) return 0;
    
    return 1 + getHeight(root.left);
  }
}