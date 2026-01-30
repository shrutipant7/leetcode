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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int lastLevel = -1;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz > 0) {
                TreeNode top = q.poll();
                lastLevel = top.val;
                if (top.left != null)
                    q.add(top.left);
                if (top.right != null)
                    q.add(top.right);
                sz--;
            }
            ans.add(lastLevel);
        }
        return ans;
    }
}
