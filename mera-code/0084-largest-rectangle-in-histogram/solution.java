class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int len = heights.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int top = st.pop();
                int lBound = st.isEmpty() ? -1 : st.peek();
                int curArea = (i - lBound - 1) * heights[top];
                maxArea = Math.max(maxArea, curArea);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int top = st.pop();
            int lBound = st.isEmpty() ? -1 : st.peek();
            int curArea = (len - lBound - 1) * heights[top];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
}
