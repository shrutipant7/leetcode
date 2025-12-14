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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        count[0] = 0;
        inorder(root, k, count);
        return count[0];
    }

    public boolean inorder(TreeNode root, int k, int[] count) {
        if (root == null)
            return false;
        if (inorder(root.left, k, count) == true)
            return true;
        count[0]++;
        if (count[0] == k) {
            count[0] = root.val;
            return true;
        }
        if (inorder(root.right, k, count) == true)
            return true;
        return false;
    }
}
