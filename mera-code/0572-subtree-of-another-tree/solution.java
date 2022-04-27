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
        if (root == null) return false;
        
        // ----------  BFS   ---------
        // Queue<TreeNode> q = new ArrayDeque<>();
        // q.offer(root);
        // while(!q.isEmpty()) {
        //     TreeNode top = q.poll();
        //     if(isSame(top, subRoot)) return true;
        //     if(top.left != null) q.offer(top.left);
        //     if(top.right != null) q.offer(top.right);
        // }
        // return false;
        
        // ----------  DFS  -----------
        if(isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

     static boolean isSame(TreeNode subTreeNode, TreeNode subRoot) {
        if(subTreeNode == null && subRoot == null) return true;
        if(subTreeNode == null || subRoot == null) return false;
        if(subTreeNode.val != subRoot.val) return false;
        return isSame(subTreeNode.left, subRoot.left) 
            && isSame(subTreeNode.right, subRoot.right);
    }
}
