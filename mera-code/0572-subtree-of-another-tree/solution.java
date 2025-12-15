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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode top = q.poll();
            if (top.val == subRoot.val && treeMatched(top, subRoot))
                return true;
            if (top.left != null)
                q.add(top.left);
            if (top.right != null)
                q.add(top.right);
        }
        return false;

    }

    public boolean treeMatched(TreeNode top, TreeNode subRoot) {
        if (top == null && subRoot == null)
            return true;
        if (top == null || subRoot == null)
            return false;
        return top.val == subRoot.val && treeMatched(top.left, subRoot.left) && treeMatched(top.right, subRoot.right);
    }
}
