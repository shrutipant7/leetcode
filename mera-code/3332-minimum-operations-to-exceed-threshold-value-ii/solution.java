class Solution {
    public int minOperations(int[] nums, int k) {
        long minOps = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i=0; i<nums.length; i++) {
            pq.add((long)nums[i]);
        }
        if (pq.size() < 2) return -1;
        while (pq.size() >= 2) {
            if ( pq.peek() >= k) return (int) minOps;
            long n1 = pq.poll();
            long n2 = pq.poll();
            pq.add((2 * Math.min(n1, n2) + Math.max(n1, n2)));
            minOps++;
        }
        return !pq.isEmpty() && pq.peek() >= k ? (int) minOps : -1;
    }
}
