class Pair {
    int x;
    int y;
    int dist;

    Pair(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.dist - a.dist);
        for (int[] it : points) {
            int dist = it[0] * it[0] + it[1] * it[1];
            pq.add(new Pair(it[0], it[1], dist));
            if (pq.size() > k)
                pq.poll();
        }

        int[][] ans = new int[k][2];
        int j = 0;
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            ans[j++] = new int[] { top.x, top.y };
        }
        return ans;
    }
}
