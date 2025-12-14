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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        int lft = height(root.left);
        int rgt = height(root.right);
        if (lft == -1 || rgt == -1 || Math.abs(lft - rgt) > 1)
            return -1;
        return 1 + Math.max(lft, rgt);
    }
}
