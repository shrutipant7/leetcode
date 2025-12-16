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
    private int lastInd = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTree(preorder, Integer.MAX_VALUE);
    }

    public TreeNode constructTree(int[] preorder, int rMax) {
        if (lastInd == preorder.length || preorder[lastInd] > rMax)
            return null;
        TreeNode root = new TreeNode(preorder[lastInd++]);
        root.left = constructTree(preorder, root.val);
        root.right = constructTree(preorder, rMax);
        return root;
    }
}
