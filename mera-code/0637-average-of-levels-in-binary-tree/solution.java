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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        double tempAns = 0;
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            for(int i=0; i<levelSize; i++) {
               TreeNode top = q.poll();
               tempAns+= top.val;
               if(top.left != null) q.offer(top.left);
               if(top.right != null) q.offer(top.right);
            }
            res.add(tempAns/levelSize);
            tempAns = 0;
        }
        return res;
    }
}
