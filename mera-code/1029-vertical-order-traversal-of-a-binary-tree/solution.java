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
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        bfs(root, map);
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : map.entrySet()) {
            List<Integer> ls = new ArrayList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> innerEntry : entry.getValue().entrySet()) {
                PriorityQueue<Integer> pq = innerEntry.getValue();
                while (!pq.isEmpty()) {
                    ls.add(pq.poll());
                }
            }
            ans.add(ls);
        }
        return ans;
    }

    public void bfs(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        Queue<Tuple> q = new ArrayDeque<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple top = q.poll();
            TreeMap<Integer, PriorityQueue<Integer>> temp = new TreeMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            if (map.containsKey(top.col)) {
                temp = map.get(top.col);
                if (temp.containsKey(top.row)) {
                    pq = temp.get(top.row);
                }
            }
            pq.add(top.node.val);
            temp.put(top.row, pq);
            map.put(top.col, temp);
            if (top.node.left != null)
                q.add(new Tuple(top.node.left, top.row + 1, top.col - 1));
            if (top.node.right != null)
                q.add(new Tuple(top.node.right, top.row + 1, top.col + 1));
        }
    }
}
