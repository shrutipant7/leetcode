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
class Pair {
    TreeNode node;
    int parent;

    public Pair(TreeNode node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        int ans = 0;
        if (root == null)
            return ans;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, root.val));
        while (!q.isEmpty()) {
            Pair top = q.poll();
            if (top.node.val >= top.parent)
                ans++;
            if (top.node.left != null)
                q.add(new Pair(top.node.left, Math.max(top.node.val, top.parent)));
            if (top.node.right != null)
                q.add(new Pair(top.node.right, Math.max(top.node.val, top.parent)));
        }
        return ans;
    }
}
