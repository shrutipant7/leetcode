class Pair {
    int s;
    int e;

    Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) 1e9 + 7;
        long maxPerf = 0, totalSpeed = 0;
        List<Pair> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(new Pair(speed[i], efficiency[i]));
        }
        // First sort list by decreasing efficiency
        Collections.sort(ls, (a, b) -> b.e - a.e);

        // Use PQ to store engineer based on min speed
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.s - b.s);
        for (int i = 0; i < n; i++) {
            pq.add(ls.get(i));
            totalSpeed += ls.get(i).s;
            if (pq.size() > k) {
                Pair top = pq.poll();
                totalSpeed -= top.s;
            }
            maxPerf = Math.max(maxPerf, totalSpeed * ls.get(i).e);
        }
        return (int) (maxPerf % MOD);
    }
}
