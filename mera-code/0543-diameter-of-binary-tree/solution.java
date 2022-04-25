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
    int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        height(root);
        return result-1;
    }
    public int height(TreeNode root) {   
        if (root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        int ht = Math.max(l, r) + 1; // Not including root in diameter
        int ans = 1+l+r; // Including root in diameter
        result = Math.max(result, ans);
        return ht;
    }
}
