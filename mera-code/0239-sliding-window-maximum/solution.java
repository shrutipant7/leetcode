class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length, it = 0;
        if (len == 1 || k == 1)
            return nums;

        int[] ans = new int[len - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++)
            pq.add(new int[] { nums[i], i });

        ans[it++] = pq.peek()[0];

        for (int end = k; end < len; end++) {
            while (pq.peek()[1] < end - k + 1)
                pq.poll();
            pq.add(new int[] { nums[end], end });
            ans[it++] = pq.peek()[0];
        }
        return ans;
    }
}
