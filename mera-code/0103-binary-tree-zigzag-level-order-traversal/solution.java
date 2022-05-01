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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        boolean reverse = false;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> inter = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++) {  
                TreeNode cur = q.poll(); 
                if(reverse) inter.add(0, cur.val);
                else inter.add(cur.val);             
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right); 
            } 
            reverse = !reverse;   
            res.add(inter);
        }
        return res;
    }
}
