class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        int answer = 0;
        int[] xDist = new int[n], yDist = new int[n], zDist = new int[n];
        Arrays.fill(xDist, -1);
        Arrays.fill(yDist, -1);
        Arrays.fill(zDist, -1);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int it[] : edges) {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();

        //Multi source BFS for x
        q.add(x);
        xDist[x] = 0;
        fillMultiSourceBFS(xDist, q, adj);

        //Multi source BFS for y
        q.add(y);
        yDist[y] = 0;
        fillMultiSourceBFS(yDist, q, adj);

        //Multi source BFS for z
        q.add(z);
        zDist[z] = 0;
        fillMultiSourceBFS(zDist, q, adj);

        //Check for pyth triplet for each u
        for (int u = 0; u < n; u++) {
            if (checkValidTriplet(xDist[u], yDist[u], zDist[u]))
                answer++;
        }
        return answer;
    }

    public boolean checkValidTriplet(int a, int b, int c) {
        if (a == -1 || b == -1 || c == -1)
            return false;
        int[] temp = new int[3];
        temp[0] = a;
        temp[1] = b;
        temp[2] = c;
        Arrays.sort(temp);
        return ((temp[0] * temp[0]) + (temp[1] * temp[1]) == (temp[2] * temp[2]));
    }

    public void fillMultiSourceBFS(int[] dist, Queue<Integer> q, List<List<Integer>> adj) {
        while (!q.isEmpty()) {
            int top = q.poll();
            for (int neigh : adj.get(top)) {
                if (dist[neigh] == -1) {
                    q.add(neigh);
                    dist[neigh] = dist[top] + 1;
                }
            }
        }
    }
}
