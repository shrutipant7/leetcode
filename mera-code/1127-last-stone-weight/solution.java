class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) pq.add(stone);
        int stone1 = 0;
        int stone2 = 0;
        while(pq.size() > 1) {
            stone1 = pq.poll(); //larger
            stone2 = pq.poll(); //smaller or equal
            if (stone1 != stone2) pq.add(stone1 - stone2);
        }
        return pq.peek() != null ? pq.peek() : 0;
    }
}
