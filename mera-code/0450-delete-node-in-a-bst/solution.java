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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key == root.val) {
            return buildReplNode(root);
        }
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        if (key > root.val)
            root.right = deleteNode(root.right, key);
        return root;
    }

    public TreeNode buildReplNode(TreeNode root) {
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;
        TreeNode suc = findInorderSuc(root);
        root.val = suc.val;
        root.right = deleteNode(root.right, suc.val);
        return root;
        // suc.left = root.left;
        // return root.right;
    }

    public TreeNode findInorderSuc(TreeNode root) {
        TreeNode ans = null;
        root = root.right;
        while (root != null) {
            ans = root;
            root = root.left;
        }
        return ans;
    }

}
