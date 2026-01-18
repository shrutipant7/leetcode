class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for (String op : operations) {
            if (op.equals("C")) {
                st.pop();
            } else if (op.equals("D")) {
                int top = st.peek();
                st.push(2 * top);
            } else if (op.equals("+")) {
                int top = st.pop();
                int next = st.peek();
                st.push(top);
                st.push(top + next);
            } else {
                st.push(Integer.parseInt(op));
            }
        }

        int ans = 0;
        while (!st.isEmpty())
            ans += st.pop();
        return ans;
    }
}
