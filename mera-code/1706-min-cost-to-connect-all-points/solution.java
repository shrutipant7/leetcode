class Pair implements Comparable<Pair>{
    int vertex;
    int weight;
    
    public Pair(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
    
    public int compareTo(Pair that) {
        return this.weight - that.weight;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int cost = 0;
        int n = points.length;
        boolean[] vis = new boolean[n];
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i< n; i++) {
            List<Pair> neighbours = new ArrayList<>();
            for(int j=0; j< n; j++) {
                if(i==j) continue;
                int dist = getDistance(points[i], points[j]);
                neighbours.add(new Pair(j, dist));
            }
            adj.add(neighbours);
        }
        
        //Prim's algo
        PriorityQueue<Pair> q = new PriorityQueue<>();        
        q.offer(new Pair(0, 0));
        while(!q.isEmpty()) {
            Pair top = q.poll();
            if(vis[top.vertex]) continue;
            vis[top.vertex] = true;
            cost+=top.weight;
            for(Pair neigh : adj.get(top.vertex)) {
                if(!vis[neigh.vertex]) { //Prevents adding already processed node again
                    q.offer(new Pair(neigh.vertex, neigh.weight)); 
                }
            }
        }
        return cost;
    }
    
    static int getDistance(int[] p1, int[] p2) {
        int diff1 = Math.abs(p1[0]-p2[0]);
        int diff2 = Math.abs(p1[1]-p2[1]);
        return diff1 + diff2;
    }
}
