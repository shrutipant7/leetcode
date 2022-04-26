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
        List<TreeNode> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        printUtil(root, list, 0);
        for(TreeNode node : list) {
            res.add(node.val);
        }
        return res;
    }
    
    static void printUtil(TreeNode root, List<TreeNode> list, int level) {
        if(root == null) return;
        if(list.size() == level) list.add(level, root);
        else if (list.get(level) == null) list.add(level, root);
        printUtil(root.right, list, level+1);
        printUtil(root.left, list, level+1);
    }
}
