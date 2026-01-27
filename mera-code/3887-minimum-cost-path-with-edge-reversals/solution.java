class Pair {
    int w;
    int v;

    Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] it : edges) {
            adj.get(it[0]).add(new Pair(it[1], it[2]));
            adj.get(it[1]).add(new Pair(it[0], 2 * it[2]));
        }

        int[] dist = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            if (top.v == n - 1)
                return dist[top.v];
            if (dist[top.v] < top.w)
                continue;
            for (Pair neigh : adj.get(top.v)) {
                int accWt = neigh.w + top.w;
                if (dist[neigh.v] > accWt) {
                    dist[neigh.v] = accWt;
                    pq.add(new Pair(neigh.v, accWt));
                }
            }
        }

        return -1;
    }
}
