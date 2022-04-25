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
    // public int maxDepth(TreeNode root) {
    //     if(root == null) return 0;
    //     return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    // }
    
    //Iterative BFS using queue
     public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        queue.offer(root); 
        while(!queue.isEmpty()) {
            depth++; //Increment depth for each level
            int size = queue.size();
            for(int i=0; i<size; i++) {
                //All nodes of a level will be removed due to loop.
                TreeNode node = queue.remove(); 
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }
}
