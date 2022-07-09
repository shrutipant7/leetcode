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
    public boolean evaluateTree(TreeNode root) {
        return recursiveFunc(root) == 0 ? false : true;
    }
    
    public int recursiveFunc(TreeNode root){
        if(root.left == null && root.right == null) return root.val;
        int leftVal = recursiveFunc(root.left);
        int rightVal = recursiveFunc(root.right);
        if(root.val == 2) return leftVal + rightVal;
        else return leftVal * rightVal;
    }
}
