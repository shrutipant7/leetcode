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

class BSTIteratorLeft {
    Stack<TreeNode> st;

    public BSTIteratorLeft(TreeNode root) {
        st = new Stack<>();
        pushAll(root, st);
    }

    public int next() {
        TreeNode top = st.pop();
        pushAll(top.right, st);
        return top.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void pushAll(TreeNode root, Stack<TreeNode> st) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}

class BSTIteratorRight {
    Stack<TreeNode> revSt;

    public BSTIteratorRight(TreeNode root) {
        revSt = new Stack<>();
        pushAll(root, revSt);
    }

    public int next() {
        TreeNode top = revSt.pop();
        pushAll(top.left, revSt);
        return top.val;
    }

    public boolean hasNext() {
        return !revSt.isEmpty();
    }

    public void pushAll(TreeNode root, Stack<TreeNode> revSt) {
        while (root != null) {
            revSt.push(root);
            root = root.right;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIteratorLeft left = new BSTIteratorLeft(root);
        BSTIteratorRight right = new BSTIteratorRight(root);
        int lNxt = left.next();
        int rNxt = right.next();
        while (lNxt < rNxt) {
            int sum = lNxt + rNxt;
            if (sum == k)
                return true;
            if (sum < k)
                lNxt = left.next();
            else
                rNxt = right.next();
        }
        return false;
    }
}
