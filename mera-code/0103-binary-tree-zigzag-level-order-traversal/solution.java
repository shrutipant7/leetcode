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
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean rev = false;
        while (!q.isEmpty()) {
            int size = q.size();
            Deque<Integer> temp = new LinkedList<>();
            while (size > 0) {
                TreeNode top = q.poll();
                if (!rev) {
                    temp.addLast(top.val);
                } else {
                    temp.addFirst(top.val);
                }
                if (top.left != null)
                    q.add(top.left);
                if (top.right != null)
                    q.add(top.right);
                size--;
            }
            ans.add(new ArrayList<>(temp));
            rev = !rev;
        }
        return ans;

    }
}
