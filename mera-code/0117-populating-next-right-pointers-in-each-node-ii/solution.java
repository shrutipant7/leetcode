/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Map<Integer, Node> map = new HashMap<>();
        connectNodes(root, map, 0);
        return root;
    }
    
    static void connectNodes(Node root, Map<Integer, Node> map, int level) {
        if(root == null) return;
        if(!map.containsKey(level)) map.put(level, root);
        else {
            Node prev = map.get(level);
            prev.next = root;
            map.put(level, root);
        }
        connectNodes(root.left, map, level+1);
        connectNodes(root.right, map, level+1);
    }
}
