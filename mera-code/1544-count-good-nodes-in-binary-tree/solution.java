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
    int max;

    Pair(TreeNode node,
            int max) {
        this.node = node;
        this.max = max;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        int maxAns = 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, root.val));
        while (!q.isEmpty()) {
            Pair top = q.poll();
            if (top.node.val >= top.max) {
                maxAns++;
            }
            if (top.node.left != null) {
                q.add(new Pair(top.node.left, Math.max(top.max, top.node.left.val)));
            }
            if (top.node.right != null) {
                q.add(new Pair(top.node.right, Math.max(top.max, top.node.right.val)));
            }
        }
        return maxAns;
    }
}
