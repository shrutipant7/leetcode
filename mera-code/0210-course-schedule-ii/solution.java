class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> tempAns = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        int[] indegree = new int[n];
         while(n > 0) {
            adj.add(new ArrayList<>());
            n--;
        }
        for(int i=0; i<prerequisites.length; i++) {
            int key = prerequisites[i][1];
            int value = prerequisites[i][0];
            adj.get(key).add(value);
        }
        for(int i=0; i< indegree.length; i++) {
            indegree[i] = 0;
        }
        for(List<Integer> list : adj) {
            for(Integer item : list) {
                indegree[item]+=1;
            }
        }
        bfs(adj, tempAns, indegree);
        return tempAns.size() !=  numCourses ? new int[0] : 
        tempAns.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static void bfs(List<List<Integer>> adj, List<Integer> tempAns, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()) {
            Integer top = q.poll();
            tempAns.add(top);
            for(Integer neighbour : adj.get(top)) {
                indegree[neighbour]-=1;
                if(indegree[neighbour] == 0) q.offer(neighbour);
            }
        }
    }
}
