class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> tempAns = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int j = 0; j < numCourses; j++) {
            if (indegree[j] == 0)
                q.add(j);
        }

        topoSort(q, adj, indegree, tempAns);

        if (tempAns.size() != numCourses)
            return new int[0];

        int[] topoAns = new int[numCourses];
        int k = 0;
        while (k < numCourses) {
            topoAns[k] = tempAns.get(k);
            k++;
        }
        return topoAns;
    }

    public void topoSort(
            Queue<Integer> q, List<List<Integer>> adj, int[] indegree, List<Integer> tempAns) {
        while (!q.isEmpty()) {
            int front = q.poll();
            tempAns.add(front);
            for (int neighbor : adj.get(front)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }
    }
}

