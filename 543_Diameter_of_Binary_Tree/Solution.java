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
    private int curDiameter;
    
    public int diameterOfBinaryTree(TreeNode root) {
        curDiameter = 0;
        
        if (root == null) {
            return 0;
        }
        
        return Math.max(heightOfBinaryTree(root.left) + heightOfBinaryTree(root.right), curDiameter);
    }
    
    private int heightOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        int perimeter = leftHeight + rightHeight;
        
        if (perimeter > curDiameter) {
            curDiameter = perimeter;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
