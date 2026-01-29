class Pair {
    int v;
    long w;

    Pair(int v, long w) {
        this.v = v;
        this.w = w;
    }
}

class Solution {
    public long minimumCost(String source, String target,
                            char[] original, char[] changed, int[] cost) {
        int n = source.length();
        if (n != target.length()) return -1;
        if (source.equals(target)) return 0;

        // Build graph
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            adj.get(u).add(new Pair(v, cost[i]));
        }

        // Precompute dist[from][to] for all 26 chars
        long[][] dist = new long[26][26];
        for (int c = 0; c < 26; c++) {
            dist[c] = dijkstraFrom(adj, c);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            char s = source.charAt(i), t = target.charAt(i);
            if (s == t) continue;
            int u = s - 'a', v = t - 'a';
            if (dist[u][v] == Long.MAX_VALUE) return -1;
            ans += dist[u][v];
        }
        return ans;
    }

    private long[] dijkstraFrom(List<List<Pair>> adj, int src) {
        long[] dist = new long[26];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));

        dist[src] = 0;
        pq.add(new Pair(src, 0L));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int u = top.v;
            long d = top.w;
            if (d > dist[u]) continue;

            for (Pair neigh : adj.get(u)) {
                int v = neigh.v;
                long nd = d + neigh.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new Pair(v, nd));
                }
            }
        }
        return dist;
    }
}

