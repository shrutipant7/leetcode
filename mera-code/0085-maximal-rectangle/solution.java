class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] intMat = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    intMat[j]++;
                } else
                    intMat[j] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(intMat));
        }
        return maxArea;
    }

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
