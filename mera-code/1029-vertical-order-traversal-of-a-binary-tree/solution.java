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

class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node,
    int row,
    int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        // TreeMap<Vert-level, TreeMap<Horz-level, PriorityQueue<Integer>>>
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        fillTupleMap(map, root);
        for (TreeMap<Integer,PriorityQueue<Integer>> item : map.values()) {
            List<Integer> levelNodes = new ArrayList<>();
            for (PriorityQueue<Integer> innerItem : item.values()) {
                int size = innerItem.size();
                while (size > 0) {
                    levelNodes.add(innerItem.poll());
                    size--;
                }
            }
            ans.add(levelNodes);
        }
        return ans;
    }

    private void fillTupleMap(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, TreeNode root) {
        Queue<Tuple> q = new ArrayDeque<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple fr = q.poll();
            if (!map.containsKey(fr.col)) {
                map.put(fr.col, new TreeMap<>());
                map.get(fr.col).put(fr.row, new PriorityQueue<>());
            }
            else if (!map.get(fr.col).containsKey(fr.row)) {
                map.get(fr.col).put(fr.row, new PriorityQueue<>());
            } 
            map.get(fr.col).get(fr.row).add(fr.node.val);
            
            if (fr.node.left != null) q.add(new Tuple(fr.node.left, fr.row+1, fr.col-1 ));
            if (fr.node.right != null) q.add(new Tuple(fr.node.right, fr.row+1, fr.col+1 ));
        }
    }
}
