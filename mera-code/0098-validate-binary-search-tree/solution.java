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
    public boolean isValidBST(TreeNode root) {
        return bstHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean bstHelper(TreeNode root, long lMin, long rMax) {
        if (root == null)
            return true;
        if (root.val <= lMin || root.val >= rMax)
            return false;
        return bstHelper(root.left, lMin, root.val) && bstHelper(root.right, root.val, rMax);
    }
}
