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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        queue.offer(new TreeNode(-1001));
        List<Integer> levelItem = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode top = queue.remove();
            if(top.val == -1001) {
                list.add(levelItem);
                levelItem = new ArrayList<>();
                if(queue.isEmpty()) return list;
                queue.offer(new TreeNode(-1001));
            }
            else levelItem.add(top.val);
            if(top.left != null) queue.offer(top.left);
            if(top.right != null) queue.offer(top.right);
        }
        return list;
    }
}
