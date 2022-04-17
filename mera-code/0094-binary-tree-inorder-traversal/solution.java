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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root=root.left;
            }
            
            TreeNode top = stack.pop();
            res.add(top.val);
            
            if(top.right != null) {
                root=top.right;
            }
        }
        return res;
    }
}
