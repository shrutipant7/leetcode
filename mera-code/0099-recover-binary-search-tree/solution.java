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
    public void recoverTree(TreeNode root) {
       List<Integer> list = new ArrayList<>();
    int[] idx = new int[1];
    collectInorder(root, list);
    Collections.sort(list);
    restoreInorder(root, list, idx);
  }

  private void collectInorder(TreeNode root, List<Integer> list) {
    if (root == null) return;
    collectInorder(root.left, list);
    list.add(root.val);
    collectInorder(root.right, list);
  }

  private void restoreInorder(TreeNode root, List<Integer> list, int[] idx) {
    if (root == null) return;
    restoreInorder(root.left, list, idx);
    root.val = list.get(idx[0]);
    idx[0]++;
    restoreInorder(root.right, list, idx);
  }
}
