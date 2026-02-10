class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int n : stones) {
            pq.add(n);
        }
        while (pq.size() >= 2) {
            int st1 = pq.poll();
            int st2 = pq.poll();
            if (st1 == st2)
                continue;
            else {
                pq.add(st1 - st2);
            }
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}
