class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length, it = 0;
        int[] ans = new int[len - k + 1];

        Deque<int[]> dq = new ArrayDeque<>();
        for (int end = 0; end < len; end++) {
            while (!dq.isEmpty() && dq.peekLast()[0] <= nums[end]) {
                dq.removeLast();
            }
            dq.addLast(new int[] { nums[end], end });
            if (dq.peekFirst()[1] < end - k + 1) {
                dq.removeFirst();
            }
            if (end >= k - 1)
                ans[it++] = dq.peekFirst()[0];
        }
        return ans;
    }
}
