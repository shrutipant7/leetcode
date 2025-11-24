class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Stack<Integer> st = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i])
                st.pop();
            st.push(nums[i]);
        }
        for (int i = len - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i])
                st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return ans;
    }
}

