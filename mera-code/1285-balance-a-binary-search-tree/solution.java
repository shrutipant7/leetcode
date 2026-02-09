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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        inorder(ls, root);
        return solve(ls, 0, ls.size() - 1);
    }

    public TreeNode solve(List<Integer> ls, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(ls.get(mid));
        TreeNode leftNode = solve(ls, left, mid - 1);
        TreeNode rightNode = solve(ls, mid + 1, right);
        if (leftNode != null)
            root.left = leftNode;
        if (rightNode != null)
            root.right = rightNode;
        return root;
    }

    public void inorder(List<Integer> ls, TreeNode root) {
        if (root == null)
            return;
        inorder(ls, root.left);
        ls.add(root.val);
        inorder(ls, root.right);
    }
}
