/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return recursiveCount(root, 1);
    }
    
    int recursiveCount(TreeNode root, int count){
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null) return count;
        return Math.min(recursiveCount(root.left, count+1), recursiveCount(root.right, count+1));
    }
}
