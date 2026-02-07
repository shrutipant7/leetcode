/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Queue<Node> q = new ArrayDeque<>();
        Map<Node, Node> map = new HashMap<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node top = q.poll();
            Node newNode;
            if (!map.containsKey(top)) {
                newNode = new Node(top.val);
                map.put(top, newNode);
            } else
                newNode = map.get(top);
            for (Node neigh : top.neighbors) {
                Node newNeigh;
                if (!map.containsKey(neigh)) {
                    newNeigh = new Node(neigh.val);
                    map.put(neigh, newNeigh);
                    q.add(neigh);
                } else
                    newNeigh = map.get(neigh);

                newNode.neighbors.add(newNeigh);
            }
        }
        return map.get(node);
    }
}
