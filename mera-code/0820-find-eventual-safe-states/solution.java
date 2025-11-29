class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ansList = new ArrayList<>();
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i])
                dfsCycle(i, ansList, vis, pathVis, graph);
        }

        Collections.sort(ansList);
        return ansList;
    }

    public boolean dfsCycle(
            int v, List<Integer> ansList, boolean[] vis, boolean[] pathVis, int[][] graph) {
        vis[v] = true;
        pathVis[v] = true;
        for (int neigh : graph[v]) {
            if (vis[neigh]) {
                if (pathVis[neigh])
                    return true;
                continue;
            }
            if (dfsCycle(neigh, ansList, vis, pathVis, graph))
                return true;
        }
        pathVis[v] = false;
        ansList.add(v);
        return false;
    }
}
