
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        int dist;
        
        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
            
        public int compareTo(Pair that){
            if(this.dist > that.dist) return 1;
            else if(this.dist < that.dist) return -1;
            else {
                return this.x-that.x;
            }
        }
    }

class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i=0; i<points.length; i++){
            pq.add(new Pair(points[i][0], points[i][1], getDistanceFromOrigin(points[i])));
        }
        
        for(int i=0; i<k; i++){
            Pair cur = pq.remove();
            res[i] = new int[]{cur.x, cur.y};
        }
        return res;
    }
    
    static int getDistanceFromOrigin(int[] p1) {
        return p1[0]*p1[0] + p1[1]*p1[1];
    }
}
