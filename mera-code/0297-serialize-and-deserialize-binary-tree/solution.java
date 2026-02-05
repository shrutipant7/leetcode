/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder st = new StringBuilder();
        if (root == null)
            return new String("N");
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        st.append(root.val).append(",");
        while (!q.isEmpty()) {
            TreeNode top = q.poll();

            if (top.left == null) {
                st.append("N,");
            } else {
                q.add(top.left);
                st.append(top.left.val).append(",");
            }
            if (top.right == null) {
                st.append("N,");
            } else {
                q.add(top.right);
                st.append(top.right.val).append(",");
            }
        }
        return new String(st);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        if (str[0].equals("N"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));

        int ind = 1;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (!str[ind].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(str[ind]));
                q.add(node.left);
            }
            ind++;

            if (!str[ind].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(str[ind]));
                q.add(node.right);
            }
            ind++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
