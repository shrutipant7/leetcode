/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> res = new ArrayList<>();
    Set<Integer> vis = new HashSet<>();
    if (k == 0) {
      res.add(target.val);
      return res;
    }
    Map<Integer, TreeNode> parentMap = new HashMap<>();
    // Pre-load a map to register each node's parent
    fillMap(parentMap, root);

    // Find nodes at distance k from target
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(target);
    int count = 0;
    while (!q.isEmpty() && count < k) {
        int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode front = q.poll();
        vis.add(front.val);
        TreeNode lft = front.left;
        TreeNode rgt = front.right;
        TreeNode parent = parentMap.get(front.val);
        if (lft != null && !vis.contains(lft.val)) q.add(lft);
        if (rgt != null && !vis.contains(rgt.val)) q.add(rgt);
        if (parent != null && !vis.contains(parent.val)) q.add(parent);
      }

      count++;
    }

    while (!q.isEmpty()) {
      res.add(q.poll().val);
    }

    return res;
  }

  private int fillMap(Map<Integer, TreeNode> parentMap, TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) return root.val;
    if (root.left != null) parentMap.put(fillMap(parentMap, root.left), root);
    if (root.right != null) parentMap.put(fillMap(parentMap, root.right), root);
    return root.val;
  }
}
