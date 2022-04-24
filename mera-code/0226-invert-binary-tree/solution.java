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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }  
        //"Replace" child node values directly in root.left and root.right
        //Doing TreeNode left = right etc won't work. 
        TreeNode left = invertTree(root.left);  
        TreeNode right = invertTree(root.right);
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
        return root;
    }
}
