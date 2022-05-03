class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length <= 1) return true;
        List<List<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        boolean[] recS = new boolean[numCourses];
        boolean[] vis = new boolean[numCourses];
        while(n > 0) {
            adj.add(new ArrayList<>());
            n--;
        }
        for(int i=0; i<prerequisites.length; i++) {
            int key = prerequisites[i][1];
            int value = prerequisites[i][0];
            adj.get(key).add(value);
        }
        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                if(dfsLoop(i, adj, vis, recS)) return false;
            }
        }
        return true;
    }
    
    static boolean dfsLoop(int V, List<List<Integer>> adj, boolean[] vis,  boolean[] recS) {
        vis[V] = true;
        recS[V] = true;
        for(Integer neighbour : adj.get(V)) {
            if(!vis[neighbour]) {
                if (dfsLoop(neighbour, adj, vis, recS)) return true;
            }
            else if(recS[neighbour]) return true;
        }        
        recS[V] = false;
        return false;       
    }
}
