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
//     public boolean isBalanced(TreeNode root) {
//         if(root == null) return true;
//         Queue<TreeNode> queue = new ArrayDeque<>();
//         queue.offer(root);
//         while(!queue.isEmpty()) {
//             TreeNode top = queue.remove();
//             if(Math.abs(height(top.left)-height(top.right)) > 1) return false;
//             if(top.left != null) queue.offer(top.left);
//             if(top.right != null) queue.offer(top.right);
//         }
//         return true;
//     }
    
//     static int height(TreeNode root) {
//         if(root == null) return 0;
//         return Math.max(height(root.left), height(root.right)) + 1;
//     }
    
     public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(height(root.left)-height(root.right)) <= 1 && isBalanced(root.left)
          && isBalanced(root.right)) return true;
        return false;
    }
    
    static int height(TreeNode root) {
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
