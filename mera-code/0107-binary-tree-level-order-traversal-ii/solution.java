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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tempRes = new ArrayList<>();
        if(root == null) return tempRes;
        int levelSize = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            levelSize = q.size();
            List<Integer> indList = new ArrayList<>();
            for(int i=0; i<levelSize; i++) {
                TreeNode top = q.poll();
                indList.add(top.val);
                if(top.left != null) q.offer(top.left);
                if(top.right != null) q.offer(top.right);
            }
            tempRes.add(0, indList);
        }
        return tempRes;
    }
}
